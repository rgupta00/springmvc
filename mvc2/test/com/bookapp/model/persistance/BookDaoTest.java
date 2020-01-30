package com.bookapp.model.persistance;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:model-config.xml")
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
public class BookDaoTest {

	@Autowired
	private BookDao dao;
	@Test
	public void testGetBookById(){
		Book book=dao.getBookById(2);
		Assert.assertNotNull(book);
	}
	
	
	
}
