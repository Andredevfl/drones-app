package com.droneapp.model;

public class Drone {
    private String name;
    private String imagePath;
    private String shortDescription;
    private String detailedDescription;

    private double weight;  // Peso do drone
    private int maxAltitude;  // Altura máxima (em metros)
    private int maxSpeed;  // Velocidade máxima (em km/h)
    private double rechargeTime;  // Tempo de recarga (em horas)

    public Drone(String name, String imagePath, String shortDescription, String detailedDescription) {
        this.name = name;
        this.imagePath = imagePath;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

      public double getWeight() {
        return weight;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getRechargeTime() {
        return rechargeTime;
    }

    public String getDescription() {
        return getDescription();
    }
}