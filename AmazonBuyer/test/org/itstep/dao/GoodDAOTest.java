package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.Goods;
import org.junit.Before;
import org.junit.Test;

public class GoodDAOTest {
	private String name;
	private String asin;

	@Before
	public void setDataBeforeTest() {
		name = "dress";
		asin = "uyt68";
	}
	
	@Test
	public void testSave() {

		GoodDAO goodDao = new GoodDAO();

		Goods good = new Goods(name, asin);
		
		good.setPrice("56");
		good.setGood_url("nkkk");
		good.setImg_url("ddddd");
		good.setInitial_price("76");

		goodDao.save(good);
		
		assertNotNull(goodDao.get(name, asin));

	}
	
	
	
	@Test
	public void testGet() {
		GoodDAO goodDao = new GoodDAO();

		goodDao.get(name, asin);
		assertNotNull(goodDao.get(name, asin));
		
		

	}

	@Test
	public void testUpdate() {
		GoodDAO goodDao = new GoodDAO();

		Goods goodUpdate = new Goods();
		goodUpdate.setName("nike");
		goodUpdate.setAsin("nike444");
		goodUpdate.setImg_url("re1");
		goodUpdate.setInitial_price("100");
		goodUpdate.setPrice("55");
		goodUpdate.setGood_url("mksmk");
				
		goodDao.update(name, asin, goodUpdate);
		
		assertNull(goodDao.get(name, asin).getGood_url());
		
		name = goodUpdate.getName();
		asin = goodUpdate.getAsin();
		
		assertEquals("mksmk", goodUpdate.getGood_url());
		

	}

	@Test
	public void testDelete() {
		GoodDAO goodDao = new GoodDAO();
		
		assertNotNull(goodDao.get(name, asin).getGood_url());
		
		goodDao.delete(name, asin);
		assertNull(goodDao.get(name, asin).getGood_url());

	}

}
