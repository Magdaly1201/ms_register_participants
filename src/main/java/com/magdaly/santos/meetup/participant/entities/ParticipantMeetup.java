package com.magdaly.santos.meetup.participant.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participant_meetup")
public class ParticipantMeetup {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "char(36)")
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false, name = "created_at")
  private LocalDate createdAt;

  @Column(nullable = false, name = "meet_id")
  private int meetId;

  public ParticipantMeetup() {
  }

  public ParticipantMeetup(String username, String email, int meetId) {
    this.username = username;
    this.email = email;
    this.meetId = meetId;
    this.createdAt = LocalDate.now();
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public int getMeetId() {
    return meetId;
  }

  @Override
  public String toString() {
    return "ParticipantMeetup{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", createdAt=" + createdAt +
            ", meetId=" + meetId +
            '}';
  }
}
