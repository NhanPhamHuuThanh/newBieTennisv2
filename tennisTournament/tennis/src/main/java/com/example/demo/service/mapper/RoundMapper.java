package com.example.demo.service.mapper;

import com.example.demo.entity.Round;
import com.example.demo.service.dto.RoundDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoundMapper {
    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);
    @Mapping(source = "tournament.name", target = "tournamentName" )
    @Mapping(source = "tournament.startDate", target = "tournamentStartDate")
    @Mapping(source = "tournament.endDate", target = "tournamentEndDate")

    RoundDto toDto(Round round);

    List<RoundDto> toDtos(List<Round> rounds);


}
