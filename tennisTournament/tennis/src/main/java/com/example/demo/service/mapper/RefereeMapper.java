package com.example.demo.service.mapper;

import com.example.demo.entity.Referee;
import com.example.demo.service.dto.RefereeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface RefereeMapper {
    RefereeMapper INSTANCE = Mappers.getMapper(RefereeMapper.class);

    RefereeDto toDto (Referee referee);

    List<RefereeDto> toDtos(List<Referee> referees);

}
