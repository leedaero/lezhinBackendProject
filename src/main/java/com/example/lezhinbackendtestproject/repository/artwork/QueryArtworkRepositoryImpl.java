package com.example.lezhinbackendtestproject.repository.artwork;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.domain.artwork.dto.response.QArtWorkResponseDto_BestArtwork;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhinbackendtestproject.entity.artwork.QArtwork.artwork;
import static com.example.lezhinbackendtestproject.entity.artwork.QArtworkViewHistory.artworkViewHistory;
import static com.example.lezhinbackendtestproject.entity.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class QueryArtworkRepositoryImpl implements QueryArtworkRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<ArtWorkResponseDto.BestArtwork> findByBestArtworkList(){
        return jpaQueryFactory.select(new QArtWorkResponseDto_BestArtwork(artwork.artworkCode,artwork.artworkName,artworkViewHistory.userId.count()))
                .from(artwork)
                .join(artworkViewHistory)
                .on(artworkViewHistory.artworkCode.eq(artwork))
                .join(user)
                .on(user.userId.eq(artworkViewHistory.userId))
                .groupBy(artwork.artworkCode)
                .orderBy(artworkViewHistory.userId.count().desc())
                .limit(10)
                .fetch();
    }
}
