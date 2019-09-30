package org.syoux.services.dao;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

public class EventDao {
  @Getter
  @Setter
  private ZonedDateTime date;

  @Getter
  @Setter
  private String user;

  @Getter
  @Setter
  private String action;

  @Getter
  @Setter
  private String component;

  @Getter
  @Setter
  private Object body;
}
