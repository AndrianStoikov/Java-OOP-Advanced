package P03_DependencyInversion.strategies;

public class SubtractionStrategy implements Strategy{
    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
