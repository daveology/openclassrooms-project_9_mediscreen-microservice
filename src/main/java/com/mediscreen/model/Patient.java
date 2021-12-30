package com.mediscreen.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {

    private Long patientId;
    private String riskLevel;
    private String fullName;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;
    private String phone;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getRiskLevel() { return riskLevel; }

    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Patient() {}

    public Patient(String riskLevel, String fullName, String gender,
                   LocalDate birthDate, String address, String phone) {
        this.riskLevel = riskLevel;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(riskLevel, patient.riskLevel)
                && Objects.equals(fullName, patient.fullName) && Objects.equals(gender, patient.gender)
                && Objects.equals(birthDate, patient.birthDate) && Objects.equals(address, patient.address)
                && Objects.equals(phone, patient.phone);
    }
}
