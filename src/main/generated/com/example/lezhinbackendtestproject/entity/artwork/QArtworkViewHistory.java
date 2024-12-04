package com.example.lezhinbackendtestproject.entity.artwork;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtworkViewHistory is a Querydsl query type for ArtworkViewHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtworkViewHistory extends EntityPathBase<ArtworkViewHistory> {

    private static final long serialVersionUID = -1820979902L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtworkViewHistory artworkViewHistory = new QArtworkViewHistory("artworkViewHistory");

    public final QArtwork artworkCode;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath userId = createString("userId");

    public final DateTimePath<java.time.LocalDateTime> viewDate = createDateTime("viewDate", java.time.LocalDateTime.class);

    public QArtworkViewHistory(String variable) {
        this(ArtworkViewHistory.class, forVariable(variable), INITS);
    }

    public QArtworkViewHistory(Path<? extends ArtworkViewHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtworkViewHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtworkViewHistory(PathMetadata metadata, PathInits inits) {
        this(ArtworkViewHistory.class, metadata, inits);
    }

    public QArtworkViewHistory(Class<? extends ArtworkViewHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artworkCode = inits.isInitialized("artworkCode") ? new QArtwork(forProperty("artworkCode")) : null;
    }

}

