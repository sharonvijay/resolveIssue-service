package org.reg.resolveissueservice.service;

import org.reg.resolveissueservice.entity.Admin;
import org.reg.resolveissueservice.entity.Issue;

import java.util.List;

public interface IResolveIssueService {
    public List<Issue> getAllIssue();
    public Issue getIssueById(Long id);
    public void acceptIssue(Issue issue);

    public void resolveIssue(Issue issue);

    public  String getIssueStatus(Long id);
    public Admin getAdminById(Long id);
}
