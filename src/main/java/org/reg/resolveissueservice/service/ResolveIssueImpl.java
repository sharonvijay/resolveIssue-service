package org.reg.resolveissueservice.service;

import org.reg.resolveissueservice.entity.Admin;
import org.reg.resolveissueservice.entity.Issue;
import org.reg.resolveissueservice.repository.AdminRepo;
import org.reg.resolveissueservice.repository.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ResolveIssueImpl implements IResolveIssueService{
    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private AdminRepo adminRepo;
    @Override
    public void acceptIssue(Issue issue) {
        issue.setStatus("In Process");
        issueRepo.save(issue);
    }
    @Override
    public void resolveIssue(Issue issue) {
        issue.setStatus("Resolved");
        issueRepo.save(issue);
    }
    @Override
    public List<Issue> getAllIssue() {
        return issueRepo.findAll();
    }

    @Override
    public Issue getIssueById(Long id) {
        return issueRepo.findById(id).orElse(null);
    }

    @Override
    public String getIssueStatus(Long id) {
        Optional<Issue> optionalIssue = issueRepo.findById(id);
        if(optionalIssue.isPresent())
        {
            Issue issue = optionalIssue.get();
            String status = issue.getStatus();
            return status;
        }
        return "Issue Not Found";
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepo.findById(id).orElse(null);
    }
}
