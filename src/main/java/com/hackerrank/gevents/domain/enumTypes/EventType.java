package com.hackerrank.gevents.domain.enumTypes;

import static java.util.Arrays.stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public enum EventType {
  PUSH("PushEvent"),
  RELEASE("ReleaseEvent"),
  WATCH("WatchEvent");

  private String type;

  EventType(String type) {
    this.type = type;
  }

  public static Optional<EventType> fromValue(String type) {
    return stream(values())
        .filter(gt -> gt.getType().equals(type))
        .findFirst();
  }

  public String getType() {
    return type;
  }

  @JsonCreator
  public static EventType fromText(String code){
    return fromValue(code).orElseThrow(() ->
        new ResponseStatusException(
            HttpStatus.BAD_REQUEST, String.format("Invalid Event Type: { [%s] }", code)));
  }

  @Override
  public String toString(){
    return type;
  }


}
