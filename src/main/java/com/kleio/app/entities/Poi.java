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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
    private Long longitude;

    @Column(name = "latitude")
    private Long latitude;

    @Column(name = "name")
    private String name;

    @Column(name = "audio")
    private int audio;

    @Column(name = "image")
    private int image;

    @Column(name = "reportTemplate")
    private String reportTemplate;

    @Column(name = "premadeTourNumber")
    private int premadeTourNumber;

    @ManyToOne
    private University university;

    @OneToMany(mappedBy = "poi", targetEntity = Note.class, fetch = FetchType.LAZY)
    private List<Note> notes;
}
