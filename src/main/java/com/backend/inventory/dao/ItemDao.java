package com.backend.inventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.inventory.model.Item;

public interface ItemDao {
    int insertItem(UUID inventoryCode, Item item);

    default int insertItem(Item item) {
        UUID inventoryCode = UUID.randomUUID();
        return insertItem(inventoryCode, item);
    }

    List<Item> selectAllItems();

    Optional<Item> selectItemByInventoryCode(UUID inventoryCode);

    Optional<Item> selectItemByNumber(Integer number);

    Optional<Item> selectItemByName(String name);

    int deleteItemByNumber(Integer number);

    int updateItemByNumber(Integer number, Item item);
}
