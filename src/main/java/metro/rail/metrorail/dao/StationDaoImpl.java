package metro.rail.metrorail.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import metro.rail.metrorail.model.Station;

@Repository
public class StationDaoImpl implements StationDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Station> getAllStations(){
		return sessionFactory.getCurrentSession().createQuery("from Station").list();

	}
	
	public void addStation(Station station) {
		sessionFactory.getCurrentSession().saveOrUpdate(station);
	}
}
