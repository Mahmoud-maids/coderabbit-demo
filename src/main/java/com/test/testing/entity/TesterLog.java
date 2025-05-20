package com.test.testing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TesterLog extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Tester tester;

    @Column
    private String source;

    @Column
    private String target;
}
