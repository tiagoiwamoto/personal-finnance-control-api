package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:35
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.repository.InvestmentRepository;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public ApiDTO<Investment> save(Investment investment){
        try{
            Investment result = this.investmentRepository.save(investment);
            if(Objects.nonNull(result)){
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, result);
            }else{
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_ERROR_EXECUTED, null);
            }
        }catch (Exception e){
            log.error("não foi possível executar a ação de save() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }

    public ApiDTO<List<Investment>> recoverAllInvestments(){
        try{
            List<Investment> investments = this.investmentRepository.findAll();
            if(investments.isEmpty()){
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_ERROR_EXECUTED, null);
            }else{
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, investments);
            }
        }catch (Exception e){
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }
}
