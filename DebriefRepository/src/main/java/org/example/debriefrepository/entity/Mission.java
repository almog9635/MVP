package org.example.debriefrepository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "mission", schema = "debrief_mgmt")
public class Mission extends BaseEntity {

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "start_date", nullable = false)
    private ZonedDateTime startDate;

    @Column(name = "deadline", nullable = false)
    private ZonedDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "debrief_id", nullable = false)
    private Debrief debrief;

}