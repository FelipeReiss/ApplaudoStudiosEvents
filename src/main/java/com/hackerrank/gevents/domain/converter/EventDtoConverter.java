package com.hackerrank.gevents.domain.converter;

import com.hackerrank.gevents.domain.dto.EventDto;
import com.hackerrank.gevents.domain.enumTypes.EventType;
import com.hackerrank.gevents.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDtoConverter {

  public Event convertToEntity(EventDto eventDto){
    return new Event(eventDto.getType().getType(),
        eventDto.isPublic(),
        eventDto.getRepoId(),
        eventDto.getActorId());
  }

  public EventDto convertToDto(Event event){
    return new EventDto(EventType.fromText(event.getType()),
        event.getIsPublic(),
        event.getRepoId(),
        event.getActorId());
  }
}
