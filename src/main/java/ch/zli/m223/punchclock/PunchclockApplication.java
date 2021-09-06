package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PunchclockApplication implements CommandLineRunner {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ApplicationUserService applicationUserService;

	public PunchclockApplication(ApplicationUserService applicationUserService) {
		this.applicationUserService = applicationUserService;
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
	}
}
