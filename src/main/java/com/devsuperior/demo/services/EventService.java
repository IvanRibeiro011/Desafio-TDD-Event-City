package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.exceptions.ResourceNotFoundException;
import com.devsuperior.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto){
        Event event = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error"));
        event.setName(dto.getName());
        event.setUrl(dto.getUrl());
        event.setCity(new City(dto.getCityId(),null));
        event.setDate(dto.getDate());
        return new EventDTO(repository.save(event));
    }

}
