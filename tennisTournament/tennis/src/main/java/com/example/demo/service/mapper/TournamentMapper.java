package com.example.demo.service.mapper;

import com.example.demo.entity.Tournament;
import com.example.demo.service.dto.TournamentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TournamentMapper {
    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);

    @Mapping(source = "organizer.name", target = "organizerName")
    TournamentDto toDto(Tournament tournament);

    List<TournamentDto> toDtos(List<Tournament> tournaments);


}
