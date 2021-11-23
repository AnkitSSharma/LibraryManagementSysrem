package com.example.LibraryManagementSysrem.Controllers;

import com.example.LibraryManagementSysrem.Entities.Issue;
import com.example.LibraryManagementSysrem.Services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueController {
    @Autowired
    private IssueService service;

    @GetMapping("/admin/issue/{itemId}")
    public String issueBook(@RequestParam("quantity") int quantity, @RequestParam("username") String username, @PathVariable("itemId") Long itemId) {
        return service.issueBook(quantity,username, itemId);
    }
    @GetMapping("/admin/return/{issueId}")
    public String returnBook(@RequestParam("quantity") int quantity, @PathVariable("issueId") Long issueId){
        return service.returnBook(quantity, issueId);
    }
    @GetMapping("/admin/listofissue")
    public List <Issue> listAllIssue(@RequestParam("username") String username){
        return service.listAllIssue(username);
    }
}
