package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import ch.zli.m223.punchclock.service.DepartmentService;
import ch.zli.m223.punchclock.service.ProjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class PunchclockApplication implements CommandLineRunner {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ApplicationUserService applicationUserService;
	private final DepartmentService departmentService;
	private final ProjectService projectService;

	public PunchclockApplication(ApplicationUserService applicationUserService, DepartmentService departmentService, ProjectService projectService) {
		this.applicationUserService = applicationUserService;
		this.departmentService = departmentService;
		this.projectService = projectService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		bCryptPasswordEncoder =  new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(PunchclockApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setUsername("admin");
		applicationUser.setPassword(bCryptPasswordEncoder.encode("admin"));
		applicationUserService.tryAddUser(applicationUser);

		Department department1 = new Department();
		department1.setName("IT");

		Project project = new Project();
		project.setEnd_at(LocalDateTime.now());
		project.setName("Webseite");
		project.setDepartment(department1);

		Project project1 = new Project();
		project1.setEnd_at(LocalDateTime.now());
		project1.setName("App");
		project1.setDepartment(department1);

		Department department = new Department();
		department.setName("hr");

		Project project2 = new Project();
		project2.setEnd_at(LocalDateTime.now());
		project2.setName("Kaffee");
		project2.setDepartment(department);

		Project project3 = new Project();
		project3.setEnd_at(LocalDateTime.now());
		project3.setName("Bewerbung");
		project3.setDepartment(department);

		Department department2 = new Department();
		department2.setName("KV");

		Project project4 = new Project();
		project4.setEnd_at(LocalDateTime.now());
		project4.setName("Kuchen");
		project4.setDepartment(department2);

		Project project5 = new Project();
		project5.setEnd_at(LocalDateTime.now());
		project5.setName("Plaudern");
		project5.setDepartment(department2);

		departmentService.createDepartment(department);
		departmentService.createDepartment(department1);
		departmentService.createDepartment(department2);
		
		projectService.createProject(project);
		projectService.createProject(project1);
		projectService.createProject(project2);
		projectService.createProject(project3);
		projectService.createProject(project4);
		projectService.createProject(project5);
	}
}