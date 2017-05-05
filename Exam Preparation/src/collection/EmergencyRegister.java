package collection;


import models.emergencies.BaseEmergency;

public class EmergencyRegister implements RegisterCollection {
    private static final Integer INITIAL_SIZE = 16;

    private BaseEmergency[] emergencyQueue;
    private Integer currentSize;
    private Integer nextIndex;

    public EmergencyRegister() {
        this.emergencyQueue = new BaseEmergency[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if (this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        BaseEmergency[] newArray = new BaseEmergency[2 * this.currentSize];

        System.arraycopy(this.emergencyQueue, 0, newArray, 0, this.currentSize);

        this.emergencyQueue = newArray;
    }

    @Override
    public void enqueueEmergency(BaseEmergency emergency) {
        this.checkIfResizeNeeded();
        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();
        this.incrementCurrentSize();
    }

    @Override
    public BaseEmergency dequeueEmergency() {
        BaseEmergency removedElement = this.emergencyQueue[0];

        System.arraycopy(this.emergencyQueue, 2, this.emergencyQueue, 1, this.currentSize - 2);

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    @Override
    public BaseEmergency peekEmergency() {
        return this.emergencyQueue[0];
    }

    @Override
    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public int size() {
        return this.currentSize;
    }
}
