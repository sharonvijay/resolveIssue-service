package org.reg.resolveissueservice.repository;

import org.reg.resolveissueservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
