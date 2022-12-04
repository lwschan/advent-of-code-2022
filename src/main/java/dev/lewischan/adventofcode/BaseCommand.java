package dev.lewischan.adventofcode;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.IOUtils;

public abstract class BaseCommand {

  protected static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yy");

  protected final Year year;
  protected final int day;
  protected final String commandKey;
  protected String quizInput;

  protected BaseCommand(String commandKey) {
    this.year = Year.parse(commandKey.substring(0, 2), YEAR_FORMATTER);
    this.day = Integer.parseInt(commandKey.substring(3, 5));
    this.commandKey = commandKey;
  }

  public void Run() throws IOException {
    System.out.printf("Running the solution for year %s day %s%n", year, day);

    quizInput = readQuizInput();
  }

  private String readQuizInput() throws IOException {
    var inputStream = getFileAsIOStream("%s.txt".formatted(commandKey));

    return convertToString(inputStream);
  }

  private InputStream getFileAsIOStream(final String fileName) {
    var ioStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream(fileName);

    if (ioStream != null) {
      return ioStream;
    }
    throw new IllegalArgumentException(fileName + " is not found");
  }

  private String convertToString(InputStream is) throws IOException {
    var writer = new StringWriter();
    IOUtils.copy(is, writer, Charset.defaultCharset());
    return writer.toString();
  }
}
