package ca.sheridancollege.karakow.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.karakow.beans.Plant;

@Component
public class PlantListImplementation implements PlantList {
	
	private List<Plant> plantList = new CopyOnWriteArrayList<Plant>();
//	private List<Plant> plantSearch = new CopyOnWriteArrayList<Plant>();

	@Override
	public List<Plant> getPlantList() {
		return plantList;
	}

	@Override
	public void setPlantList(List<Plant> plantList) {
		this.plantList = plantList;
	}

	@Override
	public void emptyList() {
		plantList.clear();
	}

//	@Override
//	public void setPlantSearch(List<Plant> plantSearch) {
//		this.plantSearch = plantSearch;
//		
//	}
//
//	@Override
//	public List<Plant> getPlantSearch() {
//		return plantSearch;
//	}
}
