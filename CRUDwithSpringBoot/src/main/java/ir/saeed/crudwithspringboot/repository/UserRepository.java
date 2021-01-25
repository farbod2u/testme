package ir.saeed.crudwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.saeed.crudwithspringboot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
