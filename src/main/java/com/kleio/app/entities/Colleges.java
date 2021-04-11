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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Colleges")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Colleges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CollegesId")
    private int CollegesId;

    @Column(name = "universityId")
    private int universityId;

    @Column(name = "name")
    private String name;

    @Column(name = "mission")
    private String mission;

    @Column(name = "overview")
    private String overview;

    @Column(name = "undergraduate")
    private String undergraduate;

    @Column(name = "graduate")
    private String graduate;

    @ManyToOne
    @JoinColumn(name = "universityId")
    private University university;

    @OneToMany(mappedBy = "Colleges")
    private List<Subject> subjects;
}
