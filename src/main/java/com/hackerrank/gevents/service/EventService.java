package com.hackerrank.gevents.service;

import com.hackerrank.gevents.domain.dto.EventDto;
import com.hackerrank.gevents.model.Event;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface EventService {

  Event save(EventDto eventDto);

  List<Event> getAllEvents();
}
