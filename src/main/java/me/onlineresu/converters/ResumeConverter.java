package me.onlineresu.converters;

import me.onlineresu.data.models.ExperienceSectionModel;
import me.onlineresu.data.models.ResumeModel;

import me.onlineresu.data.models.SchoolSectionModel;
import me.onlineresu.data.models.SkillSectionModel;
import me.onlineresu.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResumeConverter implements Converter<ResumeModel, ResumeDTO>{


    private final PersonalDetailsConverter personalDetailsConverter;
    private final SchoolSectionConverter schoolSectionConverter;
    private final ExperienceSectionConverter experienceSectionConverter;
    private final SkillConverter skillSectionConverter;

    @Autowired
    public ResumeConverter(PersonalDetailsConverter personalDetailsConverter, SchoolSectionConverter schoolSectionConverter, ExperienceSectionConverter experienceSectionConverter, SkillConverter skillConverter) {
        this.personalDetailsConverter = personalDetailsConverter;
        this.schoolSectionConverter = schoolSectionConverter;
        this.experienceSectionConverter = experienceSectionConverter;
        this.skillSectionConverter = skillConverter;
    }


    @Override
    public ResumeDTO convert(ResumeModel resumeModel) {

        ResumeDTO dto = new ResumeDTO();

        dto.setPersonalDetails(personalDetailsConverter.convert(resumeModel.getPersonalDetails()));

        ArrayList<ExperienceSectionDTO> experienceSections = new ArrayList<>();
        ArrayList<SchoolSectionDTO> schoolSections = new ArrayList<>();
        ArrayList<SkillSectionDTO> skillSections = new ArrayList<>();

        resumeModel.getSections().forEach(sectionModel -> {
            //TODO: Figure out a generic approach
            if (sectionModel instanceof SchoolSectionModel) {
                schoolSections.add(schoolSectionConverter.convert((SchoolSectionModel)sectionModel));
            } else if (sectionModel instanceof ExperienceSectionModel) {
                experienceSections.add(experienceSectionConverter.convert((ExperienceSectionModel)sectionModel));
            } else if (sectionModel instanceof SkillSectionModel) {
                skillSections.add(skillSectionConverter.convert((SkillSectionModel)sectionModel));
            }
        });


        dto.setSkillSections(skillSections);
        dto.setSchoolSections(schoolSections);
        dto.setExperienceSections(experienceSections);
        return dto;
    }
}
