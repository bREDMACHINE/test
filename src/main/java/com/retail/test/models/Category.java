package com.retail.test.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "product_category_code")
    private Long productCategoryCode;
    @Column(name = "product_category_name")
    private String productCategoryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return productCategoryCode != null && Objects.equals(productCategoryCode, category.productCategoryCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
