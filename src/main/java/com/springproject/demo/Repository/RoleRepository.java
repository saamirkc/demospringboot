package com.springproject.demo.Repository;

import com.springproject.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  public Role findByRoleName(String roleName);
}
