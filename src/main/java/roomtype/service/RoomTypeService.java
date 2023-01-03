package roomtype.service;

import java.sql.Blob;
import java.util.List;

import roomtype.model.RoomsBean;

public interface RoomTypeService {
	
	public List<RoomsBean> findAll();

	public List<RoomsBean> findAnyMatch(String input);

	public List<RoomsBean> findById(String Id);

	public List<RoomsBean> findByCapacity(int capacity);

	public List<RoomsBean> findByName(String name);

	public List<RoomsBean> findByStatus(int status);

	public List<RoomsBean> findByCapacityAndStatus(int capacity, int status);

	public List<RoomsBean> findByPriceRange(int minPrice, int maxPrice);

	public List<RoomsBean> findByMinPrice(int minPrice);

	public List<RoomsBean> findByMaxPrice(int maxPrice);

	public List<RoomsBean> findByCapacityAndPriceRange(int capacity, int minPrice, int maxPrice);

	public List<RoomsBean> findByStatusAndPriceRange(int status, int minPrice, int maxPrice);

	public List<RoomsBean> findByCapacityAndStatusAndPriceRange(int capacity, int status, int minPrice, int maxPrice);

	public int insertRoomType(RoomsBean bean);

	public int insertRoomType(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment);

	public int updateStatusById(String id, int status);

	public int updateNameById(String id, String name);

	public int updateFormById(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment);

	public int deleteById(String id);

	public int discount(); // 計算折扣價錢
	
	
	
	
}
