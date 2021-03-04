package pl.jarugalucas.spring5catfoodcalculatorapp.services;

import org.springframework.stereotype.Service;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.DryWetCat;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.MixCat;

@Service
public class CatFoodAlgorithmServiceImpl implements CatFoodAlgorithmService {

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
    @Override
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, Double wetFoodValue){

        double dailyNeeds = wetFoodValue / wetResult;
        Double percentOfDryFood = 1.0 - dailyNeeds;

        return dryResult * percentOfDryFood;
    }

    /**
     * Method to provide final result for user about wet or dry food
     *
     * @param cat - a DryWetCat object which stores all necessary values for calculations
     * @return a String which represents the final dry or wet food result for user, based on Cat's fields
     */
    @Override
    public String getDryWetResult(DryWetCat cat){

        int noMeals = cat.getNoMeals();

        if(cat.getTypeOfFood().equals("dry")){
            Double dryValue = calculateDryFood(cat.getWeight());
            return Math.round(dryValue / noMeals) + " g dry food per meal.";
        } else {
            Double wetValue = calculateWetFood(cat.getWeight());
            return Math.round(wetValue / noMeals) + " g wet food per meal.";
        }
    }

    /**
     * Method to provide final result for user about mix food
     *
     * @param cat - a MixCat object which stores all necessary values for calculations
     * @return a String which represents the final mix food result for user, based on Cat's fields
     */
    @Override
    public String getMixResult(MixCat cat){

        int noMeals = cat.getNoMeals();
        Double wetFoodValue = cat.getWetFoodValue();

        Double dryValue = calculatePercentOfDryFood(calculateWetFood(cat.getWeight()),
                                                    calculateDryFood(cat.getWeight()),
                                                    wetFoodValue);

        if(cat.getMaxWetFood() != null) {
            return Math.round(wetFoodValue / noMeals) + " g wet food. No need to give your cat a dry food. Would be too much.";
        } else {
            return Math.round(wetFoodValue / noMeals) + " g wet food and " + Math.round(dryValue / noMeals) + " g dry food per meal.";
        }
    }

    /**
     * This is support method to validate if user don't want to give a cat too much food while calculating mix food.
     *
     * @param cat - a MixCat object which stores all necessary values for calculations
     * @return a boolean value - true if user want to give too much wet food
     */
    @Override
    public boolean checkIfNotTooMuchWet(MixCat cat) {

        double maxWet = calculateWetFood(cat.getWeight());

        if(maxWet < cat.getWetFoodValue()){
            cat.setMaxWetFood("Max value: " + Math.floor(maxWet));
            return true;
        } else {
            return false;
        }
    }
}