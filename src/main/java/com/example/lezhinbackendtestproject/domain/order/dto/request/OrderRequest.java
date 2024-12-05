package com.example.lezhinbackendtestproject.domain.order.dto.request;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class OrderRequest implements Serializable {
    private String artworkCode;
    private String userId;
}
