package com.example.lezhinbackendtestproject.entity.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventArtworkMapping is a Querydsl query type for EventArtworkMapping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEventArtworkMapping extends EntityPathBase<EventArtworkMapping> {

    private static final long serialVersionUID = -400486125L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventArtworkMapping eventArtworkMapping = new QEventArtworkMapping("eventArtworkMapping");

    public final com.example.lezhinbackendtestproject.entity.artwork.QArtwork artworkCode;

    public final QEvent eventId;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QEventArtworkMapping(String variable) {
        this(EventArtworkMapping.class, forVariable(variable), INITS);
    }

    public QEventArtworkMapping(Path<? extends EventArtworkMapping> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventArtworkMapping(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventArtworkMapping(PathMetadata metadata, PathInits inits) {
        this(EventArtworkMapping.class, metadata, inits);
    }

    public QEventArtworkMapping(Class<? extends EventArtworkMapping> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artworkCode = inits.isInitialized("artworkCode") ? new com.example.lezhinbackendtestproject.entity.artwork.QArtwork(forProperty("artworkCode")) : null;
        this.eventId = inits.isInitialized("eventId") ? new QEvent(forProperty("eventId")) : null;
    }

}

