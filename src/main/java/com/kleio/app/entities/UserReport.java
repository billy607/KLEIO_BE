package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "UserReport")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class UserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    private int reportId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "universityId")
    private int universityId;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="universityId")
    private University university;

    @OneToMany(mappedBy = "UserReport")
    private List<Note> notes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ReportPoi", joinColumns = @JoinColumn(name="reportId"),
            inverseJoinColumns = @JoinColumn(name="poiId"))
    private List<Poi> pois;
}
