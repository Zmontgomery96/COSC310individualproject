
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.select.Elements;

//for using the search API
//https://www.wikipedia.org/w/api.php?action=opensearch&format=json&search="

//for getting the json data
//https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=
public interface WikiAPI {
    String temp = "";
    String[] inputArray = new String[100];

    public static String doAThing(){
        return "sup";
    }

    public static String doAThing(String something){
                //for requesting the json
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.wikipedia.org/w/api.php?action=opensearch&format=json&search=" + something))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
                
                //we get the body/json 
                //need to parse the json somehow
                
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			//currently returning the whole HTML elements of it and no json
            inputArray[1] = response.body();
            // temp = response.body();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			inputArray[0] = "Error in code. Caught exception.";
			return inputArray[1];
		}
    return inputArray[1];
    }


}
