package pl.jarugalucas.spring5catfoodcalculatorapp.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MixCat extends Cat{

    @NotNull(message="is required")
    @Min(value = 1, message="must be >= 1")
    private Double wetFoodValue;
    private String maxWetFood;

    public MixCat() {
    }

    public Double getWetFoodValue() {
        return wetFoodValue;
    }

    public void setWetFoodValue(Double wetFoodValue) {
        this.wetFoodValue = wetFoodValue;
    }

    public String getMaxWetFood() {
        return maxWetFood;
    }

    public void setMaxWetFood(String maxWetFood) {
        this.maxWetFood = maxWetFood;
    }

    @Override
    public String toString() {
        return "MixCat {" +
                "weight=" + super.getWeight() +
                ", wetFoodValue=" + wetFoodValue +
                ", noMeals=" + super.getNoMeals() +
                " result= " + super.getResult() +
                '}';
    }
}