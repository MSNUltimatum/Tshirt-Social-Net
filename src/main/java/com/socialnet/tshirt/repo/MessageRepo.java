package com.socialnet.tshirt.repo;

import com.socialnet.tshirt.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
