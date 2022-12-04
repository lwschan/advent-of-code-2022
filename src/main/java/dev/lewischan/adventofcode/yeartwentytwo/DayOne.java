package dev.lewischan.adventofcode.yeartwentytwo;

import dev.lewischan.adventofcode.BaseCommand;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DayOne extends BaseCommand {
  public DayOne() {
    super(CommandKeys.DAY_ONE);
  }

  @Override
  @ShellMethod(key = CommandKeys.DAY_ONE)
  public void Run() {
    super.Run();
  }
}
