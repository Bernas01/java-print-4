CREATE TABLE IF NOT EXISTS recommendations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    soilType VARCHAR(255),
    fertilizer VARCHAR(255),
    product VARCHAR(255),  -- Adicionado
    averageTemperature INTEGER,  -- Corrigido para averageTemperature
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);