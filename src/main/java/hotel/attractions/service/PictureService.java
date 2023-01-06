package hotel.attractions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.attractions.model.Picture;
import hotel.attractions.model.PictureDao;

@Service
@Transactional
public class PictureService {

	@Autowired
	private PictureDao pDao;
	
	public Picture insert(Picture p) {
		return pDao.insert(p);
	}
}
