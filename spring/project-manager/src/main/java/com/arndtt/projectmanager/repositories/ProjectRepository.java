package com.arndtt.projectmanager.repositories;

import java.util.List;

import com.arndtt.projectmanager.models.Project;
import com.arndtt.projectmanager.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findAll();
    List<Project> findByUsersNotContaining(User user);
}
