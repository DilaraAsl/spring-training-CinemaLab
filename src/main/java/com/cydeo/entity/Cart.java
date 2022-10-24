package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   // @ManyToMany // it will try to create the foreign key when it cannot it will create a new table
    @ManyToMany
    @JoinTable(name="cart_item_rel",     // third table created by spring rel means relationship
            joinColumns = @JoinColumn(name="c_id"),
            inverseJoinColumns = @JoinColumn(name="i_id"))
    private List<Item> itemList;



}
