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
    @Column(name = "ship_to_code")
    private Long CH3ShipToCode;
    @Column(name = "ship_to_name")
    private String CH3ShipToName;
    @ManyToOne
    @JoinColumn(name = "chains")
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
