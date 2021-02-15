package pl.jarugalucas.spring5catfoodcalculatorapp.model;

public class Cat {

    private Integer weight;
    private String typeOfFood;
    private Double wetFoodValue;
    private Integer noMeals;
    private String result;

    public Cat() {
    }

    // constructor for dry/wet food calculation
    public Cat(Integer weight, String typeOfFood, Integer noMeals) {
        this.weight = weight;
        this.typeOfFood = typeOfFood;
        this.noMeals = noMeals;
    }

    // constructor for mix food calculation
    public Cat(Integer weight, Double wetFoodValue, Integer noMeals) {
        this.weight = weight;
        this.noMeals = noMeals;
        this.wetFoodValue = wetFoodValue;
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

    public Double getWetFoodValue() {
        return wetFoodValue;
    }

    public void setWetFoodValue(Double wetFoodValue) {
        this.wetFoodValue = wetFoodValue;
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
                ", typeOfFood='" + typeOfFood + '\'' +
                ", wetFoodValue=" + wetFoodValue +
                ", noMeals=" + noMeals +
                '}';
    }
}