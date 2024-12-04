package com.example.lezhinbackendtestproject.entity.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = 96554617L;

    public static final QEvent event = new QEvent("event");

    public final com.example.lezhinbackendtestproject.entity.base.QBaseTime _super = new com.example.lezhinbackendtestproject.entity.base.QBaseTime(this);

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final StringPath eventDescription = createString("eventDescription");

    public final NumberPath<Long> eventId = createNumber("eventId", Long.class);

    public final StringPath eventName = createString("eventName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mdfyDate = _super.mdfyDate;

    public final StringPath modifyID = createString("modifyID");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath regId = createString("regId");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final StringPath status = createString("status");

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

