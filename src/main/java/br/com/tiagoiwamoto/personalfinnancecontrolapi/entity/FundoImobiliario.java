package br.com.tiagoiwamoto.personalfinnancecontrolapi.entity;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 25/03/2021 | 20:54
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class FundoImobiliario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String shortName;
    private String name;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundoImobiliario{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
