package tw.hibernatedemo.service;

import java.util.List;

import tw.dao.RestaurantDaoImpl;
import tw.hibernatedemo.model.Arrange;
import tw.hibernatedemo.model.Restaurant;

public class RestaurantDaoService implements RestaurantService {
	private RestaurantDaoImpl resDao;

	public boolean checkRes(int id) {

		return resDao.checkRes(id);
	}

	public void AddRestautant(Restaurant resBean) {
		resDao.AddRestautant(resBean);
	}

	public void DeleteRestaurant(Integer id) {
		resDao.DeleteRestaurant(id);
	}

	public void RewriteRestaurant(Restaurant resBean) {
		resDao.RewriteRestaurant(resBean);
	}

	public List<Restaurant> SearchRestaurant(int id) {
		return resDao.SearchRestaurant(id);
	}

	public List<Restaurant> selectAll() {
		return resDao.selectAll();
	}

	public List<Restaurant> SearchResAddress(String resturantaddress) {
		return resDao.SearchResAddress(resturantaddress);
	}

	public List<Restaurant> SearchResName(String resturantname) {
		return resDao.SearchResName(resturantname);
	}

	public List<Restaurant> SearchResType(String resturanttype) {
		return resDao.SearchResType(resturanttype);
	}

	public void AddArrange(Arrange arr) {
		resDao.AddArrange(arr);
	}

	public void DeleteArrange(int id) {
		resDao.DeleteArrange(id);
	}

	public void RewriteArrange(Arrange arrBean) {
		resDao.RewriteArrange(arrBean);
	}

	public List<Arrange> selectArrange() {
		return resDao.selectArrange();
	}

	public List<Arrange> selectArrangeName(String name) {
		return resDao.selectArrangeName(name);
	}

	public List<Arrange> selectArrangeResid(int resid) {
		return resDao.selectArrangeResid(resid);
	}

	public List<Arrange> selectArrangePhone(String phone) {
		return resDao.selectArrangePhone(phone);
	}

	public boolean checkArr(int id) {
		return resDao.checkArr(id);
	}
}
