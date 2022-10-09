package com.example.pokemon.utility;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.model.dto.LocalizedPkmDto;

import java.util.List;

public interface MockLocalizedPkmData {

    LocalizedPkm createPkm();

    LocalizedPkmDto createPkmDTO();

    List<LocalizedPkm> createPkmList(int listSize);

    List<LocalizedPkmDto> createPkmDTOList(int listSize);
}
