import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/*
 * @author: Tawfik Yasser
 * @ID: 20180075
 * @G: IS1
 * @Course: SOA
 */
public class A2Class {
	private static final String FILENAME = "C:\\Users\\tawfe\\eclipse-workspace\\A2\\Catalogue_JSON_A2.json";
	public static JSONArray CDsList = new JSONArray();
	public static void main(String[] args) throws SAXException, IOException, JSONException, ParseException {
		// TODO Auto-generated method stub
		// Main menu for the user
		int option = 0;

		System.out.println("------------------------------");
		System.out.println("Welcome to JSON Application");
		System.out.println("1. Add new CD");
		System.out.println("2. Search for a CD");
		System.out.println("3. Get all CDs");
		Scanner oin = new Scanner(System.in);
		option = oin.nextInt();
		switch (option) {
			case 1: {
				add_cd();
				break;
			}
			case 2: {
				search_cd();
				break;
			}
			case 3: {
				get_cds();
				break;
			}
		}
	}

	public static void add_cd() throws SAXException, IOException, JSONException, ParseException {
		// Asking the user to enter the number of CDs
		int noc = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of CDs: ");
		noc = in.nextInt();
		
		Scanner jsonData = new Scanner(System.in);
		JSONObject Catalogue = new JSONObject();
		for (int i = 0; i < noc; i++) {
			JSONObject CD_Data = new JSONObject();
			System.out.println("Adding the element #" + (i + 1));

			System.out.println("Type the Title: ");
			CD_Data.put("Title", jsonData.nextLine());
			System.out.println("Type the Artist: ");
			CD_Data.put("Artist", jsonData.nextLine());
			System.out.println("Type the Country: ");
			CD_Data.put("Country", jsonData.nextLine());
			System.out.println("Type the Company: ");
			CD_Data.put("Company", jsonData.nextLine());
			System.out.println("Type the Price: ");
			CD_Data.put("Price", jsonData.nextLine());
			System.out.println("Type the Year: ");
			CD_Data.put("Year", jsonData.nextLine());
			
			JSONObject eachCD = new JSONObject();
			eachCD.put("CD", CD_Data);
			CDsList.put(eachCD);

		}

		Catalogue.put("Catalogue", CDsList);

		try (FileWriter file = new FileWriter("Catalogue_JSON_A2.json")) {
			file.write(Catalogue.toString());
			file.flush();
			System.out.println("JSON Saved Successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		main(null);
	}

	public static void search_cd() throws SAXException, IOException, JSONException, ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Title of Artist to search for: ");
		String search_query = in.nextLine();

		JSONObject obj;
		try {
			obj = new JSONObject(fileToString(FILENAME));

			JSONArray questionsArray = obj.getJSONArray("Catalogue");

			for (int x = 0; x < questionsArray.length(); x++) {
				JSONObject jsonObject = new JSONObject(questionsArray.get(x).toString());
				JSONObject js = (JSONObject) jsonObject.get("CD");
				if(js.get("Title").toString().equalsIgnoreCase(search_query) || js.get("Artist").toString().equalsIgnoreCase(search_query)) {
					System.out.println(jsonObject.toString(4));
				}
			}
			System.out.println("-----------------");

		} catch (Exception e) {
			System.out.println("Error building JSON");
		}
		
		main(null);
	}

	public static void get_cds() throws SAXException, IOException, JSONException, ParseException {
		JSONObject obj;
		try {
			obj = new JSONObject(fileToString(FILENAME));

			JSONArray questionsArray = obj.getJSONArray("Catalogue");

			for (int x = 0; x < questionsArray.length(); x++) {
				JSONObject jsonObject = new JSONObject(questionsArray.get(x).toString());
				System.out.println(jsonObject.toString(4));
			}
			System.out.println("-----------------");

		} catch (Exception e) {
			System.out.println("Error building JSON");
		}
		main(null);
	}

	private static String fileToString(String fileName) {
		String str = "";
		try {
			InputStream is = new FileInputStream(fileName);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));

			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();

			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}

			String fileAsString = sb.toString();
			return fileAsString;

		} catch (Exception e) {
			System.out.println("Error");
		}

		return str;
	}
}
