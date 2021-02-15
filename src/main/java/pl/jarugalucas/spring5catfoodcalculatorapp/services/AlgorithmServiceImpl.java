package pl.jarugalucas.spring5catfoodcalculatorapp.services;

import org.springframework.stereotype.Service;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

    private final Integer minCatWeight = 2000;

    /**
     * Method to calculate wet food based on catWeight
     *
     * @param catWeight - an Integer value which represents cat's weight in grams
     * @return a Double value which represents amount of wet food for cat per day
     */
    @Override
    public Double calculateWetFood(Integer catWeight){

        int baseAmountOfWet = 150;
        double wetFoodMultiplier = 0.025;
        int weightDifference = catWeight - minCatWeight;
        double amountToAdd = weightDifference * wetFoodMultiplier;

        return baseAmountOfWet + amountToAdd;
    }

    /**
     * Method to calculate dry food based on catWeight and noMeals
     *
     * @param catWeight - an Integer value which represents cat's weight in grams
     * @return a Double value which represents amount of dry food for cat per day
     */
    @Override
    public Double calculateDryFood(Integer catWeight){

        int baseAmountOfDry = 40;
        double dryFoodMultiplier = 0.01;
        int weightDifference = catWeight - minCatWeight;
        double amountToAdd = weightDifference * dryFoodMultiplier;

        return baseAmountOfDry + amountToAdd;
    }

    /**
     * Method to calculate how much a dry food should get a cat based on amount of a wet food which user want to give a cat
     *
     * @param wetResult - a Double value which represents how much wet food should get cat if it only get wet food
     * @param dryResult  - a Double value which represents how much dry food should get cat if it only get dry food
     * @param wetFoodValue - a JTextField object which stores String user input value of how much wet food owner wants to give to a cat
     * @return a Double which represents amount of dry food to give a cat per day
     */
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, Double wetFoodValue){

        double dailyNeeds = wetFoodValue / wetResult;
        Double percentOfDryFood = 1.0 - dailyNeeds;

        return dryResult * percentOfDryFood;
    }
}