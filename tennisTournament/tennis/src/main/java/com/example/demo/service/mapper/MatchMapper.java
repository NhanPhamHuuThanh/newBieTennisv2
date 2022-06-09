package com.example.demo.service.mapper;

import com.example.demo.entity.Match;
import com.example.demo.entity.Tournament;
import com.example.demo.service.dto.MatchDto;
import com.example.demo.service.dto.TournamentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MatchMapper {
    MatchMapper INSTANCE =Mappers.getMapper(MatchMapper.class);

    @Mapping(source="player1.firstName",target="player1Name")
    @Mapping(source="player2.firstName",target="player2Name")
    @Mapping(source = "round.roundName",target ="roundName")
    @Mapping(source = "stadium.stadiumName",target = "stadiumName")
    MatchDto toDto(Match match);

    List<MatchDto> toDtos(List<Match> matches);
}
