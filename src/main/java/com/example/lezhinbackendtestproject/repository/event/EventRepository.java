package com.example.lezhinbackendtestproject.repository.event;

import com.example.lezhinbackendtestproject.entity.event.Event;
import com.example.lezhinbackendtestproject.repository.artwork.QueryArtworkRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long>, QueryEventRepository {
}
