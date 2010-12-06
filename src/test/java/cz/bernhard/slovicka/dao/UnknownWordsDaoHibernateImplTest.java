package cz.bernhard.slovicka.dao;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class UnknownWordsDaoHibernateImplTest extends AbstractUnknownWordsDaoTest {

	@Override
	protected IUnknownWordDao createUnknownWordDaoImplementation() {
		UnknownWordsDaoHibernateImpl dao = new UnknownWordsDaoHibernateImpl();
		dao.setSessionFactory(getSessionFactory());
		dao.setHibernateTemplate(new HibernateTemplate(getSessionFactory()));
		
		return dao;
	}
	
	@Override
	protected IUserDao createUserDaoImplementation() {
		UserDaoHibernateImpl dao = new UserDaoHibernateImpl();
		dao.setSessionFactory(getSessionFactory());
		dao.setHibernateTemplate(new HibernateTemplate(getSessionFactory()));
		
		return dao;
	}

}
