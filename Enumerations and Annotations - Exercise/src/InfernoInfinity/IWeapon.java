package InfernoInfinity;

import InfernoInfinity.Gems.Socket;

public interface IWeapon<T> extends Comparable<T>{
    void addGem(int index, Socket type);

    void removeGem(int index);
}
