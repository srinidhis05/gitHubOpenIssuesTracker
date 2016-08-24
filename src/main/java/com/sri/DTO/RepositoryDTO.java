package com.sri.DTO;

/**
 * Created by srinidhis on 21/08/16.
 */
//The repository DTO class ,basic fields are now implemneted all fields can be used depending on usage
public class RepositoryDTO {
    private String name;
    private String description;
    private int open_issues_count;
    private boolean has_issues;

    public boolean hasIssues() {
        return has_issues;
    }

    public void setHas_issues(boolean has_issues) {
        this.has_issues = has_issues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }
}
