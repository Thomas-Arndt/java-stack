package com.arndtt.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arndtt.lookify.models.Song;
import com.arndtt.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepository;
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public Song updateSong(Song song) {
		Optional<Song> optionalSong = songRepository.findById(song.getId());
		if(optionalSong.isPresent()) {
			return songRepository.save(song);
		} else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> songsByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	public List<Song> topCharts() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
}
