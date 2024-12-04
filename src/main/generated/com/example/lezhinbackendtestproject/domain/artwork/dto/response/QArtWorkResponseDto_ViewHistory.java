package com.example.lezhinbackendtestproject.domain.artwork.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.lezhinbackendtestproject.domain.artwork.dto.response.QArtWorkResponseDto_ViewHistory is a Querydsl Projection type for ViewHistory
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QArtWorkResponseDto_ViewHistory extends ConstructorExpression<ArtWorkResponseDto.ViewHistory> {

    private static final long serialVersionUID = 882503267L;

    public QArtWorkResponseDto_ViewHistory(com.querydsl.core.types.Expression<String> artworkCode, com.querydsl.core.types.Expression<String> artworkName, com.querydsl.core.types.Expression<java.time.LocalDateTime> viewDate, com.querydsl.core.types.Expression<String> userId, com.querydsl.core.types.Expression<String> userName) {
        super(ArtWorkResponseDto.ViewHistory.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, String.class, String.class}, artworkCode, artworkName, viewDate, userId, userName);
    }

}

