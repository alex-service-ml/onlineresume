package me.onlineresu.converters;

import me.onlineresu.data.models.ExperienceSectionModel;
import me.onlineresu.dto.ExperienceSectionDTO;
import me.onlineresu.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ExperienceSectionConverter implements Converter<ExperienceSectionModel, ExperienceSectionDTO> {

    private final SectionConverter sectionConverter;

    @Autowired
    public ExperienceSectionConverter(SectionConverter sectionConverter) {
        this.sectionConverter = sectionConverter;
    }

    @Override
    public ExperienceSectionDTO convert(ExperienceSectionModel experienceSection) {

        SectionDTO sectionDTO = sectionConverter.convert(experienceSection);   //TODO: implement as converterfactory

        ExperienceSectionDTO dto = new ExperienceSectionDTO();

        dto.setDescription(sectionDTO.getDescription());
        dto.setImageUrl(sectionDTO.getImageUrl());
        dto.setTitle(sectionDTO.getTitle());
        dto.setJobTitle(experienceSection.getJobTitle());
        dto.setStartDate(experienceSection.getStartDate());
        dto.setEndDate(experienceSection.getEndDate());

        final ArrayList<String> tasks = new ArrayList<>();

        experienceSection.getTasks().forEach(tasks::add);

        dto.setTasks(tasks);
        return dto;
    }
}
