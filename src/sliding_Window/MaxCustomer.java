package sliding_Window;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MaxCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int minutes = 3;
		solve(customers,grumpy,minutes);
		//getData();
		
	}
	
	public static int solve(int cus[],int gru[],int k) {
		int s=0;
		for(int i=0;i<cus.length;i++) {
			if(gru[i]!=1) {
				s+=cus[i];
			}
		}
		
		int i=0;
		int j=0;
		int max=0;
		int sum=0;
		while(j<cus.length) {
			sum+=gru[j]==1?cus[j]:0;
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				max=Math.max(max,s+sum);
				sum+=gru[i]==1?-cus[i]:0;
				i++;
				j++;
			}
		}
		return max;
	}
	
	public static void getData() {
        String url = "https://jsonmock.hackerrank.com/api/inventory?barcode="+"74002314"; // Replace with your API endpoint
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			int status=response.statusCode();
			String body=response.body();
			System.out.println(body);
			System.out.println(response);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
