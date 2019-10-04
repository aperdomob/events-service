package org.syoux.services.mapper;

import java.time.ZonedDateTime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class DateMapper {
  public String asString(ZonedDateTime date) {
    return date != null ? date.toString() : null;
  }

  public ZonedDateTime asZonedDateTime(String date) {
    return ZonedDateTime.parse(date);
  }
}
