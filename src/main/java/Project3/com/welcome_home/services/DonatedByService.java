package Project3.com.welcome_home.services;

import Project3.com.welcome_home.commons.Constants;
import Project3.com.welcome_home.entities.*;
import Project3.com.welcome_home.model.Donation;
import Project3.com.welcome_home.model.ItemPiece;
import Project3.com.welcome_home.model.Query4b;
import Project3.com.welcome_home.repositories.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DonatedByService {

    private final DonatedByRepository donatedByRepository;
    private final ItemRepository itemRepository;
    private final PieceRepository pieceRepository;
    private final PersonRepository personRepository;
    private final ActRepository actRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;

    public DonatedByService(DonatedByRepository donatedByRepository, ItemRepository itemRepository, PieceRepository pieceRepository, PersonRepository personRepository, ActRepository actRepository
    , CategoryRepository categoryRepository, LocationRepository locationRepository) {
        this.donatedByRepository = donatedByRepository;
        this.itemRepository = itemRepository;
        this.pieceRepository = pieceRepository;
        this.personRepository = personRepository;
        this.actRepository = actRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
    }

    public List<DonatedBy> getAllDonations() {
        return donatedByRepository.findAll();
    }

    public Optional<DonatedBy> getDonation(Integer itemID, String userName) {
        // Create DonatedById object
        DonatedById id = new DonatedById(itemID, userName);
        return donatedByRepository.findById(id);
    }

    public DonatedBy saveDonation(DonatedBy donatedBy) {
        return donatedByRepository.save(donatedBy);
    }

    public void deleteDonation(Integer itemID, String userName) {
        // Create DonatedById object
        DonatedById id = new DonatedById(itemID, userName);
        donatedByRepository.deleteById(id);
    }

    public Map<Boolean, String> madeADonation(Donation donation) throws Exception {
        HashMap map = new HashMap<>();
        Optional<String> personOptional = personRepository.findByUserName(donation.getUserName());
        if(personOptional.isEmpty()){
            map.put(false, "No person found with this username found.");
            return map;
        }
        String personUsrName = personOptional.get();
        Optional<List<Query4b>> rolesOpt = actRepository.findRoleIDListByUserName(personUsrName);
        if(rolesOpt.isEmpty()){
            map.put(false, "No roles found for this username.");
            return map;
        }
        List<Query4b> roles = rolesOpt.get();
        for(Query4b role : roles){
            System.out.println(role.toString());
            if(role.getRoleID().equals(Constants.donorKey)){
                Item item = createItem(donation);
                System.out.println(item.toString());
                Item savedItem = itemRepository.save(item);
                int itemId = savedItem.getItemID();
                if(savedItem.getHasPieces() == true){
                    List<Piece> pieces = createPieces(donation, itemId);
                    for(Piece piece : pieces){
                        pieceRepository.save(piece);
                    }
                }
                map.put(true, "Successfully added item.");
                return map;
            }
        }
        map.put(false, "No, this user is not a donor.");
        return map;
    }

    Item createItem(Donation donation) {
        Item item = new Item();
        item.setiDescription(donation.getIDescription());
        item.setPhoto(donation.getPhoto());
        item.setColor(donation.getColor());
        item.setIsNew(donation.getIsNew() == null ? true : donation.getIsNew());
        item.setHasPieces(donation.getHasPieces() == null ? false : donation.getHasPieces());
        item.setMaterial(donation.getMaterial());
        Category category = new Category();
        category.setMainCategory(donation.getMainCategory());
        category.setSubCategory(donation.getSubCategory());
        Optional<Category> categoryOptional = categoryRepository.findByMainCategoryAndSubCategory(category.getMainCategory(), category.getSubCategory());
        if(categoryOptional.isEmpty()){
            categoryRepository.save(category);
        }
        item.setCategory(category);
        return item;
    }

    List<Piece> createPieces(Donation donation, int itemId) {
        List<Piece> pieces = new ArrayList<>();
        List<ItemPiece> itemPieces = donation.getPieces();
        int counter = 0;
        for(ItemPiece itemPiece : itemPieces) {
            Piece piece = new Piece();
            piece.setItemID(itemId);
            piece.setPieceNum(counter);
            counter++;
            piece.setpDescription(itemPiece.getPDescription());
            piece.setLength(itemPiece.getLength());
            piece.setWidth(itemPiece.getWidth());
            piece.setHeight(itemPiece.getHeight());
            Location location = new Location();
            location.setRoomNum(itemPiece.roomNum);
            location.setShelfNum(itemPiece.shelfNum);
            Optional<Location> optionalLocation = locationRepository.findByRoomNumAndShelfNum(itemPiece.roomNum, itemPiece.shelfNum);
            if(optionalLocation.isEmpty()){
                locationRepository.save(location);
            }
            piece.setLocation(location);
            piece.setpNotes(itemPiece.getPNotes());
            pieces.add(piece);
        }
        return pieces;
    }
}
