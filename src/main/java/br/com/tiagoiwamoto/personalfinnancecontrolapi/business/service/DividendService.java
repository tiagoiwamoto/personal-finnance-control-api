package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 21:29
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto.DividendsDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto.DividendsPaymentsDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Dividends;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.FundoImobiliario;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.repository.DividendRepository;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.repository.FundoImobiliarioRepository;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DividendService {

    private final DividendRepository dividendRepository;
    private final FundoImobiliarioRepository fundoImobiliarioRepository;

    public DividendService(DividendRepository dividendRepository,
                           FundoImobiliarioRepository fundoImobiliarioRepository) {
        this.dividendRepository = dividendRepository;
        this.fundoImobiliarioRepository = fundoImobiliarioRepository;
    }

    public ApiDTO<List<DividendsDTO>> getAllDividendsByFii(String investmentName, LocalDate localDate){
        Optional<FundoImobiliario> optionalFii = this.fundoImobiliarioRepository.findByCode(investmentName);
        if(optionalFii.isPresent()){
            FundoImobiliario fii = optionalFii.get();
            List<Dividends> dividends = this.dividendRepository.findAllByPaymentDateBetweenAndFundoImobiliarioOrderByPaymentDateAsc(localDate, LocalDate.now(), fii);
            List<DividendsDTO> dividendsDTOS = new ArrayList<>();
            List<DividendsPaymentsDTO> dividendsPaymentsDTOS = new ArrayList<>();

            dividends = dividends.stream().sorted(Comparator.comparingInt(div -> div.getPaymentDate().getYear())).collect(Collectors.toList());
            int currentYear = 0;
            for (Dividends div : dividends){
                if(currentYear == 0){
                    currentYear = div.getPaymentDate().getYear();
                }
                if (currentYear != div.getPaymentDate().getYear()) {
                    dividendsDTOS.add(new DividendsDTO(currentYear, dividendsPaymentsDTOS));
                    currentYear = div.getPaymentDate().getYear();
                    dividendsPaymentsDTOS = new ArrayList<>();
                }
                dividendsPaymentsDTOS.add(new DividendsPaymentsDTO(div.getPaymentDate().getMonthValue(), div.getPaymentAmount()));
            }
            dividendsDTOS.add(new DividendsDTO(currentYear, dividendsPaymentsDTOS));
            return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, dividendsDTOS);
        }else{
            return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_RECOVERY_NOT_FOUND, null);
        }
    }
}
