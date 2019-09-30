package org.syoux.services.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.syoux.services.dto.EventDto;
import org.syoux.services.entity.EventEntity;
import org.syoux.services.mapper.EventMapper;
import org.syoux.services.service.EventService;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
  @Autowired
  private final EventService eventService;

  @Autowired
  private EventMapper eventMapper;

  public EventController(final EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping()
  public List<EventDto> getAllEvents() {
    return Collections.emptyList();
  }

  @PostMapping()
  public EventDto saveEvent(@RequestBody EventDto event) {
    EventEntity entity = this.eventMapper.dtoToModel(event);
    return this.eventMapper.toDto(this.eventService.save(entity));
  }
}
