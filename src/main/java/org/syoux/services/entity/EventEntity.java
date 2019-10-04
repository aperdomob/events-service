package org.syoux.services.entity;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

public class EventEntity {
  @Getter
  @Setter
  private String id;

  @Getter
  private ZonedDateTime date;

  @Getter
  @Setter
  private String user;

  @Getter
  private Actions action;

  @Getter
  @Setter
  private String component;

  @Getter
  @Setter
  private Object body;

  public void setAction(String action) {
    for (Actions current : Actions.values()) {
      if (current.equalsName(action)) {
        this.setAction(current);
      }
    }
  }

  public void setAction(Actions action) {
    this.action = action;
  }

  public void setDate(ZonedDateTime date) {
    this.date = date;
  }

  public void setDate(String date) {
    this.date = ZonedDateTime.parse(date);
  }
}
