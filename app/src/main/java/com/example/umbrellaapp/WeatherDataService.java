package com.example.umbrellaapp;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_FORECAST1 = "https://api.weatherapi.com/v1/forecast.json?key=ffec2e24bb534dbf8b1154255231807&q=";
    public static final String QUERY_FOR_CITY_FORECAST2 = "&days=3&aqi=no&alerts=no";

    Context context;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{

        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherReportModels);
    }
    public void getCityForecastByName(String cityName, VolleyResponseListener volleyResponseListener){

        List<WeatherReportModel> weatherReportModels = new ArrayList<>();
        String url = QUERY_FOR_CITY_FORECAST1 + cityName + QUERY_FOR_CITY_FORECAST2;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    for(int i = 0; i < 3; i++){

                        WeatherReportModel oneDay = new WeatherReportModel();

                        if(i == 0){
                            JSONObject location = response.getJSONObject("location");
                            oneDay.setLocationName(location.getString("name"));

                            JSONObject current = response.getJSONObject("current");
                            oneDay.setCurrentTempC(current.getLong("temp_c"));
                        }
                        JSONObject forecast = response.getJSONObject("forecast");
                        JSONArray forecastday = forecast.getJSONArray("forecastday");

                        JSONObject forecastdayObject = forecastday.getJSONObject(i);
                        oneDay.setDate(forecastdayObject.getString("date"));

                        JSONObject day = forecastdayObject.getJSONObject("day");
                        oneDay.setForecastMaxTempC(day.getLong("maxtemp_c"));
                        oneDay.setForecastMinTempC(day.getLong("mintemp_c"));
                        if(oneDay.getForecastMaxTempC() > 20){
                            oneDay.setClothes("Only summer clothes!");
                        }
                        else if(oneDay.getForecastMaxTempC() > 10 && oneDay.getForecastMaxTempC() <=20){
                            oneDay.setClothes("Some hoodie may be useful");
                        }
                        else oneDay.setClothes("Brrrr!");

                        oneDay.setChanceOfRain(day.getInt("daily_chance_of_rain"));

                        if(oneDay.getChanceOfRain() > 50){
                            oneDay.setUmbrella("Better take!");
                        }
                        else if(oneDay.getChanceOfRain() <= 50 && oneDay.getChanceOfRain() > 35){
                            oneDay.setUmbrella("May be useful");
                        }
                        else oneDay.setUmbrella("Don't worry, it won't rain");

                        JSONObject condition = day.getJSONObject("condition");
                        oneDay.setCondition(condition.getString("text"));

                        weatherReportModels.add(oneDay);
                    }

                    volleyResponseListener.onResponse(weatherReportModels);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Something wrong");
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

    }
}
