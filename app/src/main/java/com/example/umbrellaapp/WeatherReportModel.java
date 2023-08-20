package com.example.umbrellaapp;

public class WeatherReportModel {

    private int id;
    private String locationName;
    private float currentTempC;
    private String condition;
    private String date;
    private int chanceOfRain;
    private float forecastMaxTempC;
    private float forecastMinTempC;
    private String umbrella;
    private String clothes;


    public WeatherReportModel() {
    }

    public WeatherReportModel(int id, String locationName, float currentTempC, String condition, String date, float forecastMaxTempC, float forecastMinTempC) {
        this.id = id;
        this.locationName = locationName;
        this.currentTempC = currentTempC;
        this.condition = condition;
        this.date = date;
        this.forecastMaxTempC = forecastMaxTempC;
        this.forecastMinTempC = forecastMinTempC;
    }

    @Override
    public String toString() {

        if(locationName != null){

            return "Location = " + locationName +
                    "\nCurrent TempC = " + currentTempC +
                    "\nDate = " + date +
                    "\nCondition = " + condition+
                    "\nMax TempC = " + forecastMaxTempC +
                    "\nMin TempC = " + forecastMinTempC +
                    "\nChance of rain = " + chanceOfRain + "%" +
                    "\nUmbrella: " + umbrella +
                    "\nClothes: " + clothes;
        }
        else return "Date = " + date +
                "\nCondition = " + condition+
                "\nMax TempC = " + forecastMaxTempC +
                "\nMin TempC = " + forecastMinTempC +
                "\nChance of rain = " + chanceOfRain + "%" +
                "\nUmbrella: " + umbrella +
                "\nClothes: " + clothes;
    }

    public String getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(String umbrella) {
        this.umbrella = umbrella;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(int chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCurrentTempC() {
        return currentTempC;
    }

    public void setCurrentTempC(float currentTempC) {
        this.currentTempC = currentTempC;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getForecastMaxTempC() {
        return forecastMaxTempC;
    }

    public void setForecastMaxTempC(float forecastMaxTempC) {
        this.forecastMaxTempC = forecastMaxTempC;
    }

    public float getForecastMinTempC() {
        return forecastMinTempC;
    }

    public void setForecastMinTempC(float forecastMinTempC) {
        this.forecastMinTempC = forecastMinTempC;
    }
}
