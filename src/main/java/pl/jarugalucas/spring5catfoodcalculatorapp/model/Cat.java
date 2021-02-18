package pl.jarugalucas.spring5catfoodcalculatorapp.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Cat {

    @NotNull(message="is required")
    @Min(value = 2000, message="must be >= 2 000")
    @Max(value = 25000, message="must be <= 25 000")
    private Integer weight;

    @NotNull(message="is required")
    @Min(value = 1, message="must be >= 1")
    @Max(value = 8, message="must be <= 8")
    private Integer noMeals;

    private String result;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getNoMeals() {
        return noMeals;
    }

    public void setNoMeals(Integer noMeals) {
        this.noMeals = noMeals;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", noMeals=" + noMeals +
                ", result='" + result + '\'' +
                '}';
    }
}