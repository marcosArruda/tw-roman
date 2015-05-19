package com.units;

public class Global
{
	//REGEXPss..
	static String regexAssignment = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
	static String regexCreditsInfo = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
	static String regexHowMany= "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
	static String regexHowMuch = "^how much is ((?:\\w+[^0-9] )+)\\?$";

	public static enum LineType{
		ASSIGNMENT,
		CREDITSINFO,
		QUESTION_HOW_MANY,
		QUESTION_HOW_MUCH
	}
}
