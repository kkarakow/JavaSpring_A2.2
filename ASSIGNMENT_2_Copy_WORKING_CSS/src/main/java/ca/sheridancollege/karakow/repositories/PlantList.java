package ca.sheridancollege.karakow.repositories;

import java.util.List;

import ca.sheridancollege.karakow.beans.Plant;

public interface PlantList {

	public List<Plant> getPlantList();
//	public List<Plant> getPlantSearch();
	public void setPlantList(List<Plant> plantList);
//	public void setPlantSearch(List<Plant> plantSearch);
	public void emptyList();
	
}
