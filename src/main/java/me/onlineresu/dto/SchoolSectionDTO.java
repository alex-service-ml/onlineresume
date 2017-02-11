package me.onlineresu.dto;

import java.util.Collection;
import java.util.Date;

public class SchoolSectionDTO extends SectionDTO{

    private String gpa;
    private Date startDate;
    private Date endDate;
    private Collection<ClassDTO> classes;

    private Collection<String> awards;

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

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

    public Collection<ClassDTO> getClasses() {
        return classes;
    }

    public void setClasses(Collection<ClassDTO> classes) {
        this.classes = classes;
    }

    public Collection<String> getAwards() {
        return awards;
    }

    public void setAwards(Collection<String> awards) {
        this.awards = awards;
    }
}
