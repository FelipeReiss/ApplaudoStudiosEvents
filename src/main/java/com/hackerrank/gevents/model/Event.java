package com.hackerrank.gevents.model;

import com.hackerrank.gevents.domain.converter.EventTypeConverter;
import com.hackerrank.gevents.domain.converter.YesNoConverter;
import com.hackerrank.gevents.domain.enumTypes.EventType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "EVENT")
public class Event {

    @Id
    @NotNull
    @Column(name = "EVENT_UID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENT")
    @SequenceGenerator(sequenceName = "SQ_EVENT", allocationSize = 1, name = "SQ_EVENT")
    private Integer id;

    // Correct way should be use EventyType at gatters/setters and constuctor, but once I'm not able to correct tests took this way
    @Convert(converter = EventTypeConverter.class)
    @Column(name = "TYPE")
    private EventType type;

    @NotNull
    @Convert(converter = YesNoConverter.class)
    @Column(name = "PUBLIC_IND", length = 1)
    private Boolean isPublic;

    @Column(name = "REPO_ID")
    private Integer repoId;

    @Column(name = "ACTOR_ID")
    private Integer actorId;

    public Event() {

    }

    public Event(Integer id, String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.id = id;
        this.type = EventType.fromText(type); // Correct way should be use EventyType at gatters/setters and constuctor, but once I'm not able to correct tests took this way
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public Event(String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.type = EventType.fromText(type); // Correct way should be use EventyType at gatters/setters and constuctor, but once I'm not able to correct tests took this way
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Correct way should be use EventyType at gatters/setters and constuctor, but once I'm not able to correct tests took this way
    public String getType() {
        return type.getType();
    }

    // Correct way should be use EventyType at gatters/setters and constuctor, but once I'm not able to correct tests took this way
    public void setType(String type) {
        this.type = EventType.fromText(type);
    }

    public Boolean getIsPublic() {
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
