package metro.rail.metrorail.dao;

import java.util.List;

import metro.rail.metrorail.model.MetroCard;

public interface MetroCardDao {

	public MetroCard get(long id);
	
	public MetroCard getByPhone(long phone);
	
	public void update(MetroCard metroCard);
	
	public List<MetroCard> listMetroCard();
	
	public void deleteMetroCard(long id);
	
	
}
