package com.example.lezhinbackendtestproject.domain.artwork.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ArtWorkResponseDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    public static class ViewHistory {

        String artworkCode;
        String artworkName;
        LocalDateTime viewDate;
        String userId;
        String userName;

        @QueryProjection
        public ViewHistory(String artworkCode, String artworkName,LocalDateTime viewDate, String userId, String userName) {
            this.artworkCode = artworkCode;
            this.artworkName = artworkName;
            this.viewDate = viewDate;
            this.userId = userId;
            this.userName = userName;
        }

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    public static class BestArtwork {

        String artworkCode;
        String artworkName;
        Long totalCount;

        @QueryProjection
        public BestArtwork(String artworkCode, String artworkName, Long totalCount) {
            this.artworkCode = artworkCode;
            this.artworkName = artworkName;
            this.totalCount = totalCount;
        }

    }
}
