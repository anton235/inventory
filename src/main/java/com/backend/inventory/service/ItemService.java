package com.backend.inventory.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.inventory.dao.ItemDao;
import com.backend.inventory.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemService(@Qualifier("fakeDao") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public int addItem(Item item) {
        return itemDao.insertItem(item);
    }

    public List<Item> getAllItems() {
        return itemDao.selectAllItems();
    }

    public Optional<Item> getItemByInventoryCode(UUID inventoryCode) {
        return itemDao.selectItemByInventoryCode(inventoryCode);
    }

    public Optional<Item> getItemByName(String name) {
        return itemDao.selectItemByName(name);
    }

    public Optional<Item> getItemByNumber(Integer number) {
        return itemDao.selectItemByNumber(number);
    }

    public int deleteItem(Integer number) {
        return itemDao.deleteItemByNumber(number);
    }

    public int updateItem(Integer number, Item item) {
        return itemDao.updateItemByNumber(number, item);
    }

    public int withdrawalItemAmount(Integer number, Integer withdrawalAmount) {
        return itemDao.withdrawalItemAmountByNumber(number, withdrawalAmount);
    }

    public int depositItemAmount(Integer number, Integer depositAmount) {
        return itemDao.depositItemAmountByNumber(number, depositAmount);
    }
}
