package de.jk.config.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "countryCourts")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryCourts {
	@XmlElement(name = "country_abbreviations")
	public List<CountryAbbreviation> country_abbreviations = new ArrayList<>();

	@XmlRootElement(name = "countryCourts")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class CountryAbbreviation {
		@XmlAttribute
		public String name;

	}
}
