package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.object;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 26/03/2021 | 07:34
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service.DividendService;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto.DividendsDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.converter.LocaldateConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DividendBO {

    private final DividendService dividendService;
    private final LocaldateConverter localdateConverter;

    public DividendBO(DividendService dividendService,
                      LocaldateConverter localdateConverter) {
        this.dividendService = dividendService;
        this.localdateConverter = localdateConverter;
    }

    public ApiDTO<List<DividendsDTO>> getDividendsFromFii(String investmentName, String localDate){
        return this.dividendService.getAllDividendsByFii(investmentName, this.localdateConverter.convertStringToLocalDate(localDate));
    }
}
