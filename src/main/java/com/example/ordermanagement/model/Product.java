package com.example.ordermanagement.model;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String product_name;

    @Column
    private double price;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderDetails> orderDetails ;



}
