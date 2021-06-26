package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Poi")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Poi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poiId")
    private int poiId;

    @Column(name = "universityId")
    private int universityId;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "name")
    private String name;

    @Column(name = "audioId")
    private int audioId;

    @Column(name = "imageId")
    private int imageId;

    @Column(name = "reportTemplate")
    private String reportTemplate;

    @Column(name = "premadeTourNumber")
    private int premadeTourNumber;

    @ManyToOne
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;
}
