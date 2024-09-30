package com.example.inicial1.entities.audit;

import com.example.inicial1.config.CustomRevisionListener;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.io.Serializable;
import java.util.Date;



@Entity
@Table
@RevisionEntity(CustomRevisionListener.class)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data



public class Revision implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="revision_seq")
    @SequenceGenerator(name="revision_seq", sequenceName = "revision_sequence", allocationSize = 1)
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

}
