package com.medical.ai.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_cases")
public class MedicalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ... τα υπόλοιπα πεδία ...

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient; // Η αντίστροφη σύνδεση με τον Patient

    public void setPatient(Patient patient) {
    }
}