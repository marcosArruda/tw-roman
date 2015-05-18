package com.units;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CurrencyMapper{
	private static Map<String , Double> currencyMap;
	private VulcanNumerals vulcanNumeral;
	private RomanNumerals romanNumeral;
	Pattern pattern;
	CurrencyMapper(RomanNumerals romanNumeral, VulcanNumerals vulcanNumeral){
		currencyMap = new HashMap<String, Double>(); 
		this.romanNumeral = romanNumeral;
		this.vulcanNumeral = vulcanNumeral;
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
		String [] vulcanNumbers = m.group(1).split("\\s");
		String currencyName = m.group(2);
		int creditValue = Integer.parseInt(m.group(3));
		// Check if vulcan numerals used are declared first.
		if(!vulcanNumeral.areValid(vulcanNumbers)){
			Util.promptUser("Undeclared Vulcan number was used, input ignored.");
			return;
		}
		String romanNumerals = vulcanNumeral.toRomanNumeral(vulcanNumbers);
		float divisor = romanNumeral.evaluate(romanNumerals);
		double unitValue = creditValue / divisor;
		addCurrency(currencyName, unitValue);
	}
}