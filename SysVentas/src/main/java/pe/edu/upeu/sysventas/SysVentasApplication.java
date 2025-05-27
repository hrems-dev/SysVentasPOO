package pe.edu.upeu.sysventas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static javafx.application.Application.launch;
import javafx.scene.Parent;

@SpringBootApplication
public class SysVentasApplication {
	private static ConfigurableApplicationContext configurableApplicationContext;
	private Parent parent;

	public static void main(String[] args) {
		//SpringApplication.run(SysVentasApplication.class, args);
		launch(args);
	}
}
