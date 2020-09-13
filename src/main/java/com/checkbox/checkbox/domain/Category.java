package com.checkbox.checkbox.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Builder
    public Category(String name){
        this.name = name;
    }
}
