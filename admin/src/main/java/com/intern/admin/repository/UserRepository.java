package com.intern.admin.repository;

import com.intern.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDisable(@Param("disable") boolean disable);

    Optional<User> findByIdAndDisable(Long userId, boolean disable);
}
