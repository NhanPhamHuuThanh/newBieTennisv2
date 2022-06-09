package com.example.demo.service.mapper;

import com.example.demo.entity.RefereeMatch;
import com.example.demo.service.dto.RefereeMatchDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RefereeMatchMapper {
    RefereeMatchMapper INSTANCE = Mappers.getMapper(RefereeMatchMapper.class);

    @Mapping(source = "referee.name", target = "refereeName")
    @Mapping(source = "match.startDate", target = "matchStartDate")
    @Mapping(source = "match.duration", target = "matchDuration")
    @Mapping(source = "match.player1.firstName", target = "player1FirstName")
    @Mapping(source = "match.player2.firstName", target = "player2FirstName")
    @Mapping(source = "match.winnerId", target = "matchWinnerId")

    RefereeMatchDto toDto(RefereeMatch refereeMatch);
    List<RefereeMatchDto> toDtos(List<RefereeMatch> refereeMatches);
}
