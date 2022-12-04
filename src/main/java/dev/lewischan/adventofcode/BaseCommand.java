package dev.lewischan.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.IOUtils;

public abstract class BaseCommand {

  protected static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yy");

  protected final Year year;
  protected final int day;
  protected final String commandInput;

  protected BaseCommand(String commandKey) {
    this.year = Year.parse(commandKey.substring(0, 2), YEAR_FORMATTER);
    this.day = Integer.parseInt(commandKey.substring(3, 5));
    this.commandInput = "%s.txt".formatted(commandKey);
  }

  public void run() throws IOException {
    System.out.printf("Running the solution for year %s day %s.%n", year, day);
  }

  protected InputStream getQuizFileAsIOStream() {
    var ioStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream(commandInput);

    if (ioStream != null) {
      return ioStream;
    }
    throw new IllegalArgumentException("%s could not be found.".formatted(commandInput));
  }

  protected String getQuizFileAsString() throws IOException {
    var inputStream = getQuizFileAsIOStream();
    var writer = new StringWriter();
    IOUtils.copy(inputStream, writer, Charset.defaultCharset());
    return writer.toString();
  }
}
