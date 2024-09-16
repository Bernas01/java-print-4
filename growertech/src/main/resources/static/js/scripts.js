function getRecommendation({ soilType, averageTemperature}){
    let soilRecommendation = "";
    let fertilizerRecommendation = "";

    switch (soilType) {
        case "Argiloso"&& "argiloso":
            soilRecommendation = "Use fertilizantes ricos em potássio para melhorar a fertilidade do solo.";
            break;
        case "Arenoso"&& "arenoso":
            soilRecommendation = "Adicione matéria orgânica ao solo para aumentar sua capacidade de retenção de água.";
            break;
        case"Aluvial"&& "aluvial":
            soilRecommendation = "Considere o uso de fertilizantes de liberação controlada para fornecer nutrientes de forma gradual.";
            break;
        case "Pedregoso"&& "pedregoso":
            soilRecommendation = "Realize uma análise de solo para determinar a viabilidade de culturas adequadas para esse tipo de solo.";
            break;
        case "Silte"&& "silte":
            soilRecommendation = "Aplique calcário para corrigir a acidez do solo e melhorar a qualidade do solo.";
            break;
        case "Organico"&& "organico":
            soilRecommendation = "Utilize adubos orgânicos para enriquecer o solo com nutrientes naturais.";
            break;
        default:
            soilRecommendation = "Recomende-se o Solo Humifero para seu plantio.";
    }

    // Calcula a recomendação de fertilizante
    if (averageTemperature < 10) {
        fertilizerRecommendation = "Prefira fertilizantes com liberação lenta de nutrientes para garantir uma nutrição adequada em temperaturas mais baixas.";
    } else if (averageTemperature >= 10 && averageTemperature < 25) {
        fertilizerRecommendation = "Escolha fertilizantes balanceados que atendam às necessidades específicas das plantas.";
    } else if (averageTemperature >= 25 && averageTemperature < 30) {
        fertilizerRecommendation = "Utilize fertilizantes balanceados que atendam às necessidades específicas das plantas.";
    } else {
        fertilizerRecommendation = "Utilize fertilizantes com maior teor de nitrogênio para estimular o crescimento das plantas.";
    }
    
    return { soilRecommendation, fertilizerRecommendation };
}


document.getElementById("recommendation-form").addEventListener("submit", function(event) {
    event.preventDefault();

    // Captura os valores do formulário
    const soilType = document.getElementById("solo").value;
    const fertilizer = document.getElementById("fertilizante").value;
    const temperature = document.getElementById("temperatura").value;
    const product = document.getElementById("planta").value;

    const data = {
        soilType: soilType,
        averageTemperature: parseInt(temperature, 10),
    };

    const recommendation = getRecommendation(data)

    // Exibe a recomendação
    document.getElementById("user-inputs").innerHTML = `
        <p><strong>Solo:</strong> ${soilType}</p>
        <p><strong>Fertilizante:</strong> ${fertilizer}</p>
        <p><strong>Temperatura Média:</strong> ${temperature}°C</p>
        <p><strong>Plantação:</strong> ${product}</p>
    `;

    document.getElementById("recommendation").innerHTML = `
            <p><strong>Recomendação de Solo:</strong> ${recommendation.soilRecommendation}</p>
            <p><strong>Recomendação de Fertilizante:</strong> ${recommendation.fertilizerRecommendation}</p>
        `;

    // Mostra a seção de resultados
    document.getElementById("result-section").classList.remove("hidden");

    
});
