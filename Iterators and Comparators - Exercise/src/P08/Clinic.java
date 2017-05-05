package P08;

/**
 * Created by Andrian on 24.3.2017 г..
 */
public interface Clinic {

    boolean addPet(Pet p);

    boolean hasEmptyRooms();

    String print();

    String print(int indexRoom);

    boolean release();
}
