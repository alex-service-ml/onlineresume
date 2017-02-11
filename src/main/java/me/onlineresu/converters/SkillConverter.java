package me.onlineresu.converters;

import me.onlineresu.data.models.SkillSectionModel;
import me.onlineresu.dto.SkillSectionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SkillConverter implements Converter<SkillSectionModel, SkillSectionDTO> {

    @Override
    public SkillSectionDTO convert(SkillSectionModel skillModel) {
        SkillSectionDTO dto = new SkillSectionDTO();

        dto.setName(skillModel.getName());
        dto.setProficiency(skillModel.getProficiency());
        dto.setCertificate(skillModel.isCertificate());

        return dto;
    }
}
