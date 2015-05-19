package com.units;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AlienNumerals {
	private static List<String> alienNumerals;
	private NumeralMapper nMapper;

	public AlienNumerals(){
		alienNumerals = new ArrayList<String>();
	}

	public void storeNumeralMapper(NumeralMapper nMapper){
		this.nMapper = nMapper;
	}

	public String toRomanNumeral(String [] numeral)
	{
		 return nMapper.convertToRomanNumeral(numeral);
	}

	public void addNumeral(String numeral){
		if(isWord(numeral)){
			alienNumerals.add(numeral);
		}
		else{
			Util.promptUser("Inncorrect Alien Numeral");
		}
	}
	private boolean isValid(String numeral){
		for(String item : alienNumerals){
			if ( numeral.equals(item)){
				return true;
			}
		}
		return false;
	}
	public boolean areValid(String [] numeral){
		for (String s : numeral){
			if(!isValid(s)){
				Util.promptUser(s +" is not a Alien Numeral.");
				return false;
			}
		}
		return true;
	}
	public boolean isWord(String numeral){
		String wordRegex ="^[a-z]+";
		Matcher matcher;
		Pattern wordPattern = Pattern.compile(wordRegex);
		matcher = wordPattern.matcher(numeral);
		return (matcher.matches()? true: false);
	}
}