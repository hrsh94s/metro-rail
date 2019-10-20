package metro.rail.metrorail.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import metro.rail.metrorail.model.FarePlan;
import metro.rail.metrorail.model.MetroCard;

@Repository
public class MetroCardDaoImpl implements MetroCardDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<MetroCard> listMetroCard(){
		return sessionFactory.getCurrentSession().createQuery("from MetroCard").list();
	}
	
	public MetroCard get(long id) {
		
		return (MetroCard)sessionFactory.getCurrentSession().get(MetroCard.class, id);
	}
	
	
	
	public void update(MetroCard metroCard) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(metroCard);
	}

	


	@Override
	public MetroCard getByPhone(long phone) {
	//	try {
			return (MetroCard)sessionFactory.getCurrentSession().createCriteria(MetroCard.class).add(Restrictions.eq("phone", phone)).uniqueResult();

	//	} catch (HibernateException e) {
	//		return null;
	//	}
		// TODO Auto-generated method stub
	}
	
	public void deleteMetroCard(long id) {
		MetroCard metroCard = (MetroCard) sessionFactory.getCurrentSession().load(MetroCard.class, id);
		
		if(null != metroCard) {
			this.sessionFactory.getCurrentSession().delete(metroCard);
		}
	}

	
	
}
