package com.example.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String customer_name;

    @Column (name="date_signed")
    private String date_signed;


    @OneToMany(mappedBy = "order")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private List<OrderDetails> orderDetails;
}
