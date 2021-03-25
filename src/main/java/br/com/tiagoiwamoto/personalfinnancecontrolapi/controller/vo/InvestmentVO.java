package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.vo;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:56
 */

import lombok.Getter;
import lombok.Setter;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentType;
import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentTypePaper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class InvestmentVO {

    private String name;
    private Integer qty;
    private BigDecimal value;
    private InvestmentType type;
    private InvestmentTypePaper typeInvest;
    private Double taxB3;
    private Double taxCorretagem;
    private LocalDate dateEvent;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvestmentVO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", qty=").append(qty);
        sb.append(", value=").append(value);
        sb.append(", type=").append(type);
        sb.append(", typeInvest=").append(typeInvest);
        sb.append(", taxB3=").append(taxB3);
        sb.append(", taxCorretagem=").append(taxCorretagem);
        sb.append(", dateEvent=").append(dateEvent);
        sb.append('}');
        return sb.toString();
    }
}
