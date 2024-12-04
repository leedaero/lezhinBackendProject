package com.example.lezhinbackendtestproject.repository.artwork;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;

import java.util.List;

public interface QueryArtworkRepository {
    List<ArtWorkResponseDto.BestArtwork> findByBestArtworkList();
}
