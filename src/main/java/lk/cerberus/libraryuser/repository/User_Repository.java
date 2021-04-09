package lk.cerberus.libraryuser.repository;

import lk.cerberus.libraryuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends CrudRepository<User,String>, JpaRepository<User,String> {

}
