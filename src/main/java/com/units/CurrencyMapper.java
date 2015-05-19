package com.units;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CurrencyMapper{
	private static Map<String , Double> currencyMap;
	private AlienNumerals alienNumeral;
	private RomanNumerals romanNumeral;
	Pattern pattern;
	CurrencyMapper(RomanNumerals romanNumeral, AlienNumerals alienNumeral){
		currencyMap = new HashMap<String, Double>(); 
		this.romanNumeral = romanNumeral;
		this.alienNumeral = alienNumeral;
	}
	public void addCurrency(String name, double value)
	{
		currencyMap.put(name, value);
	}
	public double getUnitValue(String currencyName)
	{
		return currencyMap.get(currencyName);
	}
	public void processCreditInfo(String line){
		String regex = Global.regexCreditsInfo;
		pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(line);
		m.matches();
		String [] alienNumbers = m.group(1).split("\\s");
		String currencyName = m.group(2);
		int creditValue = Integer.parseInt(m.group(3));
		// Check if alien numerals used are declared first.
		if(!alienNumeral.areValid(alienNumbers)){
			Util.promptUser("Undeclared Alien number was used, input ignored.");
			return;
		}
		String romanNumerals = alienNumeral.toRomanNumeral(alienNumbers);
		float divisor = romanNumeral.evaluate(romanNumerals);
		double unitValue = creditValue / divisor;
		addCurrency(currencyName, unitValue);
	}
}