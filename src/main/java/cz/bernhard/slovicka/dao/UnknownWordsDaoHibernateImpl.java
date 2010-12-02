package cz.bernhard.slovicka.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import cz.bernhard.slovicka.domains.Word;

public class UnknownWordsDaoHibernateImpl extends HibernateDaoSupport implements IUnknownWordDao {

	public Word save(Word word) {
		Long id = (Long) getHibernateTemplate().save(word);
		Assert.isTrue(id.equals(word.getId()));
		return word;
	}

	public List<Word> findAll() {
		return getHibernateTemplate().find("from words");
	}

}
