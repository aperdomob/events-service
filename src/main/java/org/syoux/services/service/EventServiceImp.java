package org.syoux.services.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syoux.services.entity.EventEntity;
import org.syoux.services.repository.EventRepository;

@Service
public class EventServiceImp implements EventService {
  @Autowired
  private final EventRepository eventRepository;

  public EventServiceImp(final EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @Override
  public List<EventEntity> getAllEvents() {
    return this.eventRepository.getAllEvents();
  }

  @Override
  public EventEntity save(EventEntity event) {
    return this.eventRepository.save(event);
  }
}
