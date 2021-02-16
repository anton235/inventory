package com.backend.inventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.inventory.model.Item;

public interface ItemDao {
    default int insertItem(Item item) {
        return insertItem(item);
    }

    List<Item> selectAllItems();

    Optional<Item> selectItemByInventoryCode(UUID inventoryCode);

    Optional<Item> selectItemByNumber(Integer number);

    Optional<Item> selectItemByName(String name);

    int deleteItemByNumber(Integer number);

    int updateItemByNumber(Integer number, Item item);

    int withdrawalItemAmountByNumber(Integer number, Integer withdrawalAmount);

    int depositItemAmountByNumber(Integer number, Integer depositAmount);
}
