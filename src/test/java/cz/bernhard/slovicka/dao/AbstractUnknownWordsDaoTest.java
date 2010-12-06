package cz.bernhard.slovicka.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import cz.bernhard.slovicka.domains.User;
import cz.bernhard.slovicka.domains.Word;



public abstract class AbstractUnknownWordsDaoTest {
	
	private static SessionFactory sf;
	private IUnknownWordDao dao;
	private IUserDao userDao;
	
	protected abstract IUnknownWordDao createUnknownWordDaoImplementation();
	protected abstract IUserDao createUserDaoImplementation();

	protected SessionFactory getSessionFactory() {
		return sf;
	}

	@BeforeClass
	public static void beforeAllTests() {
		Configuration configuration = 
				new AnnotationConfiguration().configure("/WEB-INF/hibernate.cfg.xml");
		
		sf = configuration.buildSessionFactory();
		
	}

	@Before
	public void beforeEachTest() {		
		dao = createUnknownWordDaoImplementation();
		userDao = createUserDaoImplementation();
	}
	
	@After
	public void afterEachTest() {
		
		/* delete all words */
		getSessionFactory().openSession().createQuery("delete from words").executeUpdate();
		
	}
	
	/* ------------------------ TESTS ----------------------------- */
	
	@Test
	public void saveTest() {
		User user = new User().setUsername("michalb_cz").setPassword("i4ml33t");
		userDao.save(user);
		
		Word word = new Word("gonna").setUser(user);		
		dao.save(word);
		
		List<Word> allWords = dao.findAll();
		Assert.assertThat("contains an asshole word", allWords, JUnitMatchers.hasItem(word));
	}
	
	@Test(expected = Exception.class)
	public void failOnSaveOnNullUserTest() {
		Word word = new Word("be");
		dao.save(word);
	}
	
	@Test
	public void noDataAfterDbCleanTest() {
		Word word = new Word("legendary").setId(1L);	
		
		List<Word> allWords = dao.findAll();
		Assert.assertFalse(allWords.contains(word));
	}
	

}
