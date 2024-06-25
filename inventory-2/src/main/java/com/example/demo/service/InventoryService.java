package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository InventoryRepository;

    public List<Inventory> getAllInventories() {
        return InventoryRepository.findAll();
    }

    public Inventory updateInventory(Inventory inventory) {
        return InventoryRepository.save(inventory);
    }
    
    public Inventory saveInventory(Inventory inventory) {
        return InventoryRepository.save(inventory);
    }
    public Inventory createInventory(Inventory inventory) {
        return InventoryRepository.save(inventory);
    }
}
