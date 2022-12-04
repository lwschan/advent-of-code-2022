package dev.lewischan.adventofcode.yeartwentytwo;

import dev.lewischan.adventofcode.BaseCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayOne extends BaseCommand {

  private final ArrayList<Integer> elvesCalories = new ArrayList<>();

  public DayOne() {
    super(CommandKeys.DAY_ONE);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_ONE)
  public void run() throws IOException {
    super.run();

    int currentElfCalories = 0;
    String line;

    try (
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      while ((line = bufferedReader.readLine()) != null) {
        if (!line.isEmpty()) {
          currentElfCalories += Integer.parseInt(line);

          continue;
        }

        elvesCalories.add(currentElfCalories);
        currentElfCalories = 0;
      }

      inputStream.close();
    }

    elvesCalories.sort(Collections.reverseOrder());

    processAnswers();
  }

  @Override
  protected void partOne() {
    var highestCalorieCarried = Collections.max(elvesCalories);

    System.out.printf("The highest calorie carried by one elf is %s.%n", highestCalorieCarried);

  }

  @Override
  protected void partTwo() {
    var sumOfTopThree = elvesCalories.get(0) + elvesCalories.get(1) + elvesCalories.get(2);

    System.out.printf("Total calorie from top 3 elves carrying the most calorie is %s.%n",
        sumOfTopThree);
  }


}
