package com.indivara.micro.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indivara.micro.core.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findByUserName(String userName);
}
