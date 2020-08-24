package com.socialnet.tshirt.repo;

import com.socialnet.tshirt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
