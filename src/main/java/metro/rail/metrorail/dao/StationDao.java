package metro.rail.metrorail.dao;

import java.util.List;

import metro.rail.metrorail.model.Station;

public interface StationDao {

	public List<Station> getAllStations();
	public void addStation(Station station);
	
}
