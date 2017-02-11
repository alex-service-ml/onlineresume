package me.onlineresu.data.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ResumeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonalDetailsModel personalDetails;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "resume_section", joinColumns = @JoinColumn(name = "resume_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "section_id", referencedColumnName = "id"))
    private Collection<SectionModel> sections;

    public PersonalDetailsModel getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsModel personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Collection<SectionModel> getSections() {
        return sections;
    }

    public void setSections(Collection<SectionModel> sections) {
        this.sections = sections;
    }

    public long getId() {
        return id;
    }

}
