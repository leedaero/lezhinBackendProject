package com.example.lezhinbackendtestproject.domain.artwork.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.lezhinbackendtestproject.domain.artwork.dto.response.QArtWorkResponseDto_BestArtwork is a Querydsl Projection type for BestArtwork
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QArtWorkResponseDto_BestArtwork extends ConstructorExpression<ArtWorkResponseDto.BestArtwork> {

    private static final long serialVersionUID = 1120940452L;

    public QArtWorkResponseDto_BestArtwork(com.querydsl.core.types.Expression<String> artworkCode, com.querydsl.core.types.Expression<String> artworkName, com.querydsl.core.types.Expression<Long> totalCount) {
        super(ArtWorkResponseDto.BestArtwork.class, new Class<?>[]{String.class, String.class, long.class}, artworkCode, artworkName, totalCount);
    }

}

