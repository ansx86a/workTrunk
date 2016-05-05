package commonTool;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateUtils;

public class LangUtils {
	public static void main(String[] args) throws Exception {
		LangUtils u = new LangUtils();
		u.arrayUtils好用的東西();
		u.ClassUtils好用的東西();
		// DateFormatUtils 和DateFormatUtils.FastDateFormat 有機會用
		// FastDateFormat getInstance(String pattern) ，用法和simpleDateFormat差不多，實用性再看看吧
		u.DateUtils好用的東西();
		u.StringUtils好用的東東();
		System.out.println(StringEscapeUtils.escapeHtml4("角括號<>要變掉"));//還有xml之類的東西
		// RandomUtils
		// NumberUtils.min .max之類的取一個值回來
		// SystemUtils好你，可判斷作業系統之類的類似System.getpro...

		// 做一個取得這個月月初和上個月月初的method，good
		Date d = DateUtils.truncate(new Date(), Calendar.MONTH);
		System.out.println(d);
		d = DateUtils.addMonths(d, -1);
		System.out.println(d);


		
	}

	/**
	 * trimToNull，還有trim之類的省略
	 * equalsIgnoreCase 不會有null之類的問題
	 * lastIndexOf 好像還不錯用
	 * contains containsIgnoreCase 可以比用indexOf少寫幾個字
	 * substring 可以用負號，類似oracle可以捉後面幾個字
	 * left right mid
	 * join ，字串相加null會變成空字串 ，可傳一陣列加分隔號幫你組成一字串
	 * removeStart removeEnd，算replace("xxx","");
	 * replaceOnce replacePattern
	 * chomp 移掉換行字元而且要在尾部，一次而已A newline is "\n", "\r", or "\r\n".
	 * rightPad leftPad center
	 * upperCase lowerCase 
	 * capitalize(頭大寫) uncapitalize(頭小寫) swapCase(頭大小寫變換)
	 * countMatches 出現幾次
	 * reverse 反轉
	 * abbreviate 超過的字變成…
	 * difference 不一樣的字回傳  getCommonPrefix 回傳一樣的開頭
	 * toEncodedString 和newString有沒有一樣呢？
	 */
	public void StringUtils好用的東東() {

	}

	/**
	 * <pre>
	 * addDays addHours…
	 * setDays setHours…
	 * isSameDay 
	 * round(Date date,int field)  Calendar.HOUR_OF_DAY 之類
	 * truncate(Date date,int field) 和上面類似，但是是無條件捨去法
	 * ceiling
	 * truncatedEquals
	 * truncatedCompareTo
	 * </pre>
	 */
	public void DateUtils好用的東西() {
	}

	/**
	 * <pre>
	 * getShortClassName
	 * getSimpleName
	 * getPackageName
	 * isInnerClass
	 * </pre>
	 */
	public void ClassUtils好用的東西() {
	}

	/**
	 * <pre>
	 * toString 這個java5就有內含了
	 * isEquals 應該是比2個array元素是不是全相同吧
	 * T[] clone(T[] array)
	 * (Date[])ArrayUtils.subarray(allDates, 2, 5); 取2-5的陣列出來(非deep clone吧，一般clone我猜)
	 * getLength 處理掉null exception ->0
	 * reverse 反轉
	 * indexOf lastIndexOf contains應該蠻好用的
	 * addAll
	 * add 用途不明
	 * remove(T[] array, int index) removeAll removeAll好像不錯用
	 * T[] removeElement(T[] array, Object element) 好像不錯用
	 * isSorted
	 * 以下就是Arrays常用的==========================
	 * sort
	 * equals
	 * fill
	 * copyOf
	 * toString deepToString
	 * </pre>
	 */
	public void arrayUtils好用的東西() {

	}

}
