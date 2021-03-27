package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.object;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:48
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service.InvestmentService;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo.InvestmentVO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class InvestmentBO {

    private final InvestmentService investmentService;

    public InvestmentBO(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    public ApiDTO<Investment> executeSave(InvestmentVO investment){
        if(this.investmentService.canSellInvestment(investment)){
            Investment investmentConverted = new Investment();
            BeanUtils.copyProperties(investment, investmentConverted);
            investmentConverted.setCreatedAt(LocalDateTime.now());
            return this.investmentService.save(investmentConverted);
        }else{
            return new ApiDTO<>(Constants.CODE_ERROR, Constants.BUSINESS_QTY_ERROR, null);
        }

    }

    public ApiDTO<Investment> executeUpdate(InvestmentVO investment, Long id){
        Investment investmentConverted = new Investment();
        BeanUtils.copyProperties(investment, investmentConverted);
        investmentConverted.setId(id);
        return this.investmentService.update(investmentConverted);
    }

    public ApiDTO<Boolean> executeDelete(Long id){
        return this.investmentService.delete(id);
    }

    public ApiDTO<List<Investment>> getInvestments(){
        return this.investmentService.recoverAllInvestments();
    }
}
