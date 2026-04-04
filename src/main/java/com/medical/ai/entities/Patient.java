package com.medical.ai.entities;

import jakarta.persistence.*; // Import all necessary JPA annotations
import java.util.List; // Import for managing lists of medical cases

/**
 * Entity class representing a Patient in the system.
 * This class is mapped to the 'patients' table in the MySQL database.
 */
@Entity
@Table(name = "patients")
public class Patient {

    /**
     * Unique identifier for each patient.
     * Generated automatically by the database (Auto-increment).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    /**
     * Patient's full name.
     * Mapped to a column in the 'patients' table and is mandatory.
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Social Security Number (AMKA) for the patient.
     * Must be unique and is required for identification.
     */
    @Column(unique = true, nullable = false)
    private String amka;

    /**
     * Patient's age.
     * Optional field for demographic information.
     */
    private int age;

    /**
     * Patient's gender.
     * Optional field for medical records.
     */
    private String gender;

    /**
     * Relationship mapping: One patient can have multiple medical cases.
     * CascadeType.ALL ensures that all operations (e.g., delete) propagate to the cases.
     */
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalCase> medicalCases;

    /**
     * Default constructor required by JPA/Hibernate.
     */
    public Patient() {}

    /**
     * Constructor to initialize a patient with basic information.
     */
    public Patient(String fullName, String amka, int age, String gender) {
        this.fullName = fullName;
        this.amka = amka;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(List<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }

    /**
     * Helper method to add a single medical case to the patient.
     * This method maintains the bidirectional relationship.
     */
    public void addMedicalCase(MedicalCase medicalCase) {
        this.medicalCases.add(medicalCase);
        medicalCase.setPatient(this);
    }
}