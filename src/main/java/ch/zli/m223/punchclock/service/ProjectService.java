package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.repository.ProjectRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){this.projectRepository = projectRepository;}

    public Project createProject(Project project){
        return projectRepository.saveAndFlush(project);
    }
    public void deleteProject(long id){projectRepository.deleteById(id);}

    public List<Project> findAll(){return projectRepository.findAll();}

    public Optional<Project> getById(long id) {return projectRepository.findById(id);}
}
