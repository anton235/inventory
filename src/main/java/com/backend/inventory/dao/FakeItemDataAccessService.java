package com.backend.inventory.dao;

import com.backend.inventory.model.Item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeItemDataAccessService implements ItemDao {

    private static List<Item> DB = new ArrayList<>();

    @Override
    public int insertItem(UUID inventoryCode, Item item) {
        DB.add(new Item(item.getNumber(), item.getName(), item.getAmount(), inventoryCode));
        return 1;
    }

    @Override
    public List<Item> selectAllItems() {
        return DB;
    }

    @Override
    public Optional<Item> selectItemByInventoryCode(UUID inventoryCode) {
        return DB.stream().filter(item -> item.getInventoryCode().equals(inventoryCode)).findFirst();
    }

    @Override
    public Optional<Item> selectItemByNumber(Integer number) {
        return DB.stream().filter(item -> item.getNumber().equals(number)).findFirst();
    }

    @Override
    public Optional<Item> selectItemByName(String name) {
        return DB.stream().filter(item -> item.getName().equals(name)).findFirst();
    }

    @Override
    public int deleteItemByNumber(Integer number) {
        Optional<Item> itemToDelete = selectItemByNumber(number);
        if (itemToDelete.isEmpty()) {
            return 0;
        }
        DB.remove(itemToDelete.get());
        return 1;
    }

    @Override
    public int updateItemByNumber(Integer number, Item update) {
        return selectItemByNumber(number).map(itm -> {
            int indexOfItemToUpdate = DB.indexOf(itm);
            if (indexOfItemToUpdate >= 0) {
                DB.set(indexOfItemToUpdate,
                        new Item(number, itm.getName(), update.getAmount(), itm.getInventoryCode()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
