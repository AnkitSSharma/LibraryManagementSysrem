package com.example.LibraryManagementSysrem.Controllers;

import com.example.LibraryManagementSysrem.Entities.Inventory;
import com.example.LibraryManagementSysrem.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InventoryController {
    @Autowired
    private InventoryService service;

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory(){
        return service.findAll();
    }

    @GetMapping("/inventory/{itemId}")
    public Inventory getInventoryById(@PathVariable Long itemId){
        return service.findByItemId(itemId);
    }

    @PostMapping("/admin/inventory/{itemId}")
    public void updateInventory(@PathVariable Long itemId, @RequestParam("inventory") Long inventory){
        service.addOrRemoveInventory(itemId,inventory);
    }

}
