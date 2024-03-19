package org.reg.resolveissueservice.repository;

import org.reg.resolveissueservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
}
