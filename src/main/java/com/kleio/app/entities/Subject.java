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
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubjectId")
    private int SubjectId;

    @Column(name = "collegeId")
    private int collegeId;

    @Column(name = "subjectName")
    private String subjectName;

    @Column(name = "subjectDetail")
    private String subjectDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collegeId", insertable = false, updatable = false)
    private Colleges college;
}
