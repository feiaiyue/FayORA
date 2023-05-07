package prob;

import java.util.List;

public class Instance implements Comparable<Instance>{
    public String instName;
    public List<Car> cars;

    public Instance(Data data) {
        this.instName = data.instName;
        this.cars = data.cars;
    }
    @Override
    public int compareTo(Instance other) {
        return this.cars.size() - other.cars.size();
    }
}
