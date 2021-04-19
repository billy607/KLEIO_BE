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
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Note")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noteId")
    private int noteId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "createDT")
    private Date createDT;

    @Column(name = "updateDT")
    private Date updateDT;

    @Column(name = "poiId")
    private int poiId;

    @Column(name = "reportId")
    private int reportId;

    @ManyToOne
    private User user;

    @ManyToOne
    private UserReport userReport;

    @ManyToOne
    private Poi poi;
}
