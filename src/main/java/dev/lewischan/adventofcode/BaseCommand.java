package dev.lewischan.adventofcode;

import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public abstract class BaseCommand {

  protected static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yy");

  protected final Year year;
  protected final int day;
  protected final String commandInput;
  protected final String commandKey;

  protected InputStream inputStream;

  protected BaseCommand(String commandKey) {
    this.year = Year.parse(commandKey.substring(0, 2), YEAR_FORMATTER);
    this.day = Integer.parseInt(commandKey.substring(3, 5));
    this.commandInput = "%s.txt".formatted(commandKey);
    this.commandKey = commandKey;
  }

  public void run() throws IOException {
    System.out.printf("Running the solution for year %s day %s.%n", year, day);

    inputStream = getQuizFileAsIOStream();
  }

  protected void processAnswers() throws IOException {
    partOne();
    partTwo();
  }

  protected abstract void partOne();

  protected abstract void partTwo();

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
