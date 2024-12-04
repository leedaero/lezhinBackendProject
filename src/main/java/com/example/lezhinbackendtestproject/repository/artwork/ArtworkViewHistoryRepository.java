package com.example.lezhinbackendtestproject.repository.artwork;

import com.example.lezhinbackendtestproject.entity.artwork.ArtworkViewHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkViewHistoryRepository extends JpaRepository<ArtworkViewHistory,Long>, QueryArtworkViewHistoryRepository {
}
