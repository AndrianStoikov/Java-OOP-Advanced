package P03_DependencyInversion.strategies;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DelenieStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand / secondOperand;
    }
}
