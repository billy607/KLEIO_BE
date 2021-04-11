package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubjectId")
    public int SubjectId;

    @Column(name = "collegeId")
    public int collegeId;

    @Column(name = "subjectName")
    public String subjectName;

    @Column(name = "subjectDetail")
    public String subjectDetail;
}
