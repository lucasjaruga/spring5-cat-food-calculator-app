package pl.jarugalucas.spring5catfoodcalculatorapp.model;

public class DryWetCat extends Cat {

    private String typeOfFood;

    public DryWetCat() {
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @Override
    public String toString() {
        return "DryWetCat {" +
                "weight=" + super.getWeight() +
                ", typeOfFood='" + typeOfFood + '\'' +
                ", noMeals=" + super.getNoMeals() +
                " result= " + super.getResult() +
                '}';
    }
}