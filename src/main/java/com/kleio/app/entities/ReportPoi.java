package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "ReportPoi")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class ReportPoi {
    @Column(name = "poiId")
    public int poiId;

    @Column(name = "reportId")
    public int reportId;
}
