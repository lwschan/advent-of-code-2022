package dev.lewischan.adventofcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AdventOfCodeApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdventOfCodeApplication.class, args);
  }
}
