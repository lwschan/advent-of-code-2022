package dev.lewischan.adventofcode;

import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public abstract class BaseDayCommand {

  protected static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yy");

  protected final Year year;
  protected final int day;
  protected final String commandInput;
  protected final String commandKey;

  protected BaseDayCommand(String commandKey) {
    this.year = Year.parse(commandKey.substring(0, 2), YEAR_FORMATTER);
    this.day = Integer.parseInt(commandKey.substring(3, 5));
    this.commandInput = "%s.txt".formatted(commandKey);
    this.commandKey = commandKey;

    System.out.printf("Running the solution for year %s day %s.%n", year, day);
  }

  public abstract void execute() throws IOException;

  protected InputStream getQuizFileAsIOStream() {
    var ioStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream(commandInput);

    if (ioStream != null) {
      return ioStream;
    }
    throw new IllegalArgumentException("%s could not be found.".formatted(commandInput));
  }
}
