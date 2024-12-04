package com.example.lezhinbackendtestproject.entity.artwork;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtwork is a Querydsl query type for Artwork
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtwork extends EntityPathBase<Artwork> {

    private static final long serialVersionUID = 1000606381L;

    public static final QArtwork artwork = new QArtwork("artwork");

    public final com.example.lezhinbackendtestproject.entity.base.QBaseTime _super = new com.example.lezhinbackendtestproject.entity.base.QBaseTime(this);

    public final StringPath adultYn = createString("adultYn");

    public final StringPath artworkCode = createString("artworkCode");

    public final StringPath artworkName = createString("artworkName");

    public final StringPath artworkStatus = createString("artworkStatus");

    public final ListPath<ArtworkViewHistory, QArtworkViewHistory> artworkViewHistories = this.<ArtworkViewHistory, QArtworkViewHistory>createList("artworkViewHistories", ArtworkViewHistory.class, QArtworkViewHistory.class, PathInits.DIRECT2);

    public final StringPath categoryCode = createString("categoryCode");

    public final StringPath description = createString("description");

    public final StringPath freeYn = createString("freeYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mdfyDate = _super.mdfyDate;

    public final StringPath modifyID = createString("modifyID");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath regId = createString("regId");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath thumbnailUrl = createString("thumbnailUrl");

    public QArtwork(String variable) {
        super(Artwork.class, forVariable(variable));
    }

    public QArtwork(Path<? extends Artwork> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArtwork(PathMetadata metadata) {
        super(Artwork.class, metadata);
    }

}

