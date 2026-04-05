package com.example.certificate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certificates", uniqueConstraints = {
        @UniqueConstraint(columnNames = "certificateId")
})
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String certificateId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String issuedBy;

    private LocalDateTime issuedAt;

    // Constructor
    public Certificate() {
        this.certificateId = UUID.randomUUID().toString();
        this.issuedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() { return id; }

    public String getCertificateId() { return certificateId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }

    public void setCourse(String course) { this.course = course; }

    public String getIssuedBy() { return issuedBy; }

    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }

    public LocalDateTime getIssuedAt() { return issuedAt; }
}