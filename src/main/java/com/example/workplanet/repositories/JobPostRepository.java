package com.example.workplanet.repositories;

import com.example.workplanet.entities.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByAppUser_Username(String username);

}
