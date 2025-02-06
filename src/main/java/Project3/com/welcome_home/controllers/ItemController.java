package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Item;
import Project3.com.welcome_home.model.CategoryDT;
import Project3.com.welcome_home.model.ItemDT;
import Project3.com.welcome_home.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Integer itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping("/filter")
    public List<ItemDT> getItemsByCategoryAndSubcategory(@RequestBody List<CategoryDT> categories) {
        return itemService.getItemsByCategoryAndSubcategory(categories);
    }
}
