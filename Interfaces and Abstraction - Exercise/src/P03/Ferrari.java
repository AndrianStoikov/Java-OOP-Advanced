package P03;

/**
 * Created by Andrian on 16.3.2017 г..
 */
public class Ferrari implements Car {
    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.model = "488-Spider";
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.useBrakes(), this.pushGas(), this.driver);
    }
}
