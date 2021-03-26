package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 26/03/2021 | 07:36
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.business.object.DividendBO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto.DividendsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/dividends")
public class DividendController {

    private final DividendBO dividendBO;

    public DividendController(DividendBO dividendBO) {
        this.dividendBO = dividendBO;
    }

    @GetMapping
    public ResponseEntity<ApiDTO<List<DividendsDTO>>> index(
            @RequestHeader("x-investment-name") String investmentName,
            @RequestHeader("x-date-start") String dateStart
    ){
        return ResponseEntity.ok(this.dividendBO.getDividendsFromFii(investmentName, dateStart));
    }

}
