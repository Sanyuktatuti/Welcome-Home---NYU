package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.ItemIn;
import Project3.com.welcome_home.model.ItemOrderDT;
import Project3.com.welcome_home.services.ItemInService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/itemins")
public class ItemInController {

    private final ItemInService itemInService;

    public ItemInController(ItemInService itemInService) {
        this.itemInService = itemInService;
    }

    @GetMapping
    public List<ItemIn> getAllItemIns() {
        return itemInService.getAllItemIns();
    }

    @GetMapping("/{itemID}/{orderID}")
    public Optional<ItemIn> getItemIn(@PathVariable Integer itemID, @PathVariable Integer orderID) {
        return itemInService.getItemIn(itemID, orderID);
    }

    @PostMapping
    public ItemIn createItemIn(@RequestBody ItemIn itemIn) {
        return itemInService.saveItemIn(itemIn);
    }

    @DeleteMapping("/{itemID}/{orderID}")
    public void deleteItemIn(@PathVariable Integer itemID, @PathVariable Integer orderID) {
        itemInService.deleteItemIn(itemID, orderID);
    }

    @PostMapping("/addItemInOrder")
    public Map<Boolean, String> addItemInOrder(@RequestBody ItemOrderDT itemOrderDT) {
        return itemInService.addItemInOrder(itemOrderDT);
    }
}
