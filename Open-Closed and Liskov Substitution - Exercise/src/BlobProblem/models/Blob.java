package BlobProblem.models;

import BlobProblem.interfaces.Attack;
import BlobProblem.interfaces.Behaviour;

public class Blob {
    private String name;
    private int health;
    private int initalHealth;
    private int initialDamage;
    private int currentDamage;
    private Behaviour behaviour;
    private Attack attack;
    private boolean behaviourIsActivated;
    private int damage;

    public Blob(String name, int health, int damage, Behaviour behaviour, Attack attack) {
        this.name = name;
        this.setHealth(health);
        this.setDamage(damage);
        this.behaviour = behaviour;
        this.attack = attack;
        this.behaviourIsActivated = true;
    }

    private void setHealth(int health) {
        this.health = health;
        this.initalHealth = health;
    }

    private void setDamage(int damage) {
        this.initialDamage = damage;
        this.currentDamage = damage;
    }

    public void nextTurn() {
        if(this.behaviourIsActivated)
            behaviour.continueOneMoreTurn(this);
    }

    public void attackBlob(Blob blob) throws NoSuchFieldException, IllegalAccessException {
        this.attack.attack(this, blob);
    }
}
