package org.syoux.services.repository;

import java.util.List;
import org.syoux.services.entity.EventEntity;

public interface EventRepository {
  List<EventEntity> getAllEvents();
  EventEntity save(EventEntity event);
}
