package metro.rail.metrorail.service;

import java.util.List;

import metro.rail.metrorail.model.MetroCard;
import metro.rail.metrorail.model.RechargeCard;

public interface MetroCardService {
	
	public float checkBalance(long phone);
	
	public float topUp(long phone, float amount);
	
	public void newMetroCard(MetroCard metroCard);
	
	public List<MetroCard> listMetroCard();
	
	public void deleteMetroCard(long id);

	public float recharge(RechargeCard rechargeCard);
	

}
