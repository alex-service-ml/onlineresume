package me.onlineresu.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@DiscriminatorColumn(name = "school")
public class SchoolSectionModel extends SectionModel {

    private String gpa;
    private Date startDate;
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<ClassModel> classes;

    @ElementCollection
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

    public Collection<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(Collection<ClassModel> classes) {
        this.classes = classes;
    }

    public Collection<String> getAwards() {
        return awards;
    }

    public void setAwards(Collection<String> awards) {
        this.awards = awards;
    }

}
