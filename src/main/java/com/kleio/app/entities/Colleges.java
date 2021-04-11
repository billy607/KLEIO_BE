package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Colleges")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Colleges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CollegesId")
    public int CollegesId;

    @Column(name = "universityId")
    public int universityId;

    @Column(name = "name")
    public String name;

    @Column(name = "mission")
    public String mission;

    @Column(name = "overview")
    public String overview;

    @Column(name = "undergraduate")
    public String undergraduate;

    @Column(name = "graduate")
    public String graduate;
}
