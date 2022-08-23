package com.springexercise.springexercise.service.impl;

import com.springexercise.springexercise.dto.builder.CoinDto;
import com.springexercise.springexercise.entity.Coin;
import com.springexercise.springexercise.mapper.CoinMapper;
import com.springexercise.springexercise.repository.CoinRepo;
import com.springexercise.springexercise.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CoinServiceimpl implements CoinService {

    private final CoinMapper coinMapper;
    private final CoinRepo coinRepo;

    @Autowired
    public CoinServiceimpl(CoinMapper coinMapper, CoinRepo coinRepo) {
        this.coinMapper = coinMapper;
        this.coinRepo = coinRepo;

    }


    @Override
    public void saveCoin(List<CoinDto> coinDtos) {

        for (CoinDto coinDto : coinDtos) {
            Coin coin = coinMapper.convertToEntity(coinDto);

                coinRepo.save(coin);
            }

    }
}
