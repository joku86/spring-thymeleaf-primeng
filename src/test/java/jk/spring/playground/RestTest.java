package jk.spring.playground;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import de.jk.config.model.CountryCourts;
import de.jk.config.model.CountryCourts.CountryAbbreviation;

public class RestTest {
	private static Map<Integer, String> tra = new HashMap<Integer, String>() {
		{
			put(1, "sdf");
		}
	};
	

	@Test
	public void testName() throws Exception {
 
		
		 try {

	            File file = new File(this.getClass().getClassLoader().getResource("zvg-portal-gerichte.txt").getFile());
	            JAXBContext jaxbContext = JAXBContext.newInstance(CountryCourts.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            CountryCourts configs = (CountryCourts) jaxbUnmarshaller.unmarshal(file);
	            for(CountryAbbreviation album :configs.country_abbreviations){
	                System.out.println("getUrl : "+album.name  );
	            }

	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		//RestTest.tra.put(1, "neuer wert");
		//System.out.println(RestTest.tra.get(1));
		// getSachsenVerteigerung();
	}

	private final String s = "https://www.zvg-portal.de/index.php";

	public void getSachsenVerteigerung() throws MalformedURLException, UnsupportedEncodingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		String url = s + "?button=Suchen";
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("ger_id", "B1806");
		map.add("ger_name", "Wolfach");
		map.add("land_abk", "bw");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		Document doc = Jsoup.parse(response.getBody());
		String title = doc.title();
		String body = doc.body().text();
		System.out.println(doc.select("table").size());
		Elements select = doc.select("table");
		for (Element row : doc.select("table").get(0).select("tr")) {

			Elements tds = row.select("td");
			System.out.println(tds.size());
			if (tds.size() >= 2) {
				String label = tds.get(0).text();
				System.out.println(label);

				String trim = label.trim();

				if (trim.replaceAll("(^\\h*)|(\\h*$)", "").equalsIgnoreCase("Aktenzeichen")) {
					Element element = tds.get(1);

					System.out.println(element);
					String href = element.children().get(0).children().get(0).attributes().get("href");

					getDetailsPage(href);
				}
				System.out.println(tds.get(1).text());
			}

		}
		System.out.println(doc.body().childNodeSize());
	}

	private void getDetailsPage(String href) throws UnsupportedEncodingException, MalformedURLException {

		String details = s + href;

		Map<String, String> stringStringMap = splitQuery(new URL(details));
		String zvg_id = stringStringMap.get("zvg_id");

		HttpHeaders headers2 = new HttpHeaders();

		headers2.set(HttpHeaders.REFERER, s + "?button=Suchen");

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(s).queryParam("button", "showZvg")
				.queryParam("land_abk", "bw").queryParam("zvg_id", zvg_id)

		;

		HttpEntity<?> entity = new HttpEntity<>(headers2);

		HttpEntity<String> response = new RestTemplate().exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		System.out.println("---------" + response);
	}

	public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		String query = url.getQuery();
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
					URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		}
		return query_pairs;
	}

}
