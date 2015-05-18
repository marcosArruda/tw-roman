package com.units;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class NumeralMapper{
	private RomanNumerals romanNumerals;
	private VulcanNumerals vulcanNumerals;
	private static Map<String, String> mappings;

	protected NumeralMapper(RomanNumerals romanNumerals, VulcanNumerals vulcanNumerals){
		mappings = new HashMap<String, String>();
		this.romanNumerals = romanNumerals;
		this.vulcanNumerals = vulcanNumerals;
		vulcanNumerals.storeNumeralMapper(this);
	}
	public String convertToRomanNumeral(String[] vNumeral){
		// pish tegj glob globkey
		StringBuilder romanNumeral = new StringBuilder(vNumeral.length);
		for(String s : vNumeral){
			romanNumeral.append(mappings.get(s));
		}
		return romanNumeral.toString();
	}
	public String convertToVulcanNumeral(String rNumeral)
	{
		return new String();
	}
	public void addToMap(String vNumeral, String rNumeral){
		if( mappings.containsKey(vNumeral) || getKeyByValue(rNumeral) !=null){
			Util.promptUser("Mapping is already present.");
		}else{
			if(vulcanNumerals.isWord(vNumeral)){
				//add to list of know vulcan numerals
				vulcanNumerals.addNumeral(vNumeral);
				mappings.put(vNumeral, rNumeral);
			}else{Util.promptUser("Incorrect assignment.");}
		}
	}
	private String getKeyByValue(String value) {
	    for (Entry<String, String> entry : mappings.entrySet()){
	        if (value.equals((String)(entry.getValue()))){
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}
