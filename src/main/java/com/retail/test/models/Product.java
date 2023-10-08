package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {

    @Id
    @Column(name = "material_no")
    private Long materialNo;
    @Column(name = "material_desc_rus")
    private String materialDescRUS;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return materialNo != null && Objects.equals(materialNo, product.materialNo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
