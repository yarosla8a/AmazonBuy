package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.AmazonAcc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest {

	private String firstName;
	private String secondName;
	private String login;
	private String password;

	@Before
	public void setDataBeforeTest() {
		firstName = "Abcdefg";
		secondName = "Qwertyui";
		login = "tgh45@gmail.com";
		password = "1111";

	}
	@After
	public void deletAccountAfterTest() {
		AccountDao accDao = new AccountDao();
		accDao.delete(firstName, secondName);
		
	}
	@Test
	public void testSave() {
		AccountDao accDao = new AccountDao();

		AmazonAcc account = new AmazonAcc();

		accDao.save(account);

		assertNotNull(account.getFirstName());

	}

	@Test
	public void testGet() {
		AccountDao accDao = new AccountDao();
		AmazonAcc account = new AmazonAcc(firstName, secondName, login, password);

		accDao.get(firstName, secondName);
		assertNotNull(accDao.get(firstName, secondName));

	}

	@Test
	public void testUpdate() {
		AccountDao accDao = new AccountDao();

		assertNotNull(accDao.get(firstName, secondName).getLogin());

		AmazonAcc account = new AmazonAcc();
		account.setFirstName("yfgfkyta");
		account.setSecondName("tyu");
		account.setLogin("ghyyu");
		account.setPassword("hkgj");

		accDao.update(firstName, secondName, account);

		assertNull(accDao.get(firstName, secondName).getLogin());

		firstName = account.getFirstName();
		secondName = account.getSecondName();

		assertEquals("ghyyu", account.getLogin());

	}

	@Test
	public void testDelete() {
		AccountDao accDao = new AccountDao();

		assertNotNull(accDao.get(firstName, secondName).getLogin());

		accDao.delete(firstName, secondName);

		assertNull(accDao.get(firstName, secondName).getLogin());

	}

	// @After
	// public void deleteDataAfterTest{
	//
	//
	// }
	//

}
