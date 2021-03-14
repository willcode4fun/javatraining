package com.valtech.talent.program.patterns;

import com.valtech.talent.program.patterns.model.Dinosaur;

public class ServiceSample {

    public interface DinosaurFeedingService {
        void feed(Dinosaur dinosaur);
    }

    public class DinosaurFeedingServiceImpl implements DinosaurFeedingService {

        private MeatProviderService meatProviderService;

        private VegetablesProviderService vegetablesProviderService;


        @Override
        public void feed(Dinosaur dinosaur) {
            int ration = calculerRation(dinosaur);
            switch(dinosaur.getDiet()){
                case HERBIVORE:
                    vegetablesProviderService.getFood(ration);
                    break;
                case CARNIVORE:
                    meatProviderService.getFood(ration);
                    break;

                default: throw new UnsupportedOperationException();

            }
        }

        private int calculerRation(Dinosaur dinosaur) {
            return 100;
        }
    }

}
