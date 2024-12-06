package com.example.lezhinbackendtestproject.domain.artwork.service;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
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

    public void deleteArtwork(String artworkCode){

        if(!artworkRepository.existsByArtworkCode(artworkCode)){
            throw new RestBusinessException.NotFound(ApiErrorCode.ARTWORK_NOT_FOUND);
        }
        artworkRepository.deleteByArtworkCode(artworkCode);
    }



}
