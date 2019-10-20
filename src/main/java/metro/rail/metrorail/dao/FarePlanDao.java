package metro.rail.metrorail.dao;

import java.util.List;

import metro.rail.metrorail.model.FarePlan;

public interface FarePlanDao {

	public void addFarePlan(FarePlan farePlan);
		
	public List<FarePlan> listFarePlan();
	
	public FarePlan update(FarePlan farePlan);
	
	public FarePlan getFarePlan(long id);
}
