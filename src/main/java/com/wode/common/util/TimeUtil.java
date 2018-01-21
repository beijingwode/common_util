package com.wode.common.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * User: fdxu Date: 12-8-22
 */
public class TimeUtil {

	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getIntTimeSpan(String startTime, String endTime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(startTime);
			Date date = df.parse(endTime);
            boolean iszhengshu = true;
			long l = date.getTime() - now.getTime();
            if(l<0){
                l = Math.abs(l);
                iszhengshu = false;
            }
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}

			long ret = day * 24 * 3600 + hour * 3600 + min * 60 + s;
            if(!iszhengshu)
                ret = -ret;
            return ret;

		} catch (Exception ex) {
			return 0;
		}
	}

    /**
     * 获取两个时间差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getIntTimeSpan(Date startTime, Date endTime) {
        try {
            Date now = startTime;//df.parse(startTime);
            Date date = endTime;//df.parse(endTime);
            boolean iszhengshu = true;
            long l = date.getTime() - now.getTime();
            if(l<0){
                l = Math.abs(l);
                iszhengshu = false;
            }
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            if (hour < 0) {
                hour = 0;
            }
            if (min < 0) {
                min = 0;
            }
            if (s < 0) {
                s = 0;
            }
            if (day < 0) {
                day = 0;
            }

            long ret = day * 24 * 3600 + hour * 3600 + min * 60 + s;
            if(!iszhengshu)
                ret = -ret;
            return ret;

        } catch (Exception ex) {
            return 0;
        }
    }
	


	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimeSpan2(String startTime, String endTime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(startTime);
			Date date = df.parse(endTime);
			long l = date.getTime() - now.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}
			String h = String.valueOf(hour);
			if (hour < 10) {
				h = "0" + hour;
			}
			String m = String.valueOf(min);
			if (min < 10) {
				m = "0" + min;
			}
			return h + ":" + m;
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimeSpan3(String startTime, String endTime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(startTime);
			Date date = df.parse(endTime);
			long l = date.getTime() - now.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}

			min = hour * 60 + min;
			String m = String.valueOf(min);
			if (min < 10) {
				m = "0" + min;
			}
			String ss = String.valueOf(s);
			if (s < 0) {
				ss = "0" + s;
			}
			return m + "分" + ss + "秒";
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String compareTime(Date startTime, Date endTime) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = null;
		long l = endTime.getTime() - startTime.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		if (day > 0) {
			str = df.format(startTime);
		} else if (hour > 0) {
			str = hour + "小时前";
		} else if (min > 0) {
			str = min + "分钟前";
		} else {
			str = "刚刚";
		}
		return str;
	}
	
	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long compareTimeToLong(Date startTime, Date endTime) {
		return endTime.getTime()-startTime.getTime();
	}
	
	/**
	 * 2个时间的小时差
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long hourBetweenTime(Date startTime, Date endTime) {
		long l = endTime.getTime() - startTime.getTime();
		
		long hour = l / (60 * 60 * 1000);
		
		return hour;
	}
	

	/**
	 * 获取两个时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimeSpan(String startTime, String endTime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(startTime);
			Date date = df.parse(endTime);
			long l = date.getTime() - now.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}
			if (day > 0) {
				return day * 24 + hour + "小时" + min + "分" + s + "秒";
			} else {
				return hour + "小时" + min + "分" + s + "秒";
			}

		} catch (Exception ex) {
			return "";
		}
	}

	public static String getTimeSpan1(String startTime, String endTime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(startTime);
			Date date = df.parse(endTime);
			long l = date.getTime() - now.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}
			if (day > 0) {
				return day * 24 + hour + "小时" + min + "分";
			} else {
				return hour + "小时" + min + "分";
			}

		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 转换对象为INT
	 * 
	 * @param s
	 *            对象
	 * @return 如果为空则返回-1
	 */
	public static int null2Int(Object s) {
		return null2Int(s, -1);
	}

	/**
	 * 转换日期字符串为'yyyy-MM-dd'
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date) {
		return dateToStr(date,"yyyy-MM-dd");
	}
	
	/**
	 * 转换日期字符串为'yyyy-MM-dd'
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStr19(Date date) {
		return dateToStr(date,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		if(!StringUtils.isEmpty(date) && !StringUtils.isEmpty(format)){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;
	}

	/**
	 * 转换日期字符串为'yyyy-MM-dd'
	 * 
	 * @param DateStr
	 * @return
	 */ 
	public static String strToDate2(String DateStr) {
		SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// formatYMD表示的是yyyy-MM-dd格式
		SimpleDateFormat formatD = new SimpleDateFormat("MM月dd日  HH:mm:ss");// "E"表示"day in week"
		Date d = null;
		String weekDay = "";
		try {
			d = formatYMD.parse(DateStr);// 将String 转换为符合格式的日期
			weekDay = formatD.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weekDay;
	}

	public static String strToDate3(String DateStr) {
		SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// formatYMD表示的是yyyy-MM-dd格式
		SimpleDateFormat formatD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// "E"表示"day in week"
		Date d = null;
		String weekDay = "";
		try {
			d = formatYMD.parse(DateStr);// 将String 转换为符合格式的日期
			weekDay = formatD.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weekDay;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 
	 * 获取现在时间
	 * 
	 * 
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */

	public static String getStringDateShort() {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = formatter.format(currentTime);

		return dateString;

	}

	/**
	 * 
	 * 获取一个月的最后一天
	 * 
	 * 
	 * 
	 * @param dat
	 * 
	 * @return
	 */

	public static String getEndDateOfMonth(String dat) {

		String str = dat.substring(0, 8);

		String month = dat.substring(5, 7);

		int mon = Integer.parseInt(month);

		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {

			str += "31";

		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {

			str += "30";

		} else {

			if (isLeapYear(dat)) {

				str += "29";

			} else {

				str += "28";

			}

		}

		return str;

	}

    public static int getDaysOfMonth(String dat) {
        int str = 0;
        String month = dat.substring(5, 7);
        int mon = Integer.parseInt(month);
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
            str = 31;
        } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            str = 30;
        } else {
            if (isLeapYear(dat+" 00:00:00")) {
                str = 29;
            } else {
                str = 28;
            }
        }
        return str;
    }

	/**
	 * 
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * 
	 * 
	 * @param strDate
	 * 
	 * @return
	 */

	public static Date strToDate(String strDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(strDate!=null && strDate.length()<13) {
			 formatter = new SimpleDateFormat("yyyy-MM-dd");
		}

		ParsePosition pos = new ParsePosition(0);

		Date strtodate = formatter.parse(strDate, pos);

		return strtodate;

	}

	/**
	 * 
	 * 将时间格式字符串转换为特定格式的字符串
	 * 
	 * @param strDate
	 * 
	 * @return
	 */

	public static String formatDateTime(String strDate, String format) {

		try {
			Date date = strToDate(strDate);
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);

		} catch (Exception ex) {
			return strDate;
		}

	}

	/**
	 * 
	 * 判断是否润年
	 * 
	 * 
	 * 
	 * @param ddate
	 * 
	 * @return
	 */

	public static boolean isLeapYear(String ddate) {

		/**
		 * 
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 
		 * 3.能被4整除同时能被100整除则不是闰年
		 */

		Date d = strToDate(ddate);

		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();

		gc.setTime(d);

		int year = gc.get(Calendar.YEAR);

		if ((year % 400) == 0)

			return true;

		else if ((year % 4) == 0) {

			if ((year % 100) == 0)

				return false;

			else

				return true;

		} else

			return false;

	}

	/**
	 * 转换对象为INT
	 * 
	 * @param object
	 *            对象
	 * @param def
	 *            失败默认值
	 * @return INT值
	 */
	public static int null2Int(Object object, int def) {

		if (object != null) {
			try {
				return Integer.parseInt(object.toString());
			} catch (Exception e) {
			}
		}
		return def;
	}

	public static double div(double v1, double v2, int scale) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 上月第一天
	 * 
	 * @return
	 */
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	public static String getCurrentMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 0);// 减一个月，变为下月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	public static String getCurrentMonthFirst1() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 0);// 减一个月，变为下月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

    /**
     *  给日期加上天数（计算几天之后的时间）
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     *  给日期加上月（计算几天之后的时间）
     * @param date
     * @param day
     * @return
     */
    public static Date addMonth(Date date,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,month);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }

	/**
	 * 比较日期是否一样
	 */
	public static boolean dateCompare(Date dat1, Date dat2) {
		boolean dateComPareFlag = true;
		if (dat2.compareTo(dat1) != 1) {
			dateComPareFlag = false; //
		}
		return dateComPareFlag;
	}

	public static String formatLongToTimeStr(Long l) {
		// String str = "";
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (l != null) {
			second = l.intValue() / 1000;

			if (second > 60) {
				minute = second / 60;
				second = second % 60;
			}
			if (minute > 60) {
				hour = minute / 60;
				minute = minute % 60;

			}
		}
		String ret ="";
		if(hour>0){
			ret = hour + "小时" + minute + "分" + second + "秒";
		}else{
			if(minute>0){
				ret = minute + "分" + second + "秒";
			}else{
				ret = second + "秒";
			}
		}
		return ret;

	}

	/**
	 * 把Integer形式的时间改变成format形式
	 * 
	 * @param
	 * @param format
	 * @return
	 */
	public static String formatIntegerToTimeStr(Integer second, String format) {
		int hour = 0;
		int minute = 0;
		String ft = null;
		if (second != null) {
			if (second > 60) {
				minute = second / 60;
				second = second % 60;
			}
			if (minute > 60) {
				hour = minute / 60;
				minute = minute % 60;
			}
		} else {
			second = 0;
		}
		if(hour != 0){
			ft = (format.replace("HH", hour + "").replace("mm", minute + "")
					.replace("ss", second + ""));
		}else{
			ft = (format.replace("HH小时", "").replace("HH时", "").replace("mm", minute + "")
					.replace("ss", second + ""));
		}
		
		return ft;

	}

	public static String formatLongToTimeStr1(Long l) {
		String str = "";
		int hour = 0;
		int minute = 0;
		int second = 0;

		second = l.intValue() / 1000;

		if (second > 60) {
			minute = second / 60;
			// second = second % 60;

		} else {
			if (second > 0) {
				minute = minute + 1;
			}
		}
		// if (minute > 60) {
		// hour = minute / 60;
		// minute = minute % 60;
		//
		// }
		return (minute + "");

	}

	public static String percent(double p1, double p2) {
		String str;
		double p3 = p1 / p2;
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		str = nf.format(p3);
		return str;
	}

	/**
	 * Timestamp转化为String
	 * 
	 * @param span
	 *            时间
	 * @param format
	 *            格式
	 * @return
	 */
	public static String timestamp2Str(Timestamp span, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);// 定义格式，不显示毫秒
			String str = df.format(span);
			return str;
		} catch (Exception ex) {
			return "格式转换错误";
		}
	}

	/**
	 * 字符串转换为日期
	 * 
	 * @param strDate
	 * @param
	 * @param num
	 *            当前时间的后几天
	 * @return
	 */
	public static Timestamp timeStr2Timestamp(String strDate, int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:01");
		try {
			Date date = sdf.parse(strDate);
			Timestamp time = new Timestamp(date.getTime());
			time.setDate(time.getDate() + num);
			return time;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Timestamp timeStr2stamp(String strDate, String format) {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(strDate);
			Timestamp now = new Timestamp(date.getTime());// 获取系统当前时间
			return now;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Timestamp转化为String 默认格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param span
	 *            时间
	 * @return
	 */
	public static String timestamp2Str(Timestamp span) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定义格式，不显示毫秒

			String str = df.format(span);
			return str;
		} catch (Exception ex) {
			return "格式转换错误";
		}
	}

	/**
	 * Timestamp转化为String 默认格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Timestamp str2Timestamp() throws Exception {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			Timestamp ts = Timestamp.valueOf(time);
			return ts;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	

    /**
     * 获取随机日期
     *
     * @param beginDate
     *            起始日期，格式为：yyyy-MM-dd
     * @param endDate
     *            结束日期，格式为：yyyy-MM-dd
     * @return
     */

    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 获得之前日期
     * @param amount
     * @return
     */
    public static String getBeforDate(long amount){
        long timemillis =new Date().getTime()-(1000*60*60*24*amount);
        //System.out.println(new Date().getTime());
        //System.out.println(1000*60*60*24*amount);
        Date d=new Date(timemillis);
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(d);
    }

    /**
     * 获得两个日期之间的天
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getDayList(String begin,String end) {
        try{
            List<String> dayList = new ArrayList<String>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar start = Calendar.getInstance();
            start.setTime(sdf.parse(begin));
            Long startTIme = start.getTimeInMillis();

            Calendar endd = Calendar.getInstance();
            endd.setTime(sdf.parse(end));
            Long endTime = endd.getTimeInMillis();

            Long oneDay = 1000 * 60 * 60 * 24l;

            Long time = startTIme;
            while (time <= endTime) {
                Date d = new Date(time);
                dayList.add(sdf.format(d)+"日");
                time += oneDay;
            }
            return dayList;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 给日期加上分钟（计算x分钟之后的时间）
     * @param date
     * @param x
     * @return
     */
    public static Date addDateMinut(Date date, int x){   
          if (date == null) 
              return null;   
          Calendar cal = Calendar.getInstance();   
          cal.setTime(date);   
          cal.add(Calendar.MINUTE, x);// 24小时制   
          date = cal.getTime();   
          cal = null;
          return date;   
      }  
  
    /**
     * 给日期减去分钟（计算x分钟之前的时间）
     * @param date
     * @param x
     * @return
     */
    public static Date subDateMinut(Date date, int x){   
          if (date == null) 
              return null;   
          Calendar cal = Calendar.getInstance();   
          cal.setTime(date);   
          cal.add(Calendar.MINUTE, -x);// 24小时制   
          date = cal.getTime();   
          cal = null;
          return date;   
      }
    
}