import com.gtranslate.Audio;
//import com.gtranslate.Language;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class testApi {
    public void tts(String text, String lang) throws Exception {
        if(!text.isEmpty()) {
            Audio audio = Audio.getInstance();
            String s = text + "&client=tw-ob";
            InputStream sound = audio.getAudio(s, lang);
            audio.play(sound);
        }
        else {
            System.out.println("Error!");
        }
    }
    public String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbw97l60W57olrWvFEGA1bd-WUdKJjm_2IzUHqUJro1VlKzHkKc/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
