package com.mediscreen.dto;

import com.mediscreen.model.Note;

import java.util.Collection;

public class ReportEntriesDto {

    private Long patientId;
    private String fullName;
    private int age;
    private String gender;
    Collection<Note> noteList;

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

    public Collection<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(Collection<Note> noteList) {
        this.noteList = noteList;
    }

    public ReportEntriesDto() { }
}
