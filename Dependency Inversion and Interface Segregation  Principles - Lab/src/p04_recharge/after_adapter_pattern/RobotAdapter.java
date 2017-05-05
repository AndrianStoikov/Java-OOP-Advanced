package p04_recharge.after_adapter_pattern;

public class RobotAdapter implements Rechargeable {

    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    public void recharge() {
        this.robot.setCurrentPower(this.robot.getCapacity());
    }
}
