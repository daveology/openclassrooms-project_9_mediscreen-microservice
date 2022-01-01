package com.mediscreen.proxy;

import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Note", url = "localhost:7922")
public interface NoteServiceProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/note/add", consumes = "application/json")
    Patient createNote(Note note);
}
