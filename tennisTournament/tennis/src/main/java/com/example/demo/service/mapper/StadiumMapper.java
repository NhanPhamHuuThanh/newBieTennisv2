package com.example.demo.service.mapper;

import com.example.demo.entity.Stadium;
import com.example.demo.service.dto.StadiumDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StadiumMapper {
    StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

    StadiumDto toDto(Stadium stadium);
    List<StadiumDto> toDtos(List<Stadium>stadiums);
}
