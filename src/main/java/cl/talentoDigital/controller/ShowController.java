package cl.talentoDigital.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.talentoDigital.model.Rating;
import cl.talentoDigital.model.Show;
import cl.talentoDigital.model.User;
import cl.talentoDigital.service.RatingService;
import cl.talentoDigital.service.ShowService;
import cl.talentoDigital.service.UserService;

@Controller
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping(value = "/{id}/add")
	public String addRating(@Valid @ModelAttribute("addRating") Rating rating, BindingResult result,
			@PathVariable("id") Long id, Principal principal) {
		if(result.hasErrors()) {
			return "redirect/shows/" + id;
		}else {
			String email = principal.getName();
			User currentUser = userService.findUserByEmail(email);
			Show currentShow = showService.findById(id);
			
			rating.setUser(currentUser);
			rating.setShow(currentShow);
			ratingService.addRating(rating);
			currentShow.setRatings(ratingService.findAllRatings());
			showService.updateShow(currentShow);
			
			return "redirect:/shows/" + id;
		}
	}
	
	
	//READ ONE
	
	@GetMapping(value = "/{id}")
	public String getShow(@PathVariable("id") Long id, Model model, Principal principal) {

		Show show = showService.findById(id);
	
		User creatorShow = show.getCreatorShow();
		String email = principal.getName();
		User currentUser = userService.findUserByEmail(email);
		List<Rating> showRatings = show.getRatings();
		Rating newRating = new Rating();
		model.addAttribute("addRating", newRating);
		model.addAttribute("showRatings", showRatings);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("show", show);
		model.addAttribute("creatorShow", creatorShow);
		
		return "show";
	}
	
	
	//READ ALL
	@GetMapping("")
	public String homePage(Principal principal, Model model) {
		String email = principal.getName();
		User currentUser = userService.findUserByEmail(email);
		List<Show> allShows = showService.findAllShows();
		model.addAttribute("allShows", allShows);
		model.addAttribute("currentUser", currentUser);
		
		return "home";
	}
	
	//CREATE NEW
	@GetMapping(value = "/new")
	public String newShow(Model model) {
		Show newShow = new Show();
		model.addAttribute("newShow", newShow);
		return "new";
	
	}
	
	//CREATE SAVE
	@PostMapping(value = "/create")
	public String createShow(@ModelAttribute("newShow") @Valid Show show, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "new";
		}else {
			String email = principal.getName();
			User creatorShow = userService.findUserByEmail(email);
			show.setCreatorShow(creatorShow);
			showService.saveShow(show);
			return "redirect:/";
		}
	}
	
	//EDIT
	@GetMapping(value="/{id}/edit")
	public String editShow(@PathVariable("id") Long id, Model model, @ModelAttribute("errors") String errors) {
		Show editShow = showService.findById(id);
		model.addAttribute("editShow", editShow);
		return "edit";
	}
	
	//UPDATE
	@PostMapping(value = "/{id}/edit")
	public String updateShow(@PathVariable("id") Long id, @Valid @ModelAttribute("editShow") Show editedShow, BindingResult result, 
			Model model, Principal principal, HttpSession session) {
		String email = principal.getName();
		Show show = showService.findById(id);
		User creatorShow = userService.findUserByEmail(email);
		
		if(result.hasErrors()) {
			session.setAttribute("id", show.getId());
			return "redirect:/shows/createerror";
		}else {
			editedShow.setCreatorShow(creatorShow);
			showService.updateShow(editedShow);
			return "redirect:/shows";
		}
		
	}
	
	//destroy
	
	@GetMapping(value = "/{id}/delete")
	public String deleteShow(@PathVariable("id") Long id) {
		showService.deleteShow(id);
		return "redirect:/shows";
	}
	

}
