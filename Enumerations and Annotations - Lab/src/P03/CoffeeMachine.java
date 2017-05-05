package P03;

import P03.Enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffeeSold;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeeSold = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(type, size);
        if(this.moneyIsEnough(coffee)) {
            coffeeSold.add(coffee);
            this.coins.clear();
        }
    }

    private boolean moneyIsEnough(Coffee coffee) {
        int sumOfCoins = 0;
        for (Coin coin : this.coins) {
            sumOfCoins += coin.getValue();
        }

        return sumOfCoins > coffee.getPrice();
    }

    public void insertCoin(String coin) {
        Coin coinType = Coin.valueOf(coin);
        this.coins.add(coinType);
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeeSold;
    }
}
