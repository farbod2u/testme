package ir.saeed.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.saeed.spring.dao.AddressDAO;
import ir.saeed.spring.entities.Address;
import ir.saeed.spring.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO dao;

	@Transactional
	public Integer create(Address entity) {
		return dao.create(entity);
	}

	public Address read(Integer id) {
		return dao.read(id);
	}

	@Transactional
	public void update(Address entity) {
		dao.update(entity);
	}

	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<Address> getAll() {
		return dao.getAll();
	}

}
