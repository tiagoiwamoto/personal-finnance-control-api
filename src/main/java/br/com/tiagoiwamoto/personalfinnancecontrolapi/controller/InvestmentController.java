package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:50
 */

import br.com.tiagoiwamoto.iwtlibcore.model.dto.ApiDTO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.business.object.InvestmentBO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo.InvestmentVO;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/investments")
public class InvestmentController {

    private final InvestmentBO investmentBO;

    public InvestmentController(InvestmentBO investmentBO) {
        this.investmentBO = investmentBO;
    }

    @PostMapping
    public ResponseEntity<ApiDTO<Investment>> create(@RequestBody InvestmentVO investment){
        return ResponseEntity.ok(this.investmentBO.executeSave(investment));
    }

    @PutMapping(path = "/investment/{id}")
    public ResponseEntity<ApiDTO<Investment>> update(@RequestBody InvestmentVO investment,
                                                     @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.investmentBO.executeUpdate(investment, id));
    }

    @DeleteMapping(path = "/investment/{id}")
    public ResponseEntity<ApiDTO<Boolean>> delete(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.investmentBO.executeDelete(id));
    }

    @GetMapping
    public ResponseEntity<ApiDTO<List<Investment>>> index(){
        return ResponseEntity.ok(this.investmentBO.getInvestments());
    }

}
