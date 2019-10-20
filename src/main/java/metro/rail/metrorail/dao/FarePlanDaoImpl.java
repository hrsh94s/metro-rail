package metro.rail.metrorail.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import metro.rail.metrorail.model.FarePlan;

@Repository
public class FarePlanDaoImpl implements FarePlanDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addFarePlan(FarePlan farePlan) {
		sessionFactory.getCurrentSession().saveOrUpdate(farePlan);
	}
	
	public List<FarePlan> listFarePlan(){
		return sessionFactory.getCurrentSession().createQuery("from FarePlan").list();

	}
	
	public FarePlan update(FarePlan farePlan) {
		
		sessionFactory.getCurrentSession().update(farePlan);

		return farePlan;
	}
	
	public FarePlan getFarePlan(long id) {
		return (FarePlan) sessionFactory.getCurrentSession().get(FarePlan.class, id);
	}

	
}
