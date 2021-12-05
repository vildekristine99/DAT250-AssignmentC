package IoT_device;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import publisher.Helper;

public class Display {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Poll id: ");
		int pollId = Integer.parseInt(in.nextLine());
		in.close();

		try {
			URL url = new URL("http://localhost:8080/polls/" + pollId);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getContentType());

			String content = Helper.getUrlString(connection);

			JSONObject json = new JSONObject(content);
			Integer red = json.getInt("noVotes");
			Integer green = json.getInt("yesVotes");

			System.out.println("Title: " + json.get("title"));
			System.out.println("Description: " + json.get("description"));
			System.out.println("Red votes :\t" + red);
			System.out.println("Green votes:\t" + green);
			
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

	}

}
