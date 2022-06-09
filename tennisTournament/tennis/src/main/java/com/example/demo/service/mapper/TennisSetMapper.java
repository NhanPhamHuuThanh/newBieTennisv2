package com.example.demo.service.mapper;

import com.example.demo.entity.TennisSet;
import com.example.demo.service.dto.TennisSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TennisSetMapper {
    TennisSetMapper INSTANCE = Mappers.getMapper(TennisSetMapper.class);

    @Mapping(source = "match.player1.firstName", target = "player1FirstName")
    @Mapping(source = "match.player2.firstName", target = "player2FirstName")
    @Mapping(source = "match.stadium.stadiumName", target = "stadiumName")
    @Mapping(source = "match.round.roundName", target = "roundName")
    @Mapping(source = "match.id", target = "matchId")
    TennisSetDto toDto(TennisSet tennisSet);

    List<TennisSetDto> toDtos(List<TennisSet> tennisSetList);
}
