package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Poi")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Poi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poiId")
    public int poiId;

    @Column(name = "universityId")
    public int universityId;

    @Column(name = "longitude")
    public Long longitude;

    @Column(name = "latitude")
    public Long latitude;

    @Column(name = "name")
    public String name;

    @Column(name = "audio")
    public int audio;

    @Column(name = "image")
    public int image;

    @Column(name = "reportTemplate")
    public String reportTemplate;

    @Column(name = "premadeTourNumber")
    public int premadeTourNumber;
}
