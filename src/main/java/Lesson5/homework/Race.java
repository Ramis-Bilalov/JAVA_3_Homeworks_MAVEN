package Lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Race {
    private ArrayList<Stage> stages;
    private static volatile Car winner;

    public ArrayList<Stage> getStages() {
        return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}