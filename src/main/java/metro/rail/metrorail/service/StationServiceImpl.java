package metro.rail.metrorail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metro.rail.metrorail.dao.StationDao;
import metro.rail.metrorail.model.Station;

@Service
@Transactional
public class StationServiceImpl implements StationService {

	@Autowired
	private StationDao stationDao;
	
	@Transactional
	public List<Station> getAllStations(){
		return stationDao.getAllStations();
	}
	
	@Transactional
	public void addStation(Station station) {
		
		stationDao.addStation(station);
	}
}
