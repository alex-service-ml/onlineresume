package me.onlineresu.converters;

import me.onlineresu.data.models.ClassModel;
import me.onlineresu.dto.ClassDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClassConverter implements Converter<ClassModel, ClassDTO> {
    @Override
    public ClassDTO convert(ClassModel classModel) {
        ClassDTO dto = new ClassDTO();
        dto.setName(classModel.getName());
        dto.setDescription(classModel.getDescription());
        return dto;
    }
}
