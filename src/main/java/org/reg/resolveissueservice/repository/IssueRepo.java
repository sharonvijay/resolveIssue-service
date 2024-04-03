package org.reg.resolveissueservice.repository;

import org.reg.resolveissueservice.entity.Issue;
import org.reg.resolveissueservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepo extends JpaRepository<Issue,Long> {
    List<Issue> findByRaisedBy(User raisedBy);
}
