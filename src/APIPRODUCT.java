import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class APIPRODUCT {
    public static void main(String[] args) {

        try {  
        URL url = new URL("https://fakestoreapi.com/products");

        HttpURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responsecode = connection.getResponseCode();
        
        if(responsecode = 200){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ( (line = reader.readLine()) != null){
                response.append(line);
            }

            reader.close();

            System.err.println("Respuesta: "+response.toString());

            connection.disconnect();


        }else{
            throw new RuntimeException("Error al conectarse con la API, vuelve a intentarlo o comprueba tu conexion a internet.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
  } 
}