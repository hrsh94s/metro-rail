package metro.rail.metrorail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metro.rail.metrorail.dao.MetroCardDao;
import metro.rail.metrorail.model.MetroCard;
import metro.rail.metrorail.model.RechargeCard;

@Service
@Transactional
public class MetroCardServiceImpl implements MetroCardService {

	@Autowired
	private MetroCardDao metroCardDao;
	
	
	
	@Override
	public float checkBalance(long phone) {
		
		return metroCardDao.getByPhone(phone).getBalance();
		
		// TODO Auto-generated method stub
	}
	
	@Transactional
	@Override
	public float topUp(long phone, float amount) {
		
		MetroCard metroCard = metroCardDao.getByPhone(phone);
		float balance = metroCard.getBalance();
		balance += amount;
		metroCard.setBalance(balance);
		metroCardDao.update(metroCard);
		return balance;
	}

	public void newMetroCard(MetroCard metroCard) {
		metroCardDao.update(metroCard);
	}

	@Override
	public List<MetroCard> listMetroCard() {
		return metroCardDao.listMetroCard();
	}
	
	public void deleteMetroCard(long id) {
		metroCardDao.deleteMetroCard(id);
	}

	@Override
	public float recharge(RechargeCard rechargeCard) {
		
		MetroCard metroCard = metroCardDao.getByPhone(rechargeCard.getPhone());
		float balance = metroCard.getBalance();
		
		balance += rechargeCard.getAmount();
		metroCard.setBalance(balance);
		
		metroCardDao.update(metroCard);
		
		return balance;
		
	}
	


}
