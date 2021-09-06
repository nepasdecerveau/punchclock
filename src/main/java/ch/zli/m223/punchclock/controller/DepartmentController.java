package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){this.departmentService = departmentService;}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getAllDepartments(){return departmentService.findAll();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department createDepartment(@Valid @RequestBody Department department){return departmentService.createDepartment(department);}
}
