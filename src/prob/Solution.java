package prob;

import java.util.ArrayList;
import java.util.List;
//还不知道怎么存储
public class Solution {
    //    本质是一个序列；
    public int numOfSolution;
    public int numOfCars;
    public List<List<Car>> cars;
    public double[][] sequence;

    public Solution(Instance instance) {
        this.numOfCars = instance.cars.size();
    }

    public void setSol(List<Individual> Population) {
        this.numOfSolution = Population.size();
        this.numOfCars = Population.get(0).cars.size();
        this.cars = new ArrayList<>();
        this.sequence = new double[numOfSolution][numOfCars + 4];
//        转化为数组对吗
        for (int i = 0; i < numOfSolution; i++) {
            this.cars.set(i, Population.get(i).cars);
        }
        for (int i = 0; i < numOfSolution; i++) {
            for (int j = 0; j < numOfCars; j++) {
                sequence[i][j] = cars.get(numOfSolution).get(numOfCars).carNo;

            }
            sequence[i][numOfCars] = Population.get(i).objectives[0];
            sequence[i][numOfCars + 1] = Population.get(i).objectives[1];
            sequence[i][numOfCars + 2] = Population.get(i).objectives[2];
            sequence[i][numOfCars + 3] = Population.get(i).objectives[3];
        }
    }

    public boolean isFeasible(Solution solution) {
        for (int i = 0; i < solution.numOfSolution; i++) {
            Individual individual = new Individual(solution.cars.get(i));
            if (!individual.isFeasible()) {
                return false;
            }
        }
        return true;
    }

}
