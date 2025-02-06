package Project3.com.welcome_home.services;

import Project3.com.welcome_home.commons.Constants;
import Project3.com.welcome_home.entities.*;
import Project3.com.welcome_home.model.ItemOrderDT;
import Project3.com.welcome_home.repositories.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemInService {

    private final ItemInRepository itemInRepository;
    private final OrderedRepository orderedRepository;
    private final ActRepository actRepository;
    private final PersonRepository personRepository;
    private final ItemRepository itemRepository;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ItemInService(ItemInRepository itemInRepository, OrderedRepository orderedRepository, ActRepository actRepository,
                         PersonRepository personRepository, ItemRepository itemRepository) {
        this.itemInRepository = itemInRepository;
        this.orderedRepository = orderedRepository;
        this.actRepository = actRepository;
        this.personRepository = personRepository;
        this.itemRepository = itemRepository;
    }

    public List<ItemIn> getAllItemIns() {
        return itemInRepository.findAll();
    }

    public Optional<ItemIn> getItemIn(Integer itemID, Integer orderID) {
        // Create ItemInId object
        ItemInId id = new ItemInId(itemID, orderID);
        return itemInRepository.findById(id);
    }

    public ItemIn saveItemIn(ItemIn itemIn) {
        return itemInRepository.save(itemIn);
    }

    public void deleteItemIn(Integer itemID, Integer orderID) {
        // Create ItemInId object
        ItemInId id = new ItemInId(itemID, orderID);
        itemInRepository.deleteById(id);
    }

    public Map<Boolean, String > addItemInOrder(ItemOrderDT itemOrderDT) {
        try {
            objectMapper.writeValueAsString(itemOrderDT);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        HashMap map = new HashMap<Boolean, String>();
        Ordered ordered = new Ordered();
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        ordered.setOrderDate(sqlDate);
        ordered.setOrderNotes(itemOrderDT.notes);
        Optional<List<Act>> clientAct = actRepository.findByUserName(itemOrderDT.client);
        if(clientAct.isPresent()) {
            for (Act act : clientAct.get()) {
                if(act.getRoleID().equals(Constants.donorKey)) {
                    Person person = personRepository.findPersonByUserName(act.getUserName()).get();
                    ordered.setClient(person);
                }
            }
            if(ordered.getClient() == null) {
                map.put(false, "The client is not donor.");
                return map;
            }
        } else {
            map.put(false, "No such client person.");
            return map;
        }
        Optional<List<Act>> staffAct = actRepository.findByUserName(itemOrderDT.supervisor);
        if(staffAct.isPresent()) {
            for (Act act : staffAct.get()) {
                if(act.getRoleID().equals(Constants.staffKey)) {
                    Person person = personRepository.findPersonByUserName(act.getUserName()).get();
                    ordered.setSupervisor(person);
                }
            }
            if(ordered.getSupervisor() == null) {
                map.put(false, "The client is not staff member.");
                return map;
            }
        } else {
            map.put(false, "No such staff person.");
            return map;
        }
        Ordered savedOrdered = orderedRepository.save(ordered);
        ItemIn itemIn = new ItemIn();
        itemIn.setOrderID(savedOrdered.getOrderID());
        itemIn.setItemID(itemOrderDT.ItemID);
        itemIn.setOrdered(ordered);
        Optional<Item> itemOptional = itemRepository.findByItemID(itemOrderDT.ItemID);
        if(itemOptional.isPresent()) {
            itemIn.setItem(itemOptional.get());
        } else {
            map.put(false, "The item is not found.");
        }
        itemInRepository.save(itemIn);
        map.put(true, "The order has been placed successfully.");
        return map;
    }
}
