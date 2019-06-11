package com.pcitc.base.util;

/**
 * add by msw
 * 自增工具类
 */
public class AutoNumberUtils {
	/**
	 * 以“000001”开头的自增
	 */
	public static String getSixNumber(int num) {
		num++;
		String result = "";
		switch ((num + "").length()) {
		case 1:
			result = "00000" + num;
			break;
		case 2:
			result = "0000" + num;
			break;
		case 3:
			result = "000" + num;
			break;
		case 4:
			result = "00" + num;
			break;
		case 5:
			result = "0" + num;
			break;
			// 此处代表编号已经超过了999999，从0重新开始
		default:
			result = "0000000";
			break;
		}
		return result;
	}
	
	public static String getThreesNumber(int num) {
		num++;
		String result = "";
		switch ((num + "").length()) {
		case 1:
			result = "00" + num;
			break;
		case 2:
			result = "0" + num;
			break;
		case 3:
			result = ""+ num;
		default:
			result = "0000";
			break;
		}
		return result;
	}
	
	/**两位自增
	 * 
	 * @param num
	 * @return
	 */
	public static String getTwoNumber(int num) {
		num++;
		String result = "";
		switch ((num + "").length()) {
		case 1:
			result = "0" + num;
			break;
		case 2:
			result = "" + num;
			break;
		default:
			result = "000";
			break;
		}
		return result;
	}

	
	public static String getFiveNumber(int num) {
		num++;
		String result = "";
		switch ((num + "").length()) {

		case 1:
			result = "0000" + num;
			break;
		case 2:
			result = "000" + num;
			break;
		case 3:
			result = "00" + num;
			break;
		case 4:
			result = "0" + num;
			break;
			// 此处代表编号已经超过了99999，从0重新开始
		default:
			result = "000000";
			break;
		}
		return result;
	}
}
