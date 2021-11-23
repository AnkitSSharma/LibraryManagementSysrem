package com.example.LibraryManagementSysrem.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
public class Issue {
    public enum IssueStatus{
        ISSUED,
        RETURNED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "returned_quantity")
    private int returnedQuantity;
    @Column(name = "issue_date")
    private LocalDateTime issueDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @Column(name = "status")
    private IssueStatus status;

    public Issue() {
    }

    public Issue(Long itemId, Long userId, int quantity, int returnedQuantity, LocalDateTime issueDate, LocalDateTime returnDate, IssueStatus status) {
        this.itemId = itemId;
        this.userId = userId;
        this.quantity = quantity;
        this.returnedQuantity = returnedQuantity;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReturnedQuantity() {
        return returnedQuantity;
    }

    public void setReturnedQuantity(int returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }
}
