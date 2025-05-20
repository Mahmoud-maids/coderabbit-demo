package com.test.testing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tester extends BaseEntity {
    @Column
    private String name;

    @Column
    private String number;

    @Formula("(SELECT GROUP_CONCAT(tl.target) FROM tester_log tl WHERE tl.tester_id = id)")
    private String transfers;

    public Tester(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
