package com.example.LibraryManagementSysrem.Services;

import com.example.LibraryManagementSysrem.Entities.Inventory;
import com.example.LibraryManagementSysrem.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {
    @Autowired
    private InventoryRepository repository;

    public List<Inventory> findAll(){
        return repository.findAll();
    }
    public Inventory findByItemId(Long id){
        return repository.findByItemId(id);
    }

    public void addOrRemoveInventory(Long itemId, Long inventory) {
        Inventory currentObject = repository.findByItemId(itemId);
        if(currentObject == null){
            currentObject = new Inventory(itemId,inventory);
        }
        else {
            currentObject.setInventory(inventory + currentObject.getInventory());
        }
        repository.save(currentObject);
    }
}