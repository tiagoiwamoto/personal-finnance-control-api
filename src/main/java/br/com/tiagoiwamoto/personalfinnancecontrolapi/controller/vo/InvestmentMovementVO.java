package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 30/03/2021 | 07:50
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.Investment;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InvestmentMovementVO {

    private Investment investment;
    private InvestmentType type;
    private Double taxB3;
    private Double taxCorretagem;
    private LocalDate dateEvent;

}
