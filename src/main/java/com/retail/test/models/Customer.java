package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer {

    @Id
    @Column(name = "CH3_ship_to_code")
    private Integer CH3ShipToCode;
    @Column(name = "CH3_ship_to_name")
    private String CH3ShipToName;
    @ManyToOne
    @JoinColumn(name = "chain_chain_id")
    private Chain chains;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return CH3ShipToCode != null && Objects.equals(CH3ShipToCode, customer.CH3ShipToCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
