package hotel.attractions.model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAttractionsDao {
	
	public AttractionsBean findById(int id);
	
	public List<AttractionsBean> findAll();

	
	public List<AttractionsBean> likeSearch(String search);
	
	public AttractionsBean save(AttractionsBean bean);
	
	public AttractionsBean updateAttractions(AttractionsBean bean);
	
	public boolean deleteById(int id);
}
