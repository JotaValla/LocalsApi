package com.jotacode.restfullapi.controller;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.service.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Nos permite centrar en el controlador en específico para hacer pruebas unitarias
@WebMvcTest(LocalController.class)
class LocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalService localService;

    private Local local;

    @BeforeEach
    void setUp() {
        local = Local.builder()
                .id(2L)
                .name("Cinema")
                .floor("Piso4")
                .code("CN04")
                .build();
    }

    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder()
                .name("Cinema")
                .floor("Piso4")
                .code("CN04")
                .build();
        Mockito.when(localService.saveLocal(postLocal)).thenReturn(local);
        mockMvc.perform(post("/createLocal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"name\": \"Cinema\",\n" +
                                 "    \"floor\": \"Piso4\",\n" +
                                 "    \"code\": \"CN04\"\n" +
                                 "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void findLocalById() throws Exception {
        Mockito.when(localService.findById(2L)).thenReturn(local);
        mockMvc.perform(get("/localById/2")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(local.getName())); //Verifica que el nombre del local sea "Cinema"
    
    }

}