package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Item;
import Project3.com.welcome_home.model.CategoryDT;
import Project3.com.welcome_home.model.ItemDT;
import Project3.com.welcome_home.repositories.ItemInRepository;
import Project3.com.welcome_home.repositories.ItemRepository;
import Project3.com.welcome_home.repositories.OrderedRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final OrderedRepository orderedRepository;
    private final ItemInRepository itemInRepository;

    public ItemService(ItemRepository itemRepository, OrderedRepository orderedRepository, ItemInRepository itemInRepository) {
        this.itemRepository = itemRepository;
        this.orderedRepository = orderedRepository;
        this.itemInRepository = itemInRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Integer itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public List<ItemDT> getItemsByCategoryAndSubcategory(List<CategoryDT> categories) {
        HashMap<Integer, ItemDT> items = new HashMap<>();
        for (CategoryDT category : categories) {
            String mainCategory = category.getMainCategory();
            String subCategory = category.getSubCategory();
            Optional<List<Item>> optionalItems = itemRepository.findItemByMainCategoryAndSubCategory(mainCategory, subCategory);
            if(optionalItems.isPresent()) {
                List<Item> itemList = optionalItems.get();
                for (Item item : itemList) {
                    if(itemInRepository.findByItemID(item.getItemID()).isPresent()) {
                        continue;
                    }
                    if(!items.containsKey(item.getItemID())){
                        ItemDT itemDT = convertItemDTO(item);
                        items.put(item.getItemID(), itemDT);
                    }
                }
            }
        }
        return new ArrayList<>(items.values());
    }

    public ItemDT convertItemDTO(Item item) {
        ItemDT itemDT = new ItemDT();
        itemDT.ItemId = item.getItemID();
        itemDT.iDescription = item.getiDescription();
        itemDT.color = item.getColor();
        itemDT.hasPieces = item.getHasPieces();
        itemDT.isNew = item.getIsNew();
        itemDT.material = item.getMaterial();
        itemDT.mainCategory = item.getCategory().getMainCategory();
        itemDT.subCategory = item.getCategory().getSubCategory();
        itemDT.photo = item.getPhoto();
        return itemDT;
    }
}
