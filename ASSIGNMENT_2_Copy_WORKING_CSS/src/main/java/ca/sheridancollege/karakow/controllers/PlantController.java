package ca.sheridancollege.karakow.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.Plant;
import ca.sheridancollege.karakow.repositories.PlantList;

@Controller
public class PlantController {

	private PlantList plantList;
	private PlantList plantSearch;

	public void setPlantList(PlantList plantList) {
		this.plantList = plantList;
	}

	@Autowired
	public PlantController(PlantList plantList) {
		super();
		this.plantList = plantList;
	}

	@GetMapping("/")
	public String goHome(Model model) {

		model.addAttribute("plant", new Plant());
		model.addAttribute("plantList", plantList.getPlantList());

		return "index";
	}

	@GetMapping("/addPlant")
	public String addPlant(Model model) {

		model.addAttribute("plant", new Plant());
		model.addAttribute("plantList", plantList.getPlantList());

		return "addPlant";
	}

	@GetMapping("/searchPlant")
	public String searchPlant(Model model) {

		model.addAttribute("plant", new Plant());
		model.addAttribute("plantList", plantList.getPlantList());
		return "searchPlant";

	}
	
	@PostMapping("/searchPlant")
	public String searchPlants(Model model, @ModelAttribute Plant plant, @RequestParam String plantType) {
		
		Collection<Plant> searchList = new ArrayList<>();
		for (Plant one:plantList.getPlantList()) {
			if (one.getPlantType().contains(plantType)) {
				searchList.add(one);
				
				model.addAttribute("plant", new Plant());
				model.addAttribute("searchList", searchList);
				System.out.println(plant);
			}
		}
		return "searchPlant";
	}

	@GetMapping("/displayPlants")
	public String displayPlants(Model model) {

		model.addAttribute("plant", new Plant());
		model.addAttribute("plantList", plantList.getPlantList());

		return "displayPlants";
	}

	@PostMapping("/processForm")
	public String processForm(Model model, @ModelAttribute Plant plant) {

		model.addAttribute("plant", new Plant());
		model.addAttribute("plantList", plantList.getPlantList());

		plantList.getPlantList().add(plant);

		return "addPlant";

	}

}
