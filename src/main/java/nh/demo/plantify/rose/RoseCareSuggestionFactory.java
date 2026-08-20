package nh.demo.plantify.rose;

import nh.demo.plantify.care.suggestion.CareSuggestion;
import nh.demo.plantify.care.suggestion.CareSuggestionFactory;
import nh.demo.plantify.plant.PlantType;
import org.springframework.stereotype.Component;

import java.util.List;

// Package private, keine öffentliche Komponente
@Component
class RoseCareSuggestionFactory implements CareSuggestionFactory {

    RoseCareSuggestionFactory() {
    }

    @Override
    public List<CareSuggestion> createSuggestion(PlantType plantType, String location) {
        return List.of();
    }
}
