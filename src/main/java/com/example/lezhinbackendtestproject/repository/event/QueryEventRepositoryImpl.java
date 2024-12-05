package com.example.lezhinbackendtestproject.repository.event;

import com.example.lezhinbackendtestproject.enums.event.EventStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.example.lezhinbackendtestproject.entity.artwork.QArtwork.artwork;
import static com.example.lezhinbackendtestproject.entity.event.QEvent.event;
import static com.example.lezhinbackendtestproject.entity.event.QEventArtworkMapping.eventArtworkMapping;

@Repository
@RequiredArgsConstructor
public class QueryEventRepositoryImpl implements QueryEventRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public boolean isEventRangeCheck(String artworkCode){
        LocalDateTime now = LocalDateTime.now();
        return jpaQueryFactory.selectOne()
                .from(event)
                .join(eventArtworkMapping)
                .on(eventArtworkMapping.eventId.eq(event))
                .join(artwork)
                .on(eventArtworkMapping.artworkCode.eq(artwork))
                .where(event.status.eq(EventStatus.ACTIVE.getValue())
                        .and(artwork.artworkCode.eq(artworkCode))
                        .and(event.startDate.loe(now)
                                .and(event.endDate.goe(now))))
                .fetchOne() != null;
    }
}
