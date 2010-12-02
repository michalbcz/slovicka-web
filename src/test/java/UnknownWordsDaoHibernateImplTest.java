import org.springframework.orm.hibernate3.HibernateTemplate;

import cz.bernhard.slovicka.dao.IUnknownWordDao;
import cz.bernhard.slovicka.dao.UnknownWordsDaoHibernateImpl;


public class UnknownWordsDaoHibernateImplTest extends AbstractUnknownWordsDaoTest {

	@Override
	protected IUnknownWordDao createDaoImplementation() {
		UnknownWordsDaoHibernateImpl dao = new UnknownWordsDaoHibernateImpl();
		dao.setSessionFactory(getSessionFactory());
		dao.setHibernateTemplate(new HibernateTemplate(getSessionFactory()));
		
		return dao;
	}

}
