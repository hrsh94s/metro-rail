package metro.rail.metrorail.service;

import java.util.List;

import metro.rail.metrorail.model.FarePlan;

public interface FarePlanService {

	public void addFarePlan(FarePlan farePlan);

	public List<FarePlan> listFarePlan();
	
	public FarePlan update(FarePlan farePlan);
	
	public FarePlan getFarePlan(long id);

}
