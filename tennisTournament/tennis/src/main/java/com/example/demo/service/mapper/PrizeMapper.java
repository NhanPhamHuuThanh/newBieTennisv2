package com.example.demo.service.mapper;

import com.example.demo.entity.Prize;
import com.example.demo.service.dto.PrizeDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PrizeMapper {
    PrizeMapper INSTANCE = Mappers.getMapper(PrizeMapper.class);

    PrizeDto toDto(Prize prize);

    List<PrizeDto> toDtos(List<Prize> prize);
}
