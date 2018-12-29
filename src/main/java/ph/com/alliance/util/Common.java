package ph.com.alliance.util;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;

public class Common {
		
	public static Logger error = Logger.getLogger("error"); //see log4j.xml for configuration
	
	public static String getSystemDate() {
		return (new Timestamp(System.currentTimeMillis())).toString();
	}
	public static boolean isNullOrEmpty(String pstrTarget) {
		if (null != pstrTarget && !Constant.EMPTY_STRING.equals(pstrTarget.trim())) {
			if (Constant.NULL_STRING.equalsIgnoreCase(pstrTarget.trim())) {
				return true;
			}
			return false;
		} else {
			return true;
		}
	}
	public static boolean isListNullOrEmpty(List<?> targetList) {		
		return null == targetList || targetList.isEmpty();
	}
}
