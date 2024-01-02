package fr.hermancia.exam.service;

import fr.hermancia.exam.entity.digimon.Digimon;
import fr.hermancia.exam.repository.digimon.DigimonRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DigimonApiService {

    private HttpClientService httpClientService = new HttpClientService();


    private DigimonRepository digimonRepository = new DigimonRepository();


    public Digimon getDigimon() {
        String url = "https://digimon-api.vercel.app/api/digimon" ;
        String json = httpClientService.get(url);
        if (json.isEmpty()) {
            return null;
        }
        try {

            JSONTokener tokener = new JSONTokener(json);
            JSONObject object = new JSONObject(tokener);

            // Obligatoire pour aller dans other
            JSONObject sprites = object.getJSONObject("sprites");
            JSONObject other = sprites.getJSONObject("other");
            JSONObject home = other.getJSONObject("home");

            Digimon digimon = new Digimon();
            digimon.setId(object.getLong("id"));
            digimon.setName(object.getString("name"));
            digimon.setImg(home.getString("img"));
            digimon.setLevel(home.getString("level"));

            return digimonRepository.save(digimon);
        } catch (JSONException e) {
            System.out.println(json);
        }
        return null;
    }

    private String getNameFromJson(JSONObject firstObj, String key) {
        JSONObject secondObj = firstObj.getJSONObject(key);
        return secondObj.getString("name");
    }
        }

