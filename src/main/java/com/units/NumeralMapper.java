package com.units;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class NumeralMapper{
	private RomanNumerals romanNumerals;
	private AlienNumerals alienNumerals;
	private static Map<String, String> mappings;

	protected NumeralMapper(RomanNumerals romanNumerals, AlienNumerals alienNumerals){
		mappings = new HashMap<String, String>();
		this.romanNumerals = romanNumerals;
		this.alienNumerals = alienNumerals;
		alienNumerals.storeNumeralMapper(this);
	}

	public String convertToRomanNumeral(String[] vNumeral){
		// pish tegj glob globkey
		StringBuilder romanNumeral = new StringBuilder(vNumeral.length);
		for(String s : vNumeral){
			romanNumeral.append(mappings.get(s));
		}
		return romanNumeral.toString();
	}

	public void addToMap(String vNumeral, String rNumeral){
		if( mappings.containsKey(vNumeral) || getKeyByValue(rNumeral) !=null){
			Util.promptUser("Mapping already done.");
		}else{
			if(alienNumerals.isWord(vNumeral)){
				//add to list of know alien numerals
				alienNumerals.addNumeral(vNumeral);
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
