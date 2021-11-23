package com.example.LibraryManagementSysrem.Services;

import com.example.LibraryManagementSysrem.Entities.Inventory;
import com.example.LibraryManagementSysrem.Entities.Issue;
import com.example.LibraryManagementSysrem.Entities.User;
import com.example.LibraryManagementSysrem.Repositories.InventoryRepository;
import com.example.LibraryManagementSysrem.Repositories.IssueRepository;
import com.example.LibraryManagementSysrem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private UserRepository userRepository;
    public String issueBook(int quantity, String username, Long itemId) {
        Issue newEntry = new Issue();
        User user = userRepository.getByName(username);
        newEntry.setItemId(itemId);
        newEntry.setQuantity(quantity);
        newEntry.setIssueDate(LocalDateTime.now());
        newEntry.setStatus(Issue.IssueStatus.ISSUED);
        newEntry.setUserId(user.getId());
        Inventory inventory = inventoryRepository.getByItemId(itemId);
        inventory.setInventory(inventory.getInventory()-quantity);
        inventoryRepository.save(inventory);
        issueRepository.save(newEntry);
        return quantity + " Books Issued";
    }


    public String returnBook(int quantity, Long issueId) {
        Issue updateEntry = issueRepository.getById(issueId);
        if(updateEntry.getReturnedQuantity()+quantity> updateEntry.getQuantity()){
            return "Can't return more than Issued";
        }

        updateEntry.setReturnedQuantity(quantity+ updateEntry.getReturnedQuantity());

        if(updateEntry.getReturnedQuantity()+quantity== updateEntry.getQuantity()) {
            updateEntry.setReturnDate(LocalDateTime.now());
            updateEntry.setStatus(Issue.IssueStatus.RETURNED);
        }
        Inventory inventory = inventoryRepository.getByItemId(updateEntry.getItemId());
        inventory.setInventory(inventory.getInventory()+quantity);
        inventoryRepository.save(inventory);
        issueRepository.save(updateEntry);
        return quantity + " Books Returned";
    }

    public List<Issue> listAllIssue(String username) {
        User user = userRepository.getByName(username);
        return issueRepository.getIssueByUserIdAndReturnDateIsNull(user.getId());
    }
}
