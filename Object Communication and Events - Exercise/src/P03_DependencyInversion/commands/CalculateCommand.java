package P03_DependencyInversion.commands;

import P03_DependencyInversion.PrimitiveCalculator;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class CalculateCommand implements Command {

    private String[] data;
    private PrimitiveCalculator calculator;

    public CalculateCommand(String[] data, PrimitiveCalculator calculator) {
        this.data = data;
        this.calculator = calculator;
    }

    @Override
    public String execute() {
        Integer a = Integer.parseInt(data[0]);
        Integer b = Integer.parseInt(data[1]);
        return calculator.performCalculation(a, b) + "\r\n";
    }
}
