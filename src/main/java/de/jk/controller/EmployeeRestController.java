package de.jk.controller;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.jk.model.Employee;
import de.jk.model.UserRepository;
import org.thymeleaf.dialect.AbstractXHTMLEnabledDialect;

@RestController
public class EmployeeRestController {
	private final String s = "https://www.zvg-portal.de/index.php";

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return new Employee("ich ", "test");
	}

	@GetMapping(path = "/sachsen")
	public void getSachsenVerteigerung() throws MalformedURLException, UnsupportedEncodingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		String url = s+"?button=Suchen";
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

				if(trim.replaceAll("(^\\h*)|(\\h*$)","").equalsIgnoreCase("Aktenzeichen")){
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

		String details= s +href;

		Map<String, String> stringStringMap = splitQuery(new URL(details));
		String zvg_id = stringStringMap.get("zvg_id");

		MultiValueMap<String, String> urivars = new LinkedMultiValueMap<String, String>();


		urivars.add("button", "showZvg");
		urivars.add("land_abk", "bw");
		urivars.add("zvg_id", zvg_id);
		HttpHeaders headers2 = new HttpHeaders();

		headers2.set(HttpHeaders.REFERER, s+"?button=Suchen");


		HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<>(urivars, headers2);

		ResponseEntity<String> detailsRersonse = new RestTemplate().getForEntity(s, String.class,request2);
		Document doc = Jsoup.parse(detailsRersonse.getBody());
		doc.select("#anzeige");
	}

	public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String query = url.getQuery();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}
	@PostMapping(path = "/save")
	public String save(@RequestBody Employee data) {
		System.out.println(data.getBirthday());

		Employee save = userRepository.save(data);

		System.out.println("save called " + save);
		return "  data";
	}
	
	@GetMapping(path = "/save")
	public String save() {
	 
		Employee save = userRepository.save(new Employee("test", "sdfsdf"));

		System.out.println("save called " + save);
		return "  data";
	}

	@PostMapping("/employee")
	public Iterable<Employee> getAllEmployees(@RequestBody String data) throws UnknownHostException {
		System.out.println(data);
		return userRepository.findAll();
//		List<Employee> t = new ArrayList<>();
//		try {
//			InetAddress inet = InetAddress.getLocalHost();
//			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
//			String s = "";
//			if (ips != null) {
//				for (int i = 0; i < ips.length; i++) {
//					s += ips[i] + "  ";
//				}
//			}
//			for (int i = 0; i < 400; i++) {
//				t.add(new Employee("ich " + i + "  " + s, i + "test", new Date(), "ii"));
//			}
//		} catch (UnknownHostException e) {
//
//		}
//
//		return t;

	}
}
