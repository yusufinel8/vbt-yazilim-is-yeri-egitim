package com.springexercise.springexercise.controller;

import com.springexercise.springexercise.dto.builder.CoinDto;
import com.springexercise.springexercise.service.CoinService;
import com.springexercise.springexercise.service.SendEmail;
import com.springexercise.springexercise.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {

    private final CoinService coinService;
    private final WorkerService workerService;
    private final SendEmail sendEmail;

    private static Logger logger= LoggerFactory.getLogger(CoinController.class);
    @Autowired
    public CoinController(CoinService coinService,WorkerService workerService,SendEmail sendEmail) {
        this.coinService = coinService;
        this.workerService=workerService;
        this.sendEmail=sendEmail;
    }


    @PostMapping(value = "/getCoin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody List<CoinDto> coinDtoList){
        coinService.saveCoin(coinDtoList);
        logger.info("Database'e veriler yüklendi");
    }
}
