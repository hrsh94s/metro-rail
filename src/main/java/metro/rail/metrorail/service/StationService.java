package metro.rail.metrorail.service;

import java.util.List;

import metro.rail.metrorail.model.Station;

public interface StationService {

	public void addStation(Station station);
	
	public List<Station> getAllStations();	
}
