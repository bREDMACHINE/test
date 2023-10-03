package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prices", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "chain_chain_id")
    private Chain chains;
    @ManyToOne
    @JoinColumn(name = "product_material_no")
    private Product product;
    @Column(name = "regular_price_per_unit")
    private Float regularPricePerUnit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Price price = (Price) o;
        return id != null && Objects.equals(id, price.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
