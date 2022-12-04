package dev.lewischan.adventofcode.yeartwentytwo;

import dev.lewischan.adventofcode.BaseCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayTwo extends BaseCommand {

  public DayTwo() {
    super(CommandKeys.DAY_TWO);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_TWO)
  public void run() throws IOException {
    super.run();

    int currentScore = 0;
    String line;

    try (
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      while ((line = bufferedReader.readLine()) != null) {
        var roundPlays = line.split(" ");
        var opponentPlay = roundPlays[0];
        var myPlay = roundPlays[1];

        System.out.println(line);
        System.out.println(opponentPlay);
        System.out.println(myPlay);
      }

      inputStream.close();
    }

    processAnswers();
  }

  @Override
  protected void partOne() {

  }

  @Override
  protected void partTwo() {

  }
}
