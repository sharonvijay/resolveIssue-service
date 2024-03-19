package org.reg.resolveissueservice.repository;

import org.reg.resolveissueservice.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepo extends JpaRepository<Issue,Long> {
}
