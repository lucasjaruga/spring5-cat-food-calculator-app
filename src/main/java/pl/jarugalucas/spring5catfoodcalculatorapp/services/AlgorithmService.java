package pl.jarugalucas.spring5catfoodcalculatorapp.services;

public interface AlgorithmService {

    public Double calculateWetFood(Integer catWeight);
    public Double calculateDryFood(Integer catWeight);
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, Double wetFoodValue);
}