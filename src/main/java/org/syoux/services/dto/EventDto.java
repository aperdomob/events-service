package org.syoux.services.dto;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.syoux.services.entity.Actions;

public class EventDto {
  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private ZonedDateTime date;

  @Getter
  @Setter
  private String user;

  @Getter
  private String action;

  @Getter
  @Setter
  private String component;

  @Getter
  @Setter
  private Object body;

  public void setAction(Actions action) {
    this.action = action.toString();
  }

  public void setAction(String action) {
    this.action = action;
  }
}
