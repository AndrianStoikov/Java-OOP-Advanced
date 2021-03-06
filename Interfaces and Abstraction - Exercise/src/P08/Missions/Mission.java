package P08.Missions;

public class Mission implements IMission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (state.equals("Finished") || state.equals("inProgress")) {
            this.state = state;
            return;
        }
        throw new IllegalArgumentException("Invallid state passed");
    }

    @Override
    public void CompleteMission() {
        this.state = "Finished";
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
