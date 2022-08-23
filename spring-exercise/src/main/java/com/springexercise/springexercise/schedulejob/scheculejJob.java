package com.springexercise.springexercise.schedulejob;

import com.springexercise.springexercise.entity.Currency;
import com.springexercise.springexercise.repository.CurrencyRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableScheduling
public class scheculejJob extends Thread {

    private final CurrencyRepo currencyRepo;

    private static Logger logger = LoggerFactory.getLogger(scheculejJob.class);

    @Scheduled(fixedRate = 86400000)
    public void create() {

        Random rnd = new Random();

        Currency dolar = Currency.builder()
                .id(1L)
                .name("Dolar")
                .fiyat(Math.random() + rnd.nextInt(3))
                .adet(rnd.nextInt(25) + 1L)
                .durum(Boolean.TRUE)
                .build();
        currencyRepo.save(dolar);


        Currency euro = Currency.builder()
                .id(2L)
                .name("Euro")
                .fiyat(Math.random() + rnd.nextInt(3))
                .adet(rnd.nextInt(25) + 1L)
                .durum(Boolean.TRUE)
                .build();
        currencyRepo.save(euro);

        Currency mark = Currency.builder()
                .id(3L)
                .name("TL")
                .fiyat(Math.random() + rnd.nextInt(3))
                .adet(rnd.nextInt(25) + 1L)
                .durum(Boolean.TRUE)
                .build();
        currencyRepo.save(mark);

    }

    @Scheduled(fixedRate = 10000)
    public void update() {

        Random rnd = new Random();

        List<Currency> all = currencyRepo.findAll();

        for (Currency currency : all) {
            currency.setEskiFiyat(currency.getFiyat());
            currency.setFiyat(currency.getFiyat());
            currency.setFiyat(Math.random() + rnd.nextInt(3));
            currency.setDurum(Boolean.TRUE);

            if (currency.getAdet() < 1500) {
                currency.setAdet(currency.getAdet() + rnd.nextInt(15) + 1);
                try{
                    if(currency.getAdet()>100){
                        Thread.sleep(5000);
                        logger.info("Thread uyutuldu");
                    }
                }
                catch (InterruptedException e){
                    logger.info(e.getMessage());
                }
            } else {
                logger.info("Günlük adet sınırı geçilmiştir");
            }

            double fiyat = currency.getFiyat();
            double eskifiyat = currency.getEskiFiyat();
            double fark = eskifiyat - fiyat;
            if (fark > fiyat * 10 / 100) {
                currency.setDurum(Boolean.FALSE);
            }
            currencyRepo.save(currency);
        }


    }


    @Scheduled(fixedRate = 15000)
    public  void print(){
        List<Currency> currencies = currencyRepo.findAll();
        logger.info("Döviz Durumları Hesaplanıyor    :     ");
        for (Currency currency : currencies) {

            if (currency.getDurum() == Boolean.TRUE) {
                logger.info(currency.getName() + " alınabilir düzeyde  :");
            } else {
                logger.error(currency.getName() + " alınnması tavsiye edilmez :");
                ;
            }
        }
    }


}
