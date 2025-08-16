package com.fastcampus.resttemplatesandbox.repository;

import com.fastcampus.resttemplatesandbox.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
