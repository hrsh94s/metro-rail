package metro.rail.metrorail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metro.rail.metrorail.dao.FarePlanDao;
import metro.rail.metrorail.model.FarePlan;

@Service
@Transactional
public class FarePlanServiceImpl implements FarePlanService{
	
	@Autowired
	private FarePlanDao farePlanDao;
	
	public void addFarePlan(FarePlan farePlan) {
		farePlanDao.addFarePlan(farePlan);
	}
	

	
	@Transactional
	public List<FarePlan> listFarePlan(){
		return farePlanDao.listFarePlan();
	}

	public FarePlan update(FarePlan farePlan) {
		return farePlanDao.update(farePlan);
	}
	
	public FarePlan getFarePlan(long id) {
		return farePlanDao.getFarePlan(id);
	}


}
