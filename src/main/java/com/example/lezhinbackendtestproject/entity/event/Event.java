package com.example.lezhinbackendtestproject.entity.event;

import com.example.lezhinbackendtestproject.entity.base.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(catalog = "lezhin", name = "t_event_mst")
public class Event extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_event_id")
    private Long eventId;

    @NotNull
    @Column(name = "f_event_name")
    private String eventName;

    @Column(name = "f_event_description")
    private String eventDescription;

    @Column(name = "f_status")
    private String status;

    @NotNull
    @Column(name = "f_start_date")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "f_end_date")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "f_reg_id")
    private String regId;

    @Column(name = "f_mdfy_id")
    private String modifyID;


}
