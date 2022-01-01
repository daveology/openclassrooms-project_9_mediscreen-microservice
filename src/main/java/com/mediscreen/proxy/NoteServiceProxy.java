package com.mediscreen.proxy;

import com.mediscreen.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "Note", url = "localhost:7922")
public interface NoteServiceProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/note/add", consumes = "application/json")
    Note createNote(Note note);

    @GetMapping(value="/noteList/{patientId}")
    Collection<Note> readNote(@PathVariable("patientId") Long patientId);

    @DeleteMapping(value="/note/{patientId}")
    void deleteNote(@PathVariable("patientId") Long patientId);

    @DeleteMapping(value="/noteList")
    void deleteNoteList();
}
