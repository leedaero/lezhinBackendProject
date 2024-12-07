package com.example.lezhinbackendtestproject.repository.artwork;

import ch.qos.logback.core.util.StringUtil;
import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.domain.artwork.dto.response.QArtWorkResponseDto_ViewHistory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.lezhinbackendtestproject.entity.artwork.QArtwork.artwork;
import static com.example.lezhinbackendtestproject.entity.artwork.QArtworkViewHistory.artworkViewHistory;
import static com.example.lezhinbackendtestproject.entity.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class QueryArtworkViewHistoryRepositoryImpl implements QueryArtworkViewHistoryRepository{
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<ArtWorkResponseDto.ViewHistory> findByArtworkViewHistory(){
        return jpaQueryFactory.select(new QArtWorkResponseDto_ViewHistory(artwork.artworkCode,artwork.artworkName,artworkViewHistory.viewDate,user.userId,user.userName))
                .from(artworkViewHistory)
                .join(artwork)
                .on(artworkViewHistory.artworkCode.eq(artwork))
                .join(user)
                .on(user.userId.eq(artworkViewHistory.userId))
                .fetch();
    }
    private BooleanExpression userIdEq(String userid){
        return StringUtils.hasText(userid) ? user.userId.eq(userid) : null;
    }

}
