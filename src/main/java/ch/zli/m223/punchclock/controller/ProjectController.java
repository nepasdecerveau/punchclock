package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.DepartmentService;
import ch.zli.m223.punchclock.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;
    private final DepartmentService departmentService;

    public ProjectController(ProjectService projectService, DepartmentService departmentService){this.projectService = projectService;
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjectsOfDepartment(@PathVariable int departmentId){
        return departmentService.findById(departmentId).get().getProjects();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project){return projectService.createProject(project);}
}
