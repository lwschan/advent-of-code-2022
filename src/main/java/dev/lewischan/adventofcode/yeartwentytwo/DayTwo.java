package dev.lewischan.adventofcode.yeartwentytwo;

import dev.lewischan.adventofcode.BaseDayCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayTwo extends BaseDayCommand {

  private static final int OPPONENT_MOVE_OFFSET = 'A' - 1;
  private static final int MY_MOVE_OFFSET = 'X' - 1;

  public DayTwo() {
    super(CommandKeys.DAY_TWO);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_TWO)
  public void execute() throws IOException {
    partOne();
    partTwo();
  }

  private int calculateMoveScore(int opponentMove, int myMove) {
    var delta = myMove - opponentMove;

    return switch (delta) {
      case 1, -2 -> 6;
      case 0 -> 3;
      default -> 0;
    };
  }

  private void partOne() throws IOException {
    int grandTotalScore = 0;
    String line;

    try (
        var inputStream = getQuizFileAsIOStream();
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      while ((line = bufferedReader.readLine()) != null) {
        var roundPlays = line.split(" ");
        var opponentMove = roundPlays[0].charAt(0) - OPPONENT_MOVE_OFFSET;
        var myMove = roundPlays[1].charAt(0) - MY_MOVE_OFFSET;

        var roundTotalScore = calculateMoveScore(opponentMove, myMove) + myMove;
        grandTotalScore += roundTotalScore;
      }

      inputStream.close();
    }

    System.out.printf("My total score is %s.%n", grandTotalScore);
  }

  private void partTwo() throws IOException {
    int grandTotalScore = 0;
    String line;

    try (
        var inputStream = getQuizFileAsIOStream();
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      while ((line = bufferedReader.readLine()) != null) {
        var roundPlays = line.split(" ");
        var opponentMove = roundPlays[0].charAt(0) - OPPONENT_MOVE_OFFSET;
        var outcome = roundPlays[1].charAt(0) - MY_MOVE_OFFSET;
      }
    }
  }
}
