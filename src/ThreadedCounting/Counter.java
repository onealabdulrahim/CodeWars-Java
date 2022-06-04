package ThreadedCounting;

import java.util.ArrayList;

public class Counter {
    public ArrayList<Integer> values = new ArrayList<>();

    public Counter() {}

    public Counter(ArrayList<Integer> values) {
        this.values = values;
    }

    public void count(int num) {
        this.values.add(num);
    }
}