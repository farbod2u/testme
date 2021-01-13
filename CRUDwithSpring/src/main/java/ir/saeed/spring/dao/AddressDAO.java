package ir.saeed.spring.dao;

import java.util.List;

import ir.saeed.spring.entities.Address;

public interface AddressDAO {
	public Integer create(Address entity);

	public Address read(Integer id);

	public void update(Address entity);

	public void delete(Integer id);

	public List<Address> getAll();
}
