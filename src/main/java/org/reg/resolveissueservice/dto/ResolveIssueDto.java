package org.reg.resolveissueservice.dto;

import lombok.Data;

@Data
public class ResolveIssueDto {
    private Long id;
    private String name;
    private String status;
    private String resolvedBy;
}
