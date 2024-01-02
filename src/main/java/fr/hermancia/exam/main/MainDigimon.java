package fr.hermancia.exam.main;

import fr.hermancia.exam.service.DigimonApiService;
import fr.hermancia.exam.service.Dump;
import fr.hermancia.exam.service.HttpClientService;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static fr.hermancia.exam.service.Dump.*;

public class MainDigimon {

    public static void main(String[] args) {
        DigimonApiService das = new DigimonApiService();

        das.getDigimon();

    }

    private static void testApiPost() {
        HttpClientService hcs = new HttpClientService();

        // On peut créer un JSON valide depuis un objet Map, via le JSONObject
        Map<String, Object> json = new HashMap<>();
        json.put("name", "herminou");
        json.put("img", "herminou.jpeg");
        json.put("level", "training");

        JSONObject o = new JSONObject(json);

//        Dump.dump(hcs.post("https://steam-ish.test-02.drosalys.net/api/account", o.toString()));

    }

}

