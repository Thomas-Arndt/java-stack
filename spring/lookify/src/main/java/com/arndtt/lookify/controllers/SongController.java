package com.arndtt.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arndtt.lookify.models.Song;
import com.arndtt.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String displaySong(@PathVariable("id") Long id,
			Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "showSong.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	@GetMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id,
			Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "editSong.jsp";
	}
	
	@PostMapping("/songs")
	public String create(@Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@PutMapping("/songs/{id}")
	public String update(@Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editSong.jsp";
		} else {
			songService.updateSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/songs/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/search")
	public String searchQuery(@RequestParam("searchQuery") String searchQuery) {
		return "redirect:/search/"+searchQuery;
	}
	
	@GetMapping("/search/{searchQuery}")
	public String artistSearch(@PathVariable("searchQuery") String searchQuery,
			Model model) {
		List<Song> songsByArtist = songService.songsByArtist(searchQuery);
		model.addAttribute("songsByArtist", songsByArtist);
		return "artistSearch.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topCharts = songService.topCharts();
		ArrayList<Song> topTen = new ArrayList<Song>();
		if(topCharts.size() > 10) {
			for(int i = 0; i < 10; i++) {
				topTen.add(topCharts.get(i));
			}
		} else {
			for(int i = 0; i < topCharts.size(); i++) {
				topTen.add(topCharts.get(i));
			}
		}
		model.addAttribute("topTen", topTen);
		return "topTen.jsp";
	}

}
