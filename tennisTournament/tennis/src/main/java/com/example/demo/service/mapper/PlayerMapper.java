package com.example.demo.service.mapper;

import com.example.demo.entity.Player;
import com.example.demo.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDto toDto(Player player);

    List<PlayerDto> toDtos(List<Player> players);
}
