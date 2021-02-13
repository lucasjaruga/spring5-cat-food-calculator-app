package pl.jarugalucas.spring5catfoodcalculatorapp.model;

public class Cat {

    private Integer weight;
    private String typeOfFood;
    private Integer wetFoodValue;
    private Integer noMeals;

    public Cat() {
        System.out.println("Cat class: inside default controller.");
    }

    // constructor for dry/wet food calculation
    public Cat(Integer weight, String typeOfFood, Integer noMeals) {
        this.weight = weight;
        this.typeOfFood = typeOfFood;
        this.noMeals = noMeals;
    }

    // constructor for mix food calculation
    public Cat(Integer weight, Integer wetFoodValue, Integer noMeals) {
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