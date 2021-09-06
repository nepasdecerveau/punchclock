package ch.zli.m223.punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.zli.m223.punchclock.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
