package br.com.tiagoiwamoto.personalfinnancecontrolapi.controller.dto;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 21:39
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DividendsPaymentsDTO {

    private Integer month;
    private Double value;

    public DividendsPaymentsDTO() {
    }

    public DividendsPaymentsDTO(Integer month, Double value) {
        this.month = month;
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DividendsPaymentsDTO{");
        sb.append("month=").append(month);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
