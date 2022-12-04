package dev.lewischan.adventofcode.yeartwentytwo;

import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import dev.lewischan.adventofcode.BaseCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayOne extends BaseCommand {

  public DayOne() {
    super(CommandKeys.DAY_ONE);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_ONE)
  public void Run() throws IOException {
    super.Run();
  }
}
