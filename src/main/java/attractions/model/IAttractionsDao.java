package attractions.model;

import java.util.List;

public interface IAttractionsDao {
	
	public AttractionsBean findById(int id);
	
	public List<AttractionsBean> findAll();

	
	public List<AttractionsBean> likeSearch(String search);
	
	public AttractionsBean save(AttractionsBean bean);
	
	public AttractionsBean updateAttractions(AttractionsBean bean);
	
	public boolean deleteById(int id);
}
