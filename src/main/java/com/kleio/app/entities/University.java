package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "University")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "universityId")
    public int universityId;

    @Column(name = "name")
    public String name;

    @Column(name = "longitude")
    public Long longitude;

    @Column(name = "latitude")
    public Long latitude;

    @Column(name = "city")
    public String city;

    @Column(name = "state")
    public String state;

    @Column(name = "stateId")
    public int stateId;

    @Column(name = "country")
    public String country;

    @Column(name = "countryId")
    public int countryId;

    @Column(name = "overview")
    public String overview;

    @Column(name = "description")
    public String description;

    @Column(name = "ranking")
    public String ranking;

    @Column(name = "acceptance")
    public String acceptance;

    @Column(name = "colleges")
    public String colleges;
}