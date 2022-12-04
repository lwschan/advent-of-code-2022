package dev.lewischan.adventofcode;

import java.time.Year;
import java.time.format.DateTimeFormatter;

public abstract class BaseCommand {

  protected static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yy");

  protected final Year year;
  protected final int day;

  protected BaseCommand(String commandKey) {
    this.year = Year.parse(commandKey.substring(0, 2), YEAR_FORMATTER);
    this.day = Integer.parseInt(commandKey.substring(3, 5));
  }

  public void Run() {
    System.out.printf("Running the solution for year %s day %s%n", year, day);
  }
}
