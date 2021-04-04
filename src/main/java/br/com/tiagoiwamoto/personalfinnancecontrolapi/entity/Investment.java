package br.com.tiagoiwamoto.personalfinnancecontrolapi.entity;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 30/03/2021 | 07:18
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentTypePaper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private InvestmentTypePaper typeInvest;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Investment{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", typeInvest=").append(typeInvest);
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }

}
