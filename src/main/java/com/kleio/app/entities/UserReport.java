package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "UserReport")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class UserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    public int reportId;

    @Column(name = "userId")
    public int userId;

    @Column(name = "universityId")
    public int universityId;

    @Column(name = "rating")
    public int rating;
}
