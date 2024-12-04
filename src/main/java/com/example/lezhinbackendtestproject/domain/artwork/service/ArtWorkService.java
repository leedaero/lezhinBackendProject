package com.example.lezhinbackendtestproject.domain.artwork.service;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.repository.artwork.ArtworkRepository;
import com.example.lezhinbackendtestproject.repository.artwork.ArtworkViewHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ArtWorkService {
    private final ArtworkRepository artworkRepository;

    public List<ArtWorkResponseDto.BestArtwork> findByBestArtworkList(){
        return artworkRepository.findByBestArtworkList();
    }


}
