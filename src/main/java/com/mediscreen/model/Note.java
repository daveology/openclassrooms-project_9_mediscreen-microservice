package com.mediscreen.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Note {

    private Long noteId;
    private Long patientId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate noteDate;
    private String content;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note(){}

    public Note(Long noteId, Long patientId, LocalDate noteDate, String content) {
        this.noteId = noteId;
        this.patientId = patientId;
        this.noteDate = noteDate;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(noteId, note.noteId) && Objects.equals(patientId, note.patientId) && Objects.equals(noteDate, note.noteDate) && Objects.equals(content, note.content);
    }
}
