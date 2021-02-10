package pl.jarugalucas.spring5catfoodcalculatorapp.services;

import org.springframework.stereotype.Service;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Algorithm;
import pl.jarugalucas.spring5catfoodcalculatorapp.model.Cat;

@Service
public class CatServiceImpl implements CatService {

    private final Algorithm algorithm;

    public CatServiceImpl(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public Cat getCat() {
        return new Cat();
    }
}