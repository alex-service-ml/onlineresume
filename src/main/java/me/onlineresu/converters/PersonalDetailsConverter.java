package me.onlineresu.converters;

import me.onlineresu.data.models.PersonalDetailsModel;
import me.onlineresu.dto.PersonalDetailsDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonalDetailsConverter implements Converter<PersonalDetailsModel, PersonalDetailsDTO> {

    @Override
    public PersonalDetailsDTO convert(PersonalDetailsModel personalDetailsModel) {
        PersonalDetailsDTO dto = new PersonalDetailsDTO();
        final String firstName = personalDetailsModel.getFirstName();
        final String middleName = personalDetailsModel.getMiddleName();
        final String lastName = personalDetailsModel.getLastName();

        StringBuilder sb = new StringBuilder();
        if (null != firstName) {
            sb.append(firstName);
            sb.append(" ");
        }
        if (null != middleName) {
            sb.append(middleName);
            sb.append(" ");
        }

        sb.append(null == lastName ? "" : lastName);

        dto.setName(sb.toString().trim());
        dto.setEmail(personalDetailsModel.getEmail());
        dto.setPhotoUrl(personalDetailsModel.getPhotoUrl());

        return dto;
    }
}
