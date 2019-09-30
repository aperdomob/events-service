package org.syoux.services.service;

import java.util.List;
import org.syoux.services.entity.EventEntity;

public interface EventService {
  List<EventEntity> getAllEvents();
  EventEntity save(EventEntity event);
}
