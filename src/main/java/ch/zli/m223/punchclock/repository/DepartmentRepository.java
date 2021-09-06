package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
