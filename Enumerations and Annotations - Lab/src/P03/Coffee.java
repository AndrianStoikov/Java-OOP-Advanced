package P03;

import P03.Enums.CoffeeSize;
import P03.Enums.CoffeeType;

public class Coffee {
    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(String type, String size) {
        this.type = CoffeeType.valueOf(type.toUpperCase());
        this.size = CoffeeSize.valueOf(size.toUpperCase());
    }

    public int getPrice() {
        return this.size.getPrice();
    }
}
