package com.hackerrank.gevents.service;

import com.hackerrank.gevents.domain.converter.EventDtoConverter;
import com.hackerrank.gevents.domain.dto.EventDto;
import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService{

  @Autowired
  EventDtoConverter eventDtoConverter;

  @Autowired
  EventRepository eventRepository;

  @Override
  public Event save(EventDto eventDto) {
    return eventRepository.save(eventDtoConverter.convertToEntity(eventDto));
  }

  @Override
  public List<Event> getAllEvents() {
    return eventRepository.findAll(Sort.by("id").ascending());
  }
}
