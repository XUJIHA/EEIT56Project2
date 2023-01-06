package hotel.attractions.service;

import java.util.List;

import hotel.attractions.model.AttractionsBean;

public interface IAttractionsService {
	public AttractionsBean findById(int id);
	
	public List<AttractionsBean> findAll();

	
	public List<AttractionsBean> likeSearch(String search);
	
	public AttractionsBean save(AttractionsBean bean);
	
	public AttractionsBean updateAttractions(AttractionsBean bean);
	
	public boolean deleteById(int id);
}
