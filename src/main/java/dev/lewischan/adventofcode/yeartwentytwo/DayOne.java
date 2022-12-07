package dev.lewischan.adventofcode.yeartwentytwo;

import dev.lewischan.adventofcode.BaseDayCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayOne extends BaseDayCommand {

  public DayOne() {
    super(CommandKeys.DAY_ONE);
  }

  @ShellMethod(key = CommandKeys.DAY_ONE)
  public void execute() throws IOException {
    var elvesCalories = new ArrayList<Integer>();

    try (
        var inputStream = getQuizFileAsIOStream();
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      int currentElfCalories = 0;
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        if (!line.isEmpty()) {
          currentElfCalories += Integer.parseInt(line);

          continue;
        }

        elvesCalories.add(currentElfCalories);
        currentElfCalories = 0;
      }
    }

    elvesCalories.sort(Collections.reverseOrder());

    partOne(elvesCalories);
    partTwo(elvesCalories);
  }

  private void partOne(ArrayList<Integer> elvesCalories) {
    var highestCalorieCarried = Collections.max(elvesCalories);

    System.out.printf("The highest calorie carried by one elf is %s.%n", highestCalorieCarried);
  }

  private void partTwo(ArrayList<Integer> elvesCalories) {
    var sumOfTopThree = elvesCalories.get(0) + elvesCalories.get(1) + elvesCalories.get(2);

    System.out.printf("Total calorie from top 3 elves carrying the most calorie is %s.%n",
        sumOfTopThree);
  }
}
