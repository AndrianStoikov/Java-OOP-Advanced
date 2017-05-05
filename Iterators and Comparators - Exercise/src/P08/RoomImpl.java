package P08;

public class RoomImpl implements Room {

    private Pet pet;
    private boolean isEmpty;

    public RoomImpl() {
        this.isEmpty = true;
    }

    @Override
    public void addPet(Pet p) {
        this.pet = p;
        this.isEmpty = false;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public void release() {
        this.pet = null;
        this.isEmpty = true;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Room empty";
        } else {
            return this.pet.toString();
        }
    }
}
