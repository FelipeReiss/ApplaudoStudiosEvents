package com.hackerrank.gevents.service;

import com.hackerrank.gevents.domain.dto.EventDto;
import com.hackerrank.gevents.model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface EventService {

  Event save(EventDto eventDto);

}
