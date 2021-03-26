package br.com.tiagoiwamoto.personalfinnancecontrolapi.converter;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 26/03/2021 | 07:40
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class LocaldateConverter {

    public LocalDate convertStringToLocalDate(String localDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.from(dtf.parse(localDate));
    }

}
