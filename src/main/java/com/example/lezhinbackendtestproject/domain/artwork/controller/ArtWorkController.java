package com.example.lezhinbackendtestproject.domain.artwork.controller;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.domain.artwork.service.ArtWorkService;
import com.example.lezhinbackendtestproject.domain.artwork.service.ArtWorkViewService;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = "Lezhin Backend Api")
public class ArtWorkController {
    private final ArtWorkViewService artWorkViewService;
    private final ArtWorkService artWorkService;

    @GetMapping("/artwork-search-history")
    @Operation(summary = "artwork history api", description = "작품 조회 이력 API")
    public List<ArtWorkResponseDto.ViewHistory> artworkViewHistory( @RequestParam(value = "userId", required = false) String userId) {
        return artWorkViewService.findByArtworkViewHistory(userId);
    }

    @GetMapping("/best-artwork")
    @Operation(summary = "best-artwork api", description = "인기 작품 조회 API")
    public List<ArtWorkResponseDto.BestArtwork> bestArtwork() {
        return artWorkService.findByBestArtworkList();
    }

    @DeleteMapping("/delete-artworks/{artworkCode}")
    @Operation(summary = "delete artwork and history api", description = "작품 및 이력 삭제 API")
    public ResponseEntity<String> artworksDelete(@PathVariable("artworkCode") String artworkCode) {
        artWorkService.deleteArtwork(artworkCode);
        return ResponseEntity.ok(ApiSuccessCode.RESPONSE_SUCCESS_OK.getSuccessCode());
    }
}
