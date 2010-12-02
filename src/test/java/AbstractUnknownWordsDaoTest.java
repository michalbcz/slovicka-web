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

import cz.bernhard.slovicka.dao.IUnknownWordDao;
import cz.bernhard.slovicka.domains.Word;



public abstract class AbstractUnknownWordsDaoTest {
	
	private static SessionFactory sf;
	private IUnknownWordDao dao;
	
	protected abstract IUnknownWordDao createDaoImplementation();

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
		dao = createDaoImplementation();
	}
	
	@After
	public void afterEachTest() {
		
		/* delete all words */
		getSessionFactory().openSession().createQuery("delete from words").executeUpdate();
		
	}
	
	/* ------------------------ TESTS ----------------------------- */
	
	@Test
	public void saveTest() {
		Word word = new Word("asshole");
		dao.save(word);
		
		List<Word> allWords = dao.findAll();
		Assert.assertThat("contains an asshole word", allWords, JUnitMatchers.hasItem(word));
	}
	
	@Test
	public void noDataAfterDbCleanTest() {
		Word word = new Word("asshole").setId(1L);	
		
		List<Word> allWords = dao.findAll();
		Assert.assertFalse(allWords.contains(word));
	}
	

}
