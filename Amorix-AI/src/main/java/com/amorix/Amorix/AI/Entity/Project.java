package com.amorix.Amorix.AI.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "projects")
@Entity
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    @ManyToOne @JoinColumn(name = "owner_id", nullable = false)
    User owner;

    Boolean isPublic;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Instant updatedAt;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Instant deletedAt;
}