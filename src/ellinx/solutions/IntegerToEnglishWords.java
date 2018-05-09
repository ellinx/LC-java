package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * For example, 
 * 
 * 123 -> "One Hundred Twenty Three" 
 * 12345 -> "Twelve Thousand Three Hundred Forty Five" 
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 *
 */
public class IntegerToEnglishWords {
	public String numberToWords(int num) {
		StringBuilder sb = new StringBuilder();
        List<Integer> parts = new ArrayList<>();//at most four parts
        if (num==0) {
        	return "Zero";
        }
        while (num>0) {
        	int part = num%1000;
        	num /= 1000;
        	parts.add(part);
        }
        for (int i=0;i<parts.size();i++) {
        	String word = threeDigitNumToWords(parts.get(i));
        	switch(i) {
        		case 0:
        			if (!word.equals("Zero")) {
        				sb.append(word);
        			}
        			break;
        		case 1:
        			if (!word.equals("Zero")) {
        				if (sb.length()==0) {
        					sb.insert(0, word+" Thousand");
        				} else {
        					sb.insert(0, word+" Thousand ");
        				}
        			}
        			break;
        		case 2:
        			if (!word.equals("Zero")) {
        				if (sb.length()==0) {
        					sb.insert(0, word+" Million");
        				} else {
        					sb.insert(0, word+" Million ");
        				}
        			}
        			break;
        		case 3:
        			if (!word.equals("Zero")) {
        				if (sb.length()==0) {
        					sb.insert(0, word+" Billion");
        				} else {
        					sb.insert(0, word+" Billion ");
        				}
        			}
        			break;
        		default:
        			System.out.println("Error, it's not divided to four parts");
        			break;
        	}
        }
        return sb.toString();
    }
	
	//help function which only convert at most 3 digits number
	private String threeDigitNumToWords(int num) {
		StringBuilder sb = new StringBuilder();
		if (num>=100) {
			switch(num/100) {
				case 1:
					sb.append("One Hundred");
					break;
				case 2:
					sb.append("Two Hundred");
					break;
				case 3:
					sb.append("Three Hundred");
					break;
				case 4:
					sb.append("Four Hundred");
					break;
				case 5:
					sb.append("Five Hundred");
					break;
				case 6:
					sb.append("Six Hundred");
					break;
				case 7:
					sb.append("Seven Hundred");
					break;
				case 8:
					sb.append("Eight Hundred");
					break;
				case 9:
					sb.append("Nine Hundred");
					break;
				default:
					System.out.println("threeDigitNumToWords:: hundred digit not correct");
					break;
			}
			String rest = threeDigitNumToWords(num%100);
			if (!rest.equals("Zero")) {
				sb.append(" ").append(rest);
			}
			return sb.toString();
		}
		
		if (num>=0 && num<=20) {
			switch (num) {
				case 0:
					sb.append("Zero");
					break;
				case 1:
					sb.append("One");
					break;
				case 2:
					sb.append("Two");
					break;
				case 3:
					sb.append("Three");
					break;
				case 4:
					sb.append("Four");
					break;
				case 5:
					sb.append("Five");
					break;
				case 6:
					sb.append("Six");
					break;
				case 7:
					sb.append("Seven");
					break;
				case 8:
					sb.append("Eight");
					break;
				case 9:
					sb.append("Nine");
					break;
				case 10:
					sb.append("Ten");
					break;
				case 11:
					sb.append("Eleven");
					break;
				case 12:
					sb.append("Twelve");
					break;
				case 13:
					sb.append("Thirteen");
					break;
				case 14:
					sb.append("Fourteen");
					break;
				case 15:
					sb.append("Fifteen");
					break;
				case 16:
					sb.append("Sixteen");
					break;
				case 17:
					sb.append("Seventeen");
					break;
				case 18:
					sb.append("Eighteen");
					break;
				case 19:
					sb.append("Nineteen");
					break;
				case 20:
					sb.append("Twenty");
					break;
				default:
					System.out.println("number is without range 0-20");
					break;
			} 
		} else if (num>20 && num<30) {
			sb.append("Twenty ").append(threeDigitNumToWords(num%10));
		} else if (num>30 && num<40) {
			sb.append("Thirty ").append(threeDigitNumToWords(num%10));
		} else if (num>40 && num<50) {
			sb.append("Forty ").append(threeDigitNumToWords(num%10));
		} else if (num>50 && num<60) {
			sb.append("Fifty ").append(threeDigitNumToWords(num%10));
		} else if (num>60 && num<70) {
			sb.append("Sixty ").append(threeDigitNumToWords(num%10));
		} else if (num>70 && num<80) {
			sb.append("Seventy ").append(threeDigitNumToWords(num%10));
		} else if (num>80 && num<90) {
			sb.append("Eighty ").append(threeDigitNumToWords(num%10));
		} else if (num>90 && num<100) {
			sb.append("Ninety ").append(threeDigitNumToWords(num%10));
		} else {
			switch(num) {
				case 30:
					sb.append("Thirty");
					break;
				case 40:
					sb.append("Forty");
					break;
				case 50:
					sb.append("Fifty");
					break;
				case 60:
					sb.append("Sixty");
					break;
				case 70:
					sb.append("Seventy");
					break;
				case 80:
					sb.append("Eighty");
					break;
				case 90:
					sb.append("Ninety");
					break;
			}
		}
		return sb.toString();
	}
	
	//test
	public static void main(String[] args) {
		IntegerToEnglishWords tmp = new IntegerToEnglishWords();
		String result = tmp.numberToWords(1000);
		System.out.println(result);
	}
}
