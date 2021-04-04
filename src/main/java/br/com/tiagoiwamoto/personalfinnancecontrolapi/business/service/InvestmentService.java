package br.com.tiagoiwamoto.personalfinnancecontrolapi.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:35
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo.InvestmentVO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.repository.InvestmentRepository;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public ApiDTO<Investment> save(Investment investmentMovement){
        log.info("starting the save() of -> ".concat(this.getClass().getSimpleName()));
        try{
            Investment result = this.investmentRepository.save(investmentMovement);
            log.info("save() successfully executed ".concat(this.getClass().getSimpleName()));
            return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, result);
        }catch (Exception e){
            log.error("não foi possível executar a ação de save() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }

    public ApiDTO<Investment> update(Investment investmentMovement){
        log.info("starting the update() of -> ".concat(this.getClass().getSimpleName()));
        try{
            Optional<Investment> optionalInvestment = this.investmentRepository.findById(investmentMovement.getId());
            if(optionalInvestment.isPresent()){
                Investment result = this.investmentRepository.save(investmentMovement);
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
            Optional<Investment> optionalInvestment = this.investmentRepository.findById(id);
            if(optionalInvestment.isPresent()){
                this.investmentRepository.delete(optionalInvestment.get());
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

    public ApiDTO<List<Investment>> recoverAllInvestments(){
        log.info("starting recover...() of -> ".concat(this.getClass().getSimpleName()));
        try{
            List<Investment> investmentMovements = this.investmentRepository.findAll();
            if(investmentMovements.isEmpty()){
                log.info("recover...() successfully executed but no records found -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_ERROR, Constants.MSG_ERROR_EXECUTED, null);
            }else{
                log.info("recover...() successfully executed -> ".concat(this.getClass().getSimpleName()));
                return new ApiDTO<>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS_EXECUTED, investmentMovements);
            }
        }catch (Exception e){
            log.error("não foi possível executar a ação de recovery() -> ".concat(e.getMessage()));
            return new ApiDTO<>(Constants.CODE_EXCEPTION, Constants.MSG_EXCEPTION_EXECUTED, null);
        }
    }

    public Boolean canSellInvestment(InvestmentVO investment){
        try{
//            List<Investment> investmentMovements = this.investmentRepository.findAllByNameOrderByDateEventAsc(investment.getName());
//            AtomicInteger atomicInteger = new AtomicInteger();
//            atomicInteger.set(0);
//            investmentMovements.forEach((Investment item) -> {
//                if(item.getType() == InvestmentType.C){
//                    atomicInteger.set(atomicInteger.get() + item.getQty());
//                }else{
//                    atomicInteger.set(atomicInteger.get() - item.getQty());
//                }
//            });
//            if(investment.getType() == InvestmentType.V && atomicInteger.get() < investment.getQty()){
//                return false;
//            } else{
//                return true;
//            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
