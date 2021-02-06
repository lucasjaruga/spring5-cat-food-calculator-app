package pl.jarugalucas.spring5catfoodcalculatorapp.model;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    private Integer weight;
    private String typeOfFood;
    private Integer wetFoodValue;
    private Integer noMeals;

    public Cat() {

    }

    public Cat(Integer weight, String typeOfFood, Integer noMeals) {
        this.weight = weight;
        this.typeOfFood = typeOfFood;
        this.noMeals = noMeals;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public Integer getWetFoodValue() {
        return wetFoodValue;
    }

    public void setWetFoodValue(Integer wetFoodValue) {
        this.wetFoodValue = wetFoodValue;
    }

    public Integer getNoMeals() {
        return noMeals;
    }

    public void setNoMeals(Integer noMeals) {
        this.noMeals = noMeals;
    }
}