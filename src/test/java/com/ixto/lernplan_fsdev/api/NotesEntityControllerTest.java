package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.services.NotesService;
import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class NotesEntityControllerTest {

@Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotesService noteService;

    @Test
    public void getAllNotes() throws Exception {
    
        NotesEntity note1 = new NotesEntity();
       NotesEntity note2 = new NotesEntity();
       note1.setId(UUID.randomUUID());
        note1.setBody("This is a new note");
        note2.setId(UUID.randomUUID());
        note2.setBody("This is a second new note");
        List<NotesEntity> notes = Arrays.asList(note1,note2);
        given(noteService.findAll()).willReturn(notes);

    
        this.mockMvc.perform(get("/notes/"))
                .andExpect(status().isOk()).andDo(print());
              
    }
}
