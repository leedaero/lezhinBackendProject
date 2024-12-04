package com.example.lezhinbackendtestproject.entity.artwork;

import com.example.lezhinbackendtestproject.entity.base.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ArtworkId implements Serializable {
    private Long seq;
    private String artworkCode;

}
