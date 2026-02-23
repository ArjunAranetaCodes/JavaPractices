package com.projectmanagement.service;

import com.projectmanagement.model.Project;
import com.projectmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.orElse(null);
    }

    public List<Project> searchProjects(String query) {
        return projectRepository.searchProjects(query);
    }

    public List<Project> getProjectsByStatus(Project.Status status) {
        return projectRepository.findByStatus(status);
    }

    public List<Project> getProjectsByPriority(Project.Priority priority) {
        return projectRepository.findByPriority(priority);
    }

    public List<Project> getProjectsByCategory(Project.Category category) {
        return projectRepository.findByCategory(category);
    }

    public Project createProject(Project project) {
        if (project.getProgress() == null) {
            project.setProgress(0);
        }
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(projectDetails.getName());
            project.setDescription(projectDetails.getDescription());
            project.setStatus(projectDetails.getStatus());
            project.setPriority(projectDetails.getPriority());
            project.setCategory(projectDetails.getCategory());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            project.setProgress(projectDetails.getProgress() != null ? projectDetails.getProgress() : 0);
            project.setBudget(projectDetails.getBudget());
            project.setTeamMembers(projectDetails.getTeamMembers());
            project.setProjectManager(projectDetails.getProjectManager());
            project.setNotes(projectDetails.getNotes());
            return projectRepository.save(project);
        }
        return null;
    }

    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

