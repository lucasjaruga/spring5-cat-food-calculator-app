package pl.jarugalucas.spring5catfoodcalculatorapp.services;

import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

public interface AlgorithmService {

    public Double calculateWetFood(Integer catWeight);
    public Double calculateDryFood(Integer catWeight);
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, Double wetFoodValue);
    public String getDryWetResult(Cat cat);
    public String getMixResult(Cat cat);
}