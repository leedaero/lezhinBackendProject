package com.example.lezhinbackendtestproject.repository.artwork;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;

import java.util.List;

public interface QueryArtworkViewHistoryRepository {
    List<ArtWorkResponseDto.ViewHistory> findByArtworkViewHistory(String userId);
}
