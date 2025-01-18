package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Ordering;

public class Util {
	
	public static void sleep(long msec, String info) {
		if(info != null) {
			System.out.println("Wait " + msec + "for " + info);
		}
		try {
			Thread.sleep(msec);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void sleep(long msec) {
		sleep(msec, null);
	}
	
	public static int getRandomNumber(int min, int max) {
		int diff = max - min;
		return (int)(min + Math.random() * diff);
	}
	
	public static int getRandomNumber(int number) {
		return getRandomNumber(1,number);
	}
	
	public static String getRandomString(int length) {
		StringBuilder sbuilder =new StringBuilder();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i=0; i<length; i++) {
			int index = (int) (Math.random() * chars.length());
			sbuilder.append(chars.charAt(index));
		}
		return sbuilder.toString();
	}
	
	public static String getRandomString() {
		return getRandomString(10);
	}
	
	public static String getSimpleDateFormat(String format) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formattedDate = formatter.format(date);
		return formattedDate;
	}
	
	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String date = formatter.format(currentDate.getTime()).replace("/", "_");
		date = date.replace(":", "_");
		return date;
	}
	
	public static boolean verifyTextContains(String actualText, String expText) {
		if(actualText.toLowerCase().contains(expText.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public static boolean verifyTextMatch(String actualText, String expText) {
		if(actualText.equals(expText)) {
			return true;
		}
		return false;
	}
	
	public static Boolean verifyListContains(List<String> actList, List<String> expList) {
		int expListSize = expList.size();
		for(int i=0; i<expListSize; i++) {
			if(!actList.contains(expList.get(i))) {
				return false;
			}
		}
		return true;
	}

	/*public Boolean verifyListMatch(List<String> actList, List<String> expList) {
		
	}*/

	public static Boolean verifyItemPresentInList(List<String> actList, String item) {
		int actListSize = actList.size();
		for(int i=0; i<actListSize; i++) {
			if(!actList.contains(item)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isListAscendingOrder(List<Long> list) {
		boolean sorted = Ordering.natural().isOrdered(list);
		return sorted;
	}

}
