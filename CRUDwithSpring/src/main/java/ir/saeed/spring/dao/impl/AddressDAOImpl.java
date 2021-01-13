package ir.saeed.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ir.saeed.spring.dao.AddressDAO;
import ir.saeed.spring.entities.Address;

@Repository("addressDAO")
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Integer create(Address entity) {
		Integer res = (Integer) hibernateTemplate.save(entity);
		return res;
	}

	public Address read(Integer id) {
		return hibernateTemplate.get(Address.class, id);
	};

	public void update(Address entity) {
		hibernateTemplate.update(entity);
	}

	public void delete(Integer id) {
		hibernateTemplate.delete(hibernateTemplate.load(Address.class, id));
	}

	public List<Address> getAll() {
		return hibernateTemplate.loadAll(Address.class);
	}

}
