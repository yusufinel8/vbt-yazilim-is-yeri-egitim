package com.springexercise.springexercise.mapper;

import com.springexercise.springexercise.dto.builder.CoinDto;
import com.springexercise.springexercise.entity.Coin;
import org.springframework.stereotype.Component;

@Component
public class CoinMapper {


    public Coin convertToEntity(CoinDto coinDto) {

        return Coin.builder()
                .id(coinDto.getId())
                .isBuyerMaker(coinDto.getIsBuyerMaker())
                .price(coinDto.getPrice())
                .qty(coinDto.getQty())
                .quoteQty(coinDto.getQuoteQty())
                .build();
    }


}
