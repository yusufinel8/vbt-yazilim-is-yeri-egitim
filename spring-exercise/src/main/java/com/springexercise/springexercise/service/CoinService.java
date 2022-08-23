package com.springexercise.springexercise.service;


import com.springexercise.springexercise.dto.builder.CoinDto;

import java.util.List;

public interface CoinService {

    public void saveCoin(List<CoinDto> coinDto);
}
