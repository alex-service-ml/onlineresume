package me.onlineresu.converters;


import me.onlineresu.data.models.SectionModel;
import me.onlineresu.dto.SectionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SectionConverter implements Converter<SectionModel, SectionDTO> {

    @Override
    public SectionDTO convert(SectionModel section) {
        SectionDTO dto = new SectionDTO();

        dto.setTitle(section.getTitle());
        dto.setDescription(section.getDescription());
        dto.setImageUrl(section.getImageUrl());

        return dto;
    }
}
