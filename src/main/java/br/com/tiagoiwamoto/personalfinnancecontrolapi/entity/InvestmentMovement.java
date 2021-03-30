package br.com.tiagoiwamoto.personalfinnancecontrolapi.entity;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 07:24
 */

import br.com.tiagoiwamoto.personalfinnancecontrolapi.entity.model.InvestmentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class InvestmentMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "investment_id")
    private Investment investment;
    private InvestmentType type;
    private Double taxB3;
    private Double taxCorretagem;
    private LocalDate dateEvent;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvestmentMovement{");
        sb.append("id=").append(id);
        sb.append(", investment=").append(investment);
        sb.append(", type=").append(type);
        sb.append(", taxB3=").append(taxB3);
        sb.append(", taxCorretagem=").append(taxCorretagem);
        sb.append(", dateEvent=").append(dateEvent);
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }
}
