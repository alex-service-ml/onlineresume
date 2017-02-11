package me.onlineresu.dto;

import java.util.Collection;

public class ResumeDTO {

    private PersonalDetailsDTO personalDetails;
    private Collection<ExperienceSectionDTO> experienceSections;
    private Collection<SchoolSectionDTO> schoolSections;
    private Collection<SkillSectionDTO> skillSections;

    public PersonalDetailsDTO getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsDTO personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Collection<ExperienceSectionDTO> getExperienceSections() {
        return experienceSections;
    }

    public void setExperienceSections(Collection<ExperienceSectionDTO> experienceSections) {
        this.experienceSections = experienceSections;
    }

    public Collection<SchoolSectionDTO> getSchoolSections() {
        return schoolSections;
    }

    public void setSchoolSections(Collection<SchoolSectionDTO> schoolSections) {
        this.schoolSections = schoolSections;
    }

    public Collection<SkillSectionDTO> getSkillSections() {
        return skillSections;
    }

    public void setSkillSections(Collection<SkillSectionDTO> skillSections) {
        this.skillSections = skillSections;
    }
}
