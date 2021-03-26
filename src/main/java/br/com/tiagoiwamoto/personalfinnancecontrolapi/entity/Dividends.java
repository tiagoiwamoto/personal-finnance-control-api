package br.com.tiagoiwamoto.personalfinnancecontrolapi.entity;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 20:39
 */

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
public class Dividends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate paymentDate;
    private Double paymentAmount;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "fii_id")
    private FundoImobiliario fundoImobiliario;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dividends{");
        sb.append("id=").append(id);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", fundoImobiliario=").append(fundoImobiliario);
        sb.append('}');
        return sb.toString();
    }
}
