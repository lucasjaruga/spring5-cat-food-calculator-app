package pl.jarugalucas.spring5catfoodcalculatorapp.services;

public interface AlgorithmService {

    public Double calculateWetFood(Integer catWeight);
    public Double calculateDryFood(Integer catWeight);

    // TODO uncomment after fixing a method inside AlgorithmServiceImpl.class
    // public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, JTextField wetFoodText);
}