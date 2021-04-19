package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

    @Column(name = "overview")
    private String overview;

    @Column(name = "description")
    private String description;

    @Column(name = "ranking")
    private String ranking;

    @Column(name = "acceptance")
    private String acceptance;

    @Column(name = "colleges")
    private String colleges;

    @OneToMany(mappedBy = "university", targetEntity = Colleges.class, fetch = FetchType.LAZY)
    private List<Colleges> collegesList;

    @OneToMany(mappedBy = "university", targetEntity = Poi.class, fetch = FetchType.LAZY)
    private List<Poi> pois;

    @OneToMany(mappedBy = "university", targetEntity = UserReport.class, fetch = FetchType.LAZY)
    private List<UserReport> userReports;
}