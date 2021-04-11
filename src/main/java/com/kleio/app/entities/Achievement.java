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
@Table(name = "Achievement")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Achievement {
    @Id
    @Column(name = "achievementId")
    private int achievementId;

    @Column(name = "name")
    private String name;
}
