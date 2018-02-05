package fr.ahkrin.ahk.twitchs;

import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Stream {

    private HashMap<String, Object> stream = new HashMap<String, Object>();
    private HashMap<String, Object> channel = new HashMap<String, Object>();

    private String clientId;
    private String targetName;

    public Stream(String clientId, String target){
        this.clientId = clientId;
        this.targetName = target;
        getJson();
    }

    public HashMap getStream(){
        return stream;
    }

    private void getJson(){
        String link = "https://api.twitch.tv/kraken/streams/" + targetName + "?client_id=" + clientId;
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            JSONObject jsonObject = new JSONObject(result);
            get(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void get(JSONObject obj){
        if(obj.get("stream") instanceof JSONObject){
            stream.put("online", true);
        }else{
            stream.put("online", false);
        }
    }

}
