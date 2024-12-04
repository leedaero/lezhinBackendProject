package com.example.lezhinbackendtestproject.repository.artwork;

import com.example.lezhinbackendtestproject.entity.artwork.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork,Long>, QueryArtworkRepository {
}
