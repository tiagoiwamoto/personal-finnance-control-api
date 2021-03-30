package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 30/03/2021 | 07:33
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.InvestmentMovement;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.repository.InvestmentMovementRepository;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class InvestmentMovementService {

    private final InvestmentMovementRepository investmentMovementRepository;

    public InvestmentMovementService(InvestmentMovementRepository investmentMovementRepository) {
        this.investmentMovementRepository = investmentMovementRepository;
    }

    public ApiDTO<InvestmentMovement> save(InvestmentMovement investmentMovement){
        log.info("starting the save() of -> ".concat(this.getClass().getSimpleName()));
        investmentMovement.setCreatedAt(LocalDateTime.now());
        try{
            InvestmentMovement result = this.investmentMovementRepository.save(investmentMovement);
            log.info("save() successfully executed ".concat(this.getClass().getSimpleName()));
            return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, result);
        }catch (Exception e){
            log.error("não foi possível executar a ação de save() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }

    public ApiDTO<InvestmentMovement> update(InvestmentMovement investmentMovement){
        log.info("starting the update() of -> ".concat(this.getClass().getSimpleName()));
        try{
            Optional<InvestmentMovement> optionalInvestment = this.investmentMovementRepository.findById(investmentMovement.getId());
            if(optionalInvestment.isPresent()){
                InvestmentMovement result = this.investmentMovementRepository.save(investmentMovement);
                log.info("update() successfully executed ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, result);
            }else{
                log.warn("update() tried to update nonexistent record -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_RECOVERY_NOT_FOUND, null);
            }

        }catch (Exception e){
            log.error("não foi possível executar a ação de save() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }

    public ApiDTO<Boolean> delete(Long id){
        log.info("starting delete() of -> ".concat(this.getClass().getSimpleName()));
        try{
            Optional<InvestmentMovement> optionalInvestment = this.investmentMovementRepository.findById(id);
            if(optionalInvestment.isPresent()){
                this.investmentMovementRepository.delete(optionalInvestment.get());
                log.info("delete() successfully executed ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, true);
            }else{
                log.warn("delete() tried to remove nonexistent record -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_RECOVERY_NOT_FOUND, false);
            }
        }catch (Exception e){
            log.error("não foi possível executar a ação de save() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, false);
        }
    }

    public ApiDTO<List<InvestmentMovement>> recoverAllInvestments(){
        log.info("starting recover...() of -> ".concat(this.getClass().getSimpleName()));
        try{
            List<InvestmentMovement> investmentMovements = this.investmentMovementRepository.findAll();
            if(investmentMovements.isEmpty()){
                log.info("recover...() successfully executed but no records found -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_RECOVERY_NOT_FOUND, null);
            }else{
                log.info("recover...() successfully executed -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, investmentMovements);
            }
        }catch (Exception e){
            log.error("não foi possível executar a ação de recovery() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }
}
