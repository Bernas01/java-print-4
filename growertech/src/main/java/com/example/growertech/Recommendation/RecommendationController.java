package com.example.growertech.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.growertech.User.AppUser;
import com.example.growertech.User.UserRepository;
import com.example.growertech.dto.RecommendationDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/index")
    public Map<String, String> recommend(@RequestBody RecommendationDTO dto, Authentication authentication) {
        Map<String, String> response = new HashMap<>();

        try {
            AppUser user = userRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            RecommendationDTO recommendation = recommendationService.generateRecommendation(
                    dto.getSoilType(),
                    dto.getAverageTemperature(),
                    user
            );

            response.put("soilRecommendation", recommendation.getSoilRecommendation());
            response.put("fertilizerRecommendation", recommendation.getFertilizerRecommendation());
        } catch (Exception e) {
            response.put("error", "Erro ao processar a recomendação: " + e.getMessage());
        }

        return response;
    }
}
