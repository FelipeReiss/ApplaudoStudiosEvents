package com.hackerrank.gevents.domain.dto;

import com.hackerrank.gevents.domain.enumTypes.EventType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "Event Request", description = "Data needed to create an Event")
public class EventDto {

  @ApiModelProperty(required = true, value = "The type of the event, written in PascalCase, "
      + "accepted values: 'PushEvent' or 'ReleaseEvent' or 'WatchEvent'")
  @NotNull
  private EventType type;

  @ApiModelProperty(required = true, value = "whether the event is public, either true or false, "
      + "accepted values: 'true' or 'false'")
  @NotNull
  private Boolean isPublic;

  @ApiModelProperty(required = true, value = "The ID of the repository the event belongs to")
  @NotNull
  private Integer repoId;

  @ApiModelProperty(required = true, value = "The ID of the user who created the event")
  @NotNull
  private Integer actorId;

  public EventDto(){ }

  public EventDto(EventType type, Boolean isPublic, Integer repoId, Integer actorId) {
    this.type = type;
    this.isPublic = isPublic;
    this.repoId = repoId;
    this.actorId = actorId;
  }

  public EventType getType() {
    return type;
  }

  public void setType(EventType type) {
    this.type = type;
  }

  public Boolean isPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public Integer getRepoId() {
    return repoId;
  }

  public void setRepoId(Integer repoId) {
    this.repoId = repoId;
  }

  public Integer getActorId() {
    return actorId;
  }

  public void setActorId(Integer actorId) {
    this.actorId = actorId;
  }

}
