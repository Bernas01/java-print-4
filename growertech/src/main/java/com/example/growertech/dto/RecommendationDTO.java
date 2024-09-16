package com.example.growertech.dto;

public class RecommendationDTO {
    private String soilType;
    private int averageTemperature;
    private String soilRecommendation;
    private String fertilizerRecommendation;

    // Construtor, getters e setters
    public RecommendationDTO(String soilType, int averageTemperature, String soilRecommendation, String fertilizerRecommendation) {
        this.soilType = soilType;
        this.averageTemperature = averageTemperature;
        this.soilRecommendation = soilRecommendation;
        this.fertilizerRecommendation = fertilizerRecommendation;
    }

    // Getters e Setters
    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getSoilRecommendation() {
        return soilRecommendation;
    }

    public void setSoilRecommendation(String soilRecommendation) {
        this.soilRecommendation = soilRecommendation;
    }

    public String getFertilizerRecommendation() {
        return fertilizerRecommendation;
    }

    public void setFertilizerRecommendation(String fertilizerRecommendation) {
        this.fertilizerRecommendation = fertilizerRecommendation;
    }
}
