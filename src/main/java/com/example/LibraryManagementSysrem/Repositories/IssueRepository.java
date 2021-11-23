package com.example.LibraryManagementSysrem.Repositories;

import com.example.LibraryManagementSysrem.Entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
    List<Issue> getIssueByUserIdAndReturnDateIsNull(Long userid);
}
