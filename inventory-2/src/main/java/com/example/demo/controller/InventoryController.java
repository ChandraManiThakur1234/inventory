package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService InventoryService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Inventory> getAllInventories() {
        return InventoryService.getAllInventories();
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return InventoryService.updateInventory(inventory);
    }
    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return InventoryService.createInventory(inventory);
    }
}
