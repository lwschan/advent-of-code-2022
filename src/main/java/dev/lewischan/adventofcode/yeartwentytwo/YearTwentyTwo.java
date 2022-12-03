package dev.lewischan.adventofcode.yeartwentytwo;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class YearTwentyTwo {

  @ShellMethod(value = "Add numbers.", key = "sum")
  public int add(int a, int b) {
    return a + b;
  }
}
