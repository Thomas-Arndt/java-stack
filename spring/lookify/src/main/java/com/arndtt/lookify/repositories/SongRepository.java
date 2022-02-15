package com.arndtt.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arndtt.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtistContaining(String artist);
	List<Song> findAllByOrderByRatingDesc();
}
