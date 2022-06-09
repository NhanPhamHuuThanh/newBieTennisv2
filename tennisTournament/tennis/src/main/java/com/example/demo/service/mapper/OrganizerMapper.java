package com.example.demo.service.mapper;

import com.example.demo.entity.Organizer;
import com.example.demo.service.dto.OrganizerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper
public interface OrganizerMapper {
    OrganizerMapper INSTANCE= Mappers.getMapper(OrganizerMapper.class);

    OrganizerDto toDto(Organizer organizer);

    List<OrganizerDto> toDtos(List<Organizer> organizers);
}
