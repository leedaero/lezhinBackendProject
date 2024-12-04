package com.example.lezhinbackendtestproject.entity.event;

import com.example.lezhinbackendtestproject.entity.artwork.Artwork;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(catalog = "lezhin", name = "t_event_artwork_mapping")
public class EventArtworkMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_seq")
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "f_artwork_code", referencedColumnName = "f_artwork_code")
    private Artwork artworkCode;

    @ManyToOne
    @JoinColumn(name = "f_event_id", referencedColumnName = "f_event_id")
    private Event eventId;

}
