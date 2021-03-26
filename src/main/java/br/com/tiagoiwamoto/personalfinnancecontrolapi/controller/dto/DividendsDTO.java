package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 21:38
 */

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DividendsDTO {

    private Integer year;
    private List<DividendsPaymentsDTO> payments;

    public DividendsDTO() {
    }

    public DividendsDTO(Integer year, List<DividendsPaymentsDTO> payments) {
        this.year = year;
        this.payments = payments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DividendsDTO{");
        sb.append("year=").append(year);
        sb.append(", payments=").append(payments);
        sb.append('}');
        return sb.toString();
    }
}
