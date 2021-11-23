package com.example.LibraryManagementSysrem.Repositories;

import com.example.LibraryManagementSysrem.Entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

     Inventory findByItemId(Long itemId);

     Inventory getByItemId(Long itemId);
}
