package me.onlineresu.dto;

import java.util.Collection;
import java.util.Date;

public class ExperienceSectionDTO extends SectionDTO{
    private Date startDate;
    private Date endDate;
    private String jobTitle;
    private Collection<String> tasks;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Collection<String> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<String> tasks) {
        this.tasks = tasks;
    }
}
