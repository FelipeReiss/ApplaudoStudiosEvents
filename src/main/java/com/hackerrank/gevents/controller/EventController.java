package com.hackerrank.gevents.controller;

import com.hackerrank.gevents.domain.dto.EventDto;
import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.service.EventService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@ApiModel(value = "Event Controller", description = "Here It's controller to manage Events")
@RestController
@Validated
public class EventController {

  private final String API_V1 = "/v1";

  private final String EVENT_PATH = "/events";

  @Autowired
  EventService eventService;

  @ApiOperation(value = "Creates a new Event, returns the created record")
  @RequestMapping(path = API_V1 + EVENT_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public Event createEvent(@RequestBody @Valid EventDto eventDto){
    return eventService.save(eventDto);
  }

}
