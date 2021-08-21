package com.hackerrank.gevents.domain.converter;

import static java.util.Objects.isNull;

import com.hackerrank.gevents.domain.enumTypes.EventType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EventTypeConverter implements AttributeConverter<EventType, String> {

  @Override
  public String convertToDatabaseColumn(EventType attribute) {
    return attribute.getType();
  }

  @Override
  public EventType convertToEntityAttribute(String dbData) {
    if (isNull(dbData)) {
      return null;
    }

    if (dbData.equals(EventType.PUSH.getType())) {
      return EventType.PUSH;
    } else if (dbData.equals(EventType.RELEASE.getType())) {
      return EventType.RELEASE;
    } else if (dbData.equals(EventType.WATCH.getType())) {
        return EventType.WATCH;
    } else {
      throw new IllegalStateException(
          String.format("The value [%s] on the database is invalid!", dbData));
    }
  }
}
