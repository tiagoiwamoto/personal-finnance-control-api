package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.object;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 30/03/2021 | 07:49
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service.InvestmentMovementService;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo.InvestmentMovementVO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo.InvestmentVO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.InvestmentMovement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class InvestmentMovementBO {

    private final InvestmentMovementService investmentMovementService;

    public InvestmentMovementBO(InvestmentMovementService investmentMovementService) {
        this.investmentMovementService = investmentMovementService;
    }

    public ApiDTO<InvestmentMovement> executeSave(InvestmentMovementVO investmentMovementVO){
        log.info("starting executeSave() at -> ".concat(this.getClass().getSimpleName()));
        InvestmentMovement convertedInvestmentMovement = new InvestmentMovement();
        BeanUtils.copyProperties(investmentMovementVO, convertedInvestmentMovement);
        log.info("coping -> ".concat(investmentMovementVO.toString()).concat(" to -> ").concat(convertedInvestmentMovement.toString()));
        convertedInvestmentMovement.setCreatedAt(LocalDateTime.now());
        return this.investmentMovementService.save(convertedInvestmentMovement);
    }

    public ApiDTO<InvestmentMovement> executeUpdate(InvestmentMovementVO investmentMovementVO, Long id){
        log.info("starting executeUpdate() at -> ".concat(this.getClass().getSimpleName()));
        InvestmentMovement investmentMovementConverted = new InvestmentMovement();
        BeanUtils.copyProperties(investmentMovementVO, investmentMovementConverted);
        log.info("coping -> ".concat(investmentMovementVO.toString()).concat(" to -> ").concat(investmentMovementConverted.toString()));
        log.info("id of record -> ".concat(String.valueOf(id)));
        investmentMovementConverted.setId(id);
        return this.investmentMovementService.update(investmentMovementConverted);
    }

    public ApiDTO<Boolean> executeDelete(Long id){
        log.info("starting executeDelete() at -> ".concat(this.getClass().getSimpleName()));
        return this.investmentMovementService.delete(id);
    }

    public ApiDTO<List<InvestmentMovement>> getInvestmentMovements(){
        log.info("starting getInvestmentMovements() at -> ".concat(this.getClass().getSimpleName()));
        return this.investmentMovementService.recoverAllInvestments();
    }

}
