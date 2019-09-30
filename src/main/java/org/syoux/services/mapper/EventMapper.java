package org.syoux.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.syoux.services.dao.EventDao;
import org.syoux.services.dto.EventDto;
import org.syoux.services.entity.EventEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventMapper {
  EventEntity dtoToModel(EventDto dto);
  EventEntity daoToModel(EventDao dao);
  EventDao entityToDao(EventEntity entity);
  EventDto toDto(EventEntity entity);
}
