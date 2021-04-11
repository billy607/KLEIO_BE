package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Interest")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Interest {
    @Id
    @Column(name = "interestId")
    private int interestId;

    @Column(name = "name")
    private String name;
}
