package org.reg.resolveissueservice.controller;

import org.reg.resolveissueservice.dto.AcceptIssueDto;
import org.reg.resolveissueservice.dto.IssueResolve;
import org.reg.resolveissueservice.dto.ResolveIssueDto;
import org.reg.resolveissueservice.entity.Admin;
import org.reg.resolveissueservice.entity.Issue;
import org.reg.resolveissueservice.repository.AdminRepo;
import org.reg.resolveissueservice.repository.IssueRepo;
import org.reg.resolveissueservice.service.IResolveIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResolveIssueController {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private IResolveIssueService resolveIssueService;

    @GetMapping("/acceptIssue")
    public ResponseEntity<AcceptIssueDto> acceptIssue(@RequestBody IssueResolve issueResolve) {
        Optional<Issue> optionalIssue = issueRepo.findById(issueResolve.getIssueId());
        Optional<Admin> optionalAdmin = adminRepo.findById(issueResolve.getAdminId());

        AcceptIssueDto acceptIssueDto;
        if (optionalIssue.isPresent() && optionalAdmin.isPresent()) {
            Issue issue = optionalIssue.get();
            Admin admin = optionalAdmin.get();

            issue.setResolvedBy(admin.getName());

            resolveIssueService.acceptIssue(issue);

            acceptIssueDto = new AcceptIssueDto();
            acceptIssueDto.setId(issue.getId());
            acceptIssueDto.setName(issue.getName());
            acceptIssueDto.setStatus(issue.getStatus());

        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(acceptIssueDto);
    }

    @GetMapping("/issueStatus/{id}")
    public ResponseEntity<String> getIssueStatus(@PathVariable Long id)
    {
        String status = resolveIssueService.getIssueStatus(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/resolveIssue")
    public ResponseEntity<ResolveIssueDto> resolveIssue(@RequestBody IssueResolve issueResolve)
    {
        Optional<Issue> optionalIssue = issueRepo.findById(issueResolve.getIssueId());
        Optional<Admin> optionalAdmin = adminRepo.findById(issueResolve.getAdminId());

        ResolveIssueDto resolveIssueDto;

        if(optionalIssue.isPresent() && optionalAdmin.isPresent())
        {
            Issue issue = optionalIssue.get();
            Admin admin = optionalAdmin.get();

            issue.setResolvedBy(admin.getName());

            resolveIssueService.resolveIssue(issue);

            resolveIssueDto = new ResolveIssueDto();
            resolveIssueDto.setId(issue.getId());
            resolveIssueDto.setName(issue.getName());
            resolveIssueDto.setResolvedBy(admin.getName());
            resolveIssueDto.setStatus(issue.getStatus());

        }
        else
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resolveIssueDto);
    }

    @GetMapping("/getAllIssues")
    public List<Issue> getAllIssues()
    {
        return resolveIssueService.getAllIssue();
    }

    @GetMapping("/getIssue/{id}")
    public Issue getIssueById(@PathVariable Long id)
    {
        return resolveIssueService.getIssueById(id);
    }
}
