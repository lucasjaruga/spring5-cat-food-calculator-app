package pl.jarugalucas.spring5catfoodcalculatorapp.services;

import pl.jarugalucas.spring5catfoodcalculatorapp.model.DryWetCat;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.MixCat;

public interface CatFoodAlgorithmService {

    public Double calculateWetFood(Integer catWeight);
    public Double calculateDryFood(Integer catWeight);
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, Double wetFoodValue);
    public String getDryWetResult(DryWetCat cat);
    public String getMixResult(MixCat cat);
}