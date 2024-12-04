package com.example.lezhinbackendtestproject.entity.artwork;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(catalog = "lezhin", name = "t_artwork_view_history")
public class ArtworkViewHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_seq")
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "f_artwork_code", referencedColumnName = "f_artwork_code")
    private Artwork artworkCode;

    @NotNull
    @Column(name = "f_user_id")
    private String userId;

    @NotNull
    @Column(name = "f_view_date")
    private LocalDateTime viewDate;



}
