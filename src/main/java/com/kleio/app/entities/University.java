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
import javax.persistence.Table;

@Entity
@Table(name = "University")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "universityId")
    private int universityId;

    @Column(name = "name")
    private String name;

    @Column(name = "longitude")
    private Long longitude;

    @Column(name = "latitude")
    private Long latitude;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "stateId")
    private int stateId;

    @Column(name = "country")
    private String country;

    @Column(name = "countryId")
    private int countryId;

    @Column(name = "overviewInfo")
    private String overviewInfo;

    @Column(name = "descriptionInfo")
    private String descriptionInfo;

    @Column(name = "rankingInfo")
    private String rankingInfo;

    @Column(name = "acceptanceInfo")
    private String acceptanceInfo;

    @Column(name = "collegesInfo")
    private String collegesInfo;
}