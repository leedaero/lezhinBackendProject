package com.example.lezhinbackendtestproject.entity.artwork;

import com.example.lezhinbackendtestproject.entity.base.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@IdClass(ArtworkId.class)
@Entity
@Table(catalog = "lezhin", name = "t_artwork_mst")
public class Artwork extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_seq")
    private Long seq;

    @Id
    @Column(name = "f_artwork_code")
    private String artworkCode;

    @NotNull
    @Column(name = "f_artwork_name")
    private String artworkName;

    @Column(name = "f_description")
    private String description;

    @NotNull
    @Column(name = "f_category_code")
    private String categoryCode;

    @NotNull
    @Column(name = "f_artwork_status")
    private String artworkStatus;

    @Column(name = "f_adult_yn")
    private String adultYn;

    @Column(name = "f_free_yn")
    private String freeYn;

    @Column(name = "f_price")
    private BigDecimal price;

    @Column(name = "f_thumbnail_url")
    private String thumbnailUrl;

    @NotNull
    @Column(name = "f_reg_id")
    private String regId;

    @Column(name = "f_mdfy_id")
    private String modifyID;

    @OneToMany(mappedBy = "artworkCode", cascade = {CascadeType.ALL})
    private List<ArtworkViewHistory> artworkViewHistories = new ArrayList<>();


}
