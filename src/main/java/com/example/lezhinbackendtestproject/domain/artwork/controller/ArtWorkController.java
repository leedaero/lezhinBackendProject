package com.example.lezhinbackendtestproject.domain.artwork.controller;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.domain.artwork.service.ArtWorkService;
import com.example.lezhinbackendtestproject.domain.artwork.service.ArtWorkViewService;
import com.example.lezhinbackendtestproject.global.response.common.ApiResponse;
import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/artworks")
@Tag(name = "Lezhin Backend Api")
public class ArtWorkController {
    private final ArtWorkViewService artWorkViewService;
    private final ArtWorkService artWorkService;

    @GetMapping("/history")
    @Operation(summary = "artwork history api", description = "작품 조회 이력 API")
    public ResponseEntity<ApiResponse> artworkViewHistory() {
        return ApiResponse.toResponseEntity(ApiSuccessCode.RESPONSE_SUCCESS_OK,artWorkViewService.findByArtworkViewHistory()) ;
    }

    @GetMapping("/best")
    @Operation(summary = "best artwork api", description = "인기 작품 조회 API")
    public ResponseEntity<ApiResponse> bestArtwork() {
        return ApiResponse.toResponseEntity(ApiSuccessCode.RESPONSE_SUCCESS_OK,artWorkService.findByBestArtworkList()) ;
    }

    @DeleteMapping("/{artworkCode}")
    @Operation(summary = "delete artwork and history api", description = "작품 및 이력 삭제 API")
    public ResponseEntity<ApiResponse> artworksDelete(@PathVariable("artworkCode") String artworkCode) {
        try {
            artWorkService.deleteArtwork(artworkCode);
            return ApiResponse.toResponseEntity(ApiSuccessCode.DELETE_SUCCESS) ;
        }catch (RestBusinessException e){
            return ApiResponse.toResponseEntity(e.getErrorCode()) ;
        }
    }
}
