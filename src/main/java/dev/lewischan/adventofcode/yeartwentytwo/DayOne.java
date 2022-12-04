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

  public DayOne() {
    super(CommandKeys.DAY_ONE);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_ONE)
  public void run() throws IOException {
    super.run();

    var ioStream = getQuizFileAsIOStream();
    var topThreeElvesCalories = new ArrayList<Integer>();
    topThreeElvesCalories.add(0);
    topThreeElvesCalories.add(0);
    topThreeElvesCalories.add(0);

    try (
        var inputStreamReader = new InputStreamReader(ioStream);
        var bufferedReader = new BufferedReader(inputStreamReader)
    ) {
      String line;
      int currentElfCalorie = 0;

      while ((line = bufferedReader.readLine()) != null) {
        if (!line.isEmpty()) {
          currentElfCalorie += Integer.parseInt(line);

          continue;
        }

        var leastCalorieCarriedInTopThree = Collections.min(topThreeElvesCalories);

        if (currentElfCalorie > leastCalorieCarriedInTopThree) {
          topThreeElvesCalories.set(
              topThreeElvesCalories.indexOf(leastCalorieCarriedInTopThree),
              currentElfCalorie);
        }

        currentElfCalorie = 0;
      }

      ioStream.close();

      System.out.printf("The highest calorie carried by one elf is %s.%n",
          Collections.max(topThreeElvesCalories));

      var topThreeTotal = 0;
      for (var calorie : topThreeElvesCalories) {
        topThreeTotal += calorie;
      }

      System.out.printf("Total calorie from top 3 elves carrying the most calorie is %s.%n",
          topThreeTotal);
    }
  }
}
