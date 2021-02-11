package com.backend.inventory.api;

import java.util.List;

import com.backend.inventory.model.Item;
import com.backend.inventory.service.ItemService;
import com.backend.inventory.dao.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/items")
@RestController
public class ItemController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        Item newItem = itemRepository.save(item);
        itemService.addItem(newItem);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // http://localhost:8083/api/v1/items/names/cat
    @GetMapping(path = "names/{name}")
    public Item getItemByName(@PathVariable("name") String name) {
        return itemService.getItemByName(name).orElse(null);
    }

    // http://localhost:8083/api/v1/items/1
    @GetMapping(path = "{number}")
    public Item getItemByNumber(@PathVariable("number") Integer number) {
        return itemService.getItemByNumber(number).orElse(null);
    }

    @DeleteMapping(path = "{number}")
    public void deleteItemByNumber(@PathVariable("number") Integer number) {
        itemService.deleteItem(number);
    }

    @PutMapping(path = "{number}")
    public void updateItem(@PathVariable("number") Integer number, @RequestBody Item itemToUpdate) {
        itemService.updateItem(number, itemToUpdate);
    }

    // @PutMapping(path = "{number}")
    // public void updateItemAmountByNumber(@PathVariable("number") Integer number,
    // @RequestBody Integer newAmount) {
    // itemService.updateItemAmountByNumber(number, newAmount);
    // }
}
