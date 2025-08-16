package com.fastcampus.resttemplatesandbox.repository;

import com.fastcampus.resttemplatesandbox.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
