package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:56
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentTypePaper;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class InvestmentVO {

    private String name;
    private Integer qty;
    private BigDecimal value;
    private InvestmentTypePaper typeInvest;
    private LocalDate dateEvent;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvestmentVO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", qty=").append(qty);
        sb.append(", value=").append(value);
        sb.append(", typeInvest=").append(typeInvest);
        sb.append(", dateEvent=").append(dateEvent);
        sb.append('}');
        return sb.toString();
    }
}
