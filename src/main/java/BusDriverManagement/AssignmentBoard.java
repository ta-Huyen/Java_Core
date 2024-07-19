package BusDriverManagement;

import java.util.HashMap;
import java.util.Map;

public class AssignmentBoard {
    private final BusDriver driver;
    private final BusLines line;
    private int turns;

    public AssignmentBoard(BusDriver driver, BusLines line, int turns) {
        this.driver = driver;
        this.line = line;
        this.turns = turns;
    }

    public double getDrivingDistance() {
        return (line.getDistance() * turns);
    }

    public BusDriver getDriver() {
        return driver;
    }

    public BusLines getLine() {
        return line;
    }

    public void setTurns(int turns) {
        this.turns += turns;
    }

    public int getTurns() {
        return turns;
    }

    public String saveData() {
        return driver.getLxId() + " - " + line.getLineId() + " - " + turns;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Phan cong cua lai ze " + driver.getName() + ":");
        result.append("\n\tTuyen xe " + line.getLineId() + " - " + turns + " luot");

        return result.toString();
    }

}
