package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public Department createDepartment(Department department){
        return departmentRepository.saveAndFlush(department);
    }
    public void deleteDepartment(long id){departmentRepository.deleteById(id);}

    public List<Department> findAll(){return departmentRepository.findAll();}

    public Optional<Department> findById(long id) {return departmentRepository.findById(id);}
}
