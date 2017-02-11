package me.onlineresu.converters;

import me.onlineresu.data.models.SchoolSectionModel;
import me.onlineresu.dto.ClassDTO;
import me.onlineresu.dto.SchoolSectionDTO;
import me.onlineresu.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SchoolSectionConverter implements Converter<SchoolSectionModel, SchoolSectionDTO> {

    private final SectionConverter sectionConverter;
    private final ClassConverter classConverter;

    @Autowired
    public SchoolSectionConverter(SectionConverter sectionConverter, ClassConverter classConverter) {
        this.sectionConverter = sectionConverter;
        this.classConverter = classConverter;
    }

    @Override
    public SchoolSectionDTO convert(SchoolSectionModel schoolSectionModel) {
        SectionDTO sectionDTO = sectionConverter.convert(schoolSectionModel);   //TODO: implement as converterfactory

        SchoolSectionDTO dto = new SchoolSectionDTO();

        dto.setDescription(sectionDTO.getDescription());
        dto.setImageUrl(sectionDTO.getImageUrl());
        dto.setTitle(sectionDTO.getTitle());
        dto.setGpa(schoolSectionModel.getGpa());
        dto.setStartDate(schoolSectionModel.getStartDate());
        dto.setEndDate(schoolSectionModel.getEndDate());
        dto.setAwards(schoolSectionModel.getAwards());

        final ArrayList<ClassDTO> classes = new ArrayList<>();

        schoolSectionModel.getClasses().forEach(classModel -> {
            classes.add(classConverter.convert(classModel));
        });

        dto.setClasses(classes);
        return dto;
    }
}
