package G10.EQUIPO13.MediFlow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MediFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediFlowApplication.class, args);
	}

}
