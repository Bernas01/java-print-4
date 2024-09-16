package com.example.growertech.Recommendation;

import com.example.growertech.User.*;
import com.example.growertech.dto.RecommendationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class RecommendationService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    @Autowired
    private RecommendationRepository recommendationRepository;

    public RecommendationDTO generateRecommendation(String soilType, int averageTemperature, AppUser user) {
        String soilRecommendation;
        String fertilizerRecommendation;

        // Defina recomendações com base no tipo de solo
        switch (soilType) {
            case "Argiloso":
                soilRecommendation = "Use fertilizantes ricos em potássio para melhorar a fertilidade do solo.";
                break;
            case "Arenoso":
                soilRecommendation = "Adicione matéria orgânica ao solo para aumentar sua capacidade de retenção de água.";
                break;
            case "Aluvial":
                soilRecommendation = "Considere o uso de fertilizantes de liberação controlada para fornecer nutrientes de forma gradual.";
                break;
            case "Pedregoso":
                soilRecommendation = "Realize uma análise de solo para determinar a viabilidade de culturas adequadas para esse tipo de solo.";
                break;
            case "Silte":
                soilRecommendation = "Aplique calcário para corrigir a acidez do solo e melhorar a qualidade do solo.";
                break;
            case "Orgânico":
                soilRecommendation = "Utilize adubos orgânicos para enriquecer o solo com nutrientes naturais.";
                break;
            default:
                soilRecommendation = "Recomende-se o Solo Humifero para seu plantio.";
        }

        // Definição da recomendação de fertilizantes com base na temperatura
        if (averageTemperature < 10) {
            fertilizerRecommendation = "Prefira fertilizantes com liberação lenta de nutrientes para garantir uma nutrição adequada em temperaturas mais baixas.";
        } else if (averageTemperature >= 10 && averageTemperature < 25) {
            fertilizerRecommendation = "Escolha fertilizantes balanceados que atendam às necessidades específicas das plantas.";
        } else if (averageTemperature >= 25 && averageTemperature < 30) {
            fertilizerRecommendation = "Utilize fertilizantes balanceados que atendam às necessidades específicas das plantas.";
        } else {
            fertilizerRecommendation = "Utilize fertilizantes com maior teor de nitrogênio para estimular o crescimento das plantas.";
        }

        // Crie e salve a recomendação
        Recommendation recommendation = Recommendation.builder()
                .soilType(soilType)
                .averageTemperature(averageTemperature)
                .soilRecommendation(soilRecommendation)
                .fertilizerRecommendation(fertilizerRecommendation)
                .user(user)
                .build();

        // Salve a recomendação no repositório
        recommendationRepository.save(recommendation);

        // Crie o DTO para retornar
        RecommendationDTO recommendationDTO = new RecommendationDTO(
                soilType,
                averageTemperature,
                soilRecommendation,
                fertilizerRecommendation
        );

        logger.info("Generated recommendation: {}", recommendationDTO);

        return recommendationDTO;
    }
}
