package com.lafengmaker.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String DATE = "yyyy-MM-dd";
	public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
	private int x;
	private int y;
	private int z;
	private int dayOfWeek;
	private Calendar localTime;
	private int weeks = 0;
	private Date date;

	public DateUtil(String a) {
		if (StringUtil.isEmpty(a)) {
			this.date = new Date();
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.date = format.parse(a);
			} catch (ParseException e) {
				this.date = new Date();
			}
		}
		this.localTime = Calendar.getInstance();
		this.localTime.setTime(this.date);
	}

	public DateUtil() {
		super();
		this.localTime = Calendar.getInstance();
		this.date = new Date();
	}
	public DateUtil(Date date) {
		super();
		this.date = date;
		this.localTime = Calendar.getInstance();
		this.localTime.setTime(date);
	}

	public String today() {
		String strY = null;
		String strZ = null;
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		this.z = this.localTime.get(5);
		if (y < 10) {
			strY = "0" + this.y;
		} else {
			strY = new Integer(this.y).toString();
		}
		if (z < 10) {
			strZ = "0" + this.z;
		} else {
			strZ = new Integer(this.z).toString();
		}
		return this.x + "-" + strY + "-" + strZ;
	}

	public String getCurrDateString() {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		String s = "今天是" + toStirngDate(date, DATE) + "      " + weekDays[w];
		return s;
	}
	public int getMondayPlus() {
		this.dayOfWeek = this.localTime.get(7);
		if (this.dayOfWeek == 1) {
			return -6;
		}
		return 2 - this.dayOfWeek;
	}
	public String thisMonday() {
		this.weeks = 0;
		String strY = null;
		String strZ = null;
		int mondayPlus = getMondayPlus();
		this.localTime.add(5, mondayPlus);
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		this.z = this.localTime.get(5);
		if (y < 10) {
			strY = "0" + this.y;
		} else {
			strY = new Integer(this.y).toString();
		}
		if (z < 10) {
			strZ = "0" + this.z;
		} else {
			strZ = new Integer(this.z).toString();
		}
		return this.x + "-" + strY + "-" + strZ;
	}

	public Date getMonday() {
		return formatStringTodate(thisMonday(), DATE);
	}

	public Date getSunday() {
		return formatStringTodate(thisSunday(), DATE);
	}
	public String thisSunday() {
		int mondayPlus = getMondayPlus();
		String strY = null;
		String strZ = null;
		this.localTime.add(5, mondayPlus + 7 * this.weeks + 6);
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		this.z = this.localTime.get(5);
		if (y < 10) {
			strY = "0" + this.y;
		} else {
			strY = new Integer(this.y).toString();
		}
		if (z < 10) {
			strZ = "0" + this.z;
		} else {
			strZ = new Integer(this.z).toString();
		}
		return this.x + "-" + strY + "-" + strZ;
	}
	public String thisMonth() {
		String strY = null;
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		if (y < 10) {
			strY = "0" + this.y;
		} else {
			strY = new Integer(this.y).toString();
		}
		return this.x + "-" + strY + "-01";
	}
	public String thisMonthEnd() {
		String strY = null;
		String strZ = null;
		boolean leap = false;
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		if ((this.y == 1) || (this.y == 3) || (this.y == 5) || (this.y == 7)
				|| (this.y == 8) || (this.y == 10) || (this.y == 12)) {
			strZ = "31";
		}
		if ((this.y == 4) || (this.y == 6) || (this.y == 9) || (this.y == 11)) {
			strZ = "30";
		}
		if (this.y == 2) {
			leap = leapYear(this.x);
			if (leap)
				strZ = "29";
			else {
				strZ = "28";
			}
		}
		if (y < 10) {
			strY = "0" + this.y;
		} else {
			strY = new Integer(this.y).toString();
		}
		return this.x + "-" + strY + "-" + strZ;
	}
	public String thisSeason() {
		String dateString = "";
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		if ((this.y >= 1) && (this.y <= 3)) {
			dateString = this.x + "-" + "01" + "-" + "01";
		}
		if ((this.y >= 4) && (this.y <= 6)) {
			dateString = this.x + "-" + "04" + "-" + "01";
		}
		if ((this.y >= 7) && (this.y <= 9)) {
			dateString = this.x + "-" + "07" + "-" + "01";
		}
		if ((this.y >= 10) && (this.y <= 12)) {
			dateString = this.x + "-" + "10" + "-" + "01";
		}
		return dateString;
	}
	public String thisSeasonEnd() {
		String dateString = "";
		this.x = this.localTime.get(1);
		this.y = (this.localTime.get(2) + 1);
		if ((this.y >= 1) && (this.y <= 3)) {
			dateString = this.x + "-" + "03" + "-" + "31";
		}
		if ((this.y >= 4) && (this.y <= 6)) {
			dateString = this.x + "-" + "06" + "-" + "30";
		}
		if ((this.y >= 7) && (this.y <= 9)) {
			dateString = this.x + "-" + "09" + "-" + "30";
		}
		if ((this.y >= 10) && (this.y <= 12)) {
			dateString = this.x + "-" + "12" + "-" + "31";
		}
		return dateString;
	}
	public String thisYear() {
		this.x = this.localTime.get(1);
		return this.x + "-01" + "-01";
	}
	public String thisYearEnd() {
		this.x = this.localTime.get(1);
		return this.x + "-12" + "-31";
	}
	public boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else {
				leap = true;
			}
		} else {
			leap = false;
		}
		return leap;
	}
	public static String toStirngDate(Date date, String type) {
		if (null != date) {
			try {
				SimpleDateFormat f = new SimpleDateFormat(type);
				String d = f.format(date);
				return d;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}
	public static String toStirngDate(Timestamp date, String type) {
		if (null != date) {
			try {
				SimpleDateFormat f = new SimpleDateFormat(type);
				String d = f.format(date);
				return d;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}

	public static Date formatStringTodate(String date, String format) {
		try {
			SimpleDateFormat f = new SimpleDateFormat(format);
			if (!StringUtil.isEmpty(date)) {
				return f.parse(date);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * TODO �ַ�ת�����ڸ�ʽ(Timestamp)
	 * 
	 * @param date
	 * @return
	 * @author hanyunchuan
	 * @date 2012-2-15 ����11:16:16
	 */
	public static Timestamp formatStringToTimestamp(String date, String format) {
		try {
			if (!StringUtil.isEmpty(date)) {
				Timestamp ts1 = Timestamp.valueOf(date);
				return ts1;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}


	public static String daysBetweenTwoStr(String proDate, String currDate) {
		SimpleDateFormat format = new SimpleDateFormat(DATE);
		if (proDate == null || "".equals(proDate) || currDate == null
				|| "".equals(currDate)) {
			return "";
		}
		Long days = null;
		try {
			Date d1 = format.parse(proDate);
			Date d2 = format.parse(currDate);
			days = (d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days.toString();
	}
	public static boolean compareDate(Date date) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		java.util.Date Now = new java.util.Date();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(Now);
		rightNow.add(Calendar.DAY_OF_YEAR, -7);// ���ڼӼ�7��
		Date dt = rightNow.getTime();
		Date time1 = null;
		Date time2 = null;
		try {
			time1 = formatter.parse(formatter.format(dt));
			time2 = formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time1.after(time2);
	}
	public static boolean isDateBefore(String date1, String date2) {
		try {
			DateFormat df = DateFormat.getDateInstance();
			return df.parse(date1).before(df.parse(date2));
		} catch (ParseException e) {
			return false;
		}
	}
	public static boolean isDateBefore(String date1, Date date2) {
		return isDateBefore(date1,toStirngDate(date2, DATE));
	}
	public static boolean isDateBefore(Date date1, Date date2) {
		return isDateBefore(toStirngDate(date1, DATE),toStirngDate(date2, DATE));
	}
	public static Timestamp getCurrTimestamp() {
		try {
			java.sql.Timestamp now = new java.sql.Timestamp(
					System.currentTimeMillis());
			return now;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Timestamp addminute(Timestamp t, int minute) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(t);
			cal.add(Calendar.MINUTE, minute);
			return new java.sql.Timestamp(cal.getTimeInMillis());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public Date add(int type,int num){
		localTime.add(type, num);
		return localTime.getTime();
	}
	public  Date getDayFirst(){
		localTime.set(Calendar.HOUR, 0);
		localTime.set(Calendar.MINUTE, 0);
		localTime.set(Calendar.SECOND, 0);
		localTime.set(Calendar.MILLISECOND, 0);
		return localTime.getTime();
	}
	public  Date getDayEnd(){
		localTime.set(Calendar.HOUR_OF_DAY, 23);
		localTime.set(Calendar.MINUTE, 59);
		localTime.set(Calendar.SECOND, 59);
		localTime.set(Calendar.MILLISECOND, 999);
		return localTime.getTime();
	}
	public boolean isdateBetWeen(Date d1,Date d2){
		if(date.before(d2)&&date.after(d1)){
			return true;
		}else{
			return false;
		}
	}
	public boolean submitable(Date d){
		String t1=StringUtil.readProperty("subend", this);
		localTime.setTime(d);
		add(Calendar.DAY_OF_MONTH, -1);
		return setTimeFromstr( t1).after(Calendar.getInstance());
	}
	public boolean changeable(){
		String t2=StringUtil.readProperty("changeend", this);
		return setTimeFromstr( t2).after(Calendar.getInstance());
	}
	private Calendar setTimeFromstr(String str){
		String[] ss=str.split(":");
		int i=Integer.parseInt(ss[0]);
		int j=Integer.parseInt(ss[1]);
		System.out.println(localTime.getTime());
		localTime.set(Calendar.HOUR_OF_DAY, i);
		localTime.set(Calendar.MINUTE, j);
		localTime.set(Calendar.SECOND, 0);
		localTime.set(Calendar.MILLISECOND, 0);
		return localTime;
	}
	public static void main(String[] args) {
		DateUtil test = new DateUtil();
		System.out.println(test.submitable(formatStringTodate("2013-1-28", DATE)));

//		System.out.println(DateUtil.isDateBefore("2013-1-22", "2013-1-22"));
//		System.out.println(DateUtil.isDateBefore("2013-1-23",  new DateUtil().add(Calendar.DAY_OF_MONTH, -2)));
//		System.out.println(test.add(Calendar.DAY_OF_MONTH, 1));
//		System.out.println(toStirngDate(test.getDayFirst(), DATETIME) );
//		System.out.println(test.getDayEnd() );
		// System.out.println("�³�----" + test.thisMonth());
		// System.out.println("��ĩ----" + test.thisMonthEnd());
		// System.out.println("����----" + test.thisSeason());
		// System.out.println("��ĩ----" + test.thisSeasonEnd());
		// System.out.println("���----" + test.thisYear());
		// System.out.println("��ĩ----" + test.thisYearEnd());
		// SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar calendar = Calendar.getInstance();
		// Date dd=new Date();
		// calendar.setTime(dd);
		// System.out.println(DateUtil.compareWeekday(from.format(calendar.getTime())));
	}
}