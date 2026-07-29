import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

class Main{
    static void main() throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome da comida que queira saber a receita: ");
        var buscar = leitura.next();

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + buscar;
                ;
//https://www.themealdb.com/api/json/v1/1/search.php?s=noodle
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse <String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}