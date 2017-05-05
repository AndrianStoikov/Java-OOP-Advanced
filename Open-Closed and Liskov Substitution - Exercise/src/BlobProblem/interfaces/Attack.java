package BlobProblem.interfaces;

import BlobProblem.models.Blob;

public interface Attack {
    void attack(Blob Attacker, Blob toAttack) throws NoSuchFieldException, IllegalAccessException;
}
