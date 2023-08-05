package br.com.willdev.controller;

import br.com.willdev.model.Person;
import br.com.willdev.model.dto.PersonResumeDTO;
import br.com.willdev.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<PersonResumeDTO> findAll() {
        List<PersonResumeDTO> list = new ArrayList<>();
        for (Person p : service.findAll()) {
            list.add(modelMapper.map(p, PersonResumeDTO.class));
        }
        return list;
    }

    @GetMapping("/{id}")
    public PersonResumeDTO findById(@PathVariable Long id) {
        Person p = service.findById(id);
        return modelMapper.map(p, PersonResumeDTO.class);
    }

}
