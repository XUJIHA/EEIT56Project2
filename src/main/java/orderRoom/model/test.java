package orderRoom.model;

import roomtype.model.RoomsBean;

public class test {
	public static RoomsBean getTestBean() {
		
		RoomsBean testBean = new RoomsBean();
		testBean.setRoomId("A01");
		testBean.setName("單人房");
		testBean.setStatus(1);
		testBean.setCapacity(1);
		testBean.setBed(1);
		testBean.setSize(30);
		testBean.setPrice(2000);
		testBean.setImg(null);
		testBean.setDescription("abc");
		testBean.setEquipment("xyz");
		
		return testBean;
	}

}
