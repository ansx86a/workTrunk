package 新功能;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

public class 列舉中文範例 {

	// http://stackoverflow.com/questions/897935/when-do-java-generics-require-extends-t-instead-of-t-and-is-there-any-down

	/**
	 * 多此一舉的一個class，反正就練練，理論上不能用到String to EnumType的發生
	 * @param classOfT
	 * @param value
	 * @return
	 */
	public static <T extends Enum> T getEnumValue(Class<T> classOfT, String value) {
		try {
			T[] enums = (T[]) MethodUtils.invokeExactStaticMethod(classOfT, "values");
			for (T t : enums) {
				if (t.toString().equals(value))
					return t;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeException("not this enum value - " + value);
	}

	public static <T extends Enum> T 取得列舉用字串(Class<T> classOfT, String value) {
		List<T> list = EnumUtils.getEnumList(classOfT);
		for (T t : list) {
			if (StringUtils.equals(t.toString(), value)) {
				return t;
			}
		}
		return null;
	}

	public static void main(String... arg) {
		FN_TYPE f = getEnumValue(FN_TYPE.class, "D");
		System.out.println(f + "--" + f.name());
		f = 取得列舉用字串(FN_TYPE.class, "X");
		System.out.println(f + "--" + f.name());
		System.out.println(取得列舉用字串(FN_TYPE2.class, "$刪除"));
		System.out.println("取得列舉List====================================");
		System.out.println(EnumUtils.getEnumList(FN_TYPE.class));
		System.out.println(EnumUtils.getEnumList(FN_TYPE2.class));
		System.out.println("由列舉的名稱取出列舉的值====================================");
		f = EnumUtils.getEnum(FN_TYPE.class, "$新增");
		System.out.println(f);
		System.out.println(f.name());
		FN_TYPE2 f2 = EnumUtils.getEnum(FN_TYPE2.class, "$新增");
		System.out.println(f2);

	}

	/**
	 * <pre>
	 * 這邊的列舉最好內建型別都是String，我暫時想不到用別的型別的好處
	 * 另外java的method中不能出現列舉的代入和傳出參數
	 * 列舉只是為了方便撰寫代碼時可以分辦那個參數是什麼東西而已，參數還是要轉為string和int之類的來傳
	 * 這也是為了方便寫程式，不然從DB撈出來後還要轉列舉才能傳入method是累人的事啊
	 * </pre>
	 * @author ai
	 *
	 */
	public enum FN_TYPE {
		$新增("A"), $刪除("D"), $變更("E"), $查詢("Q"), $報表("R"), $匯出下載("O"), $列印("P"), $登入("L"), $登出("X");
		private String value;

		private FN_TYPE(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public enum FN_TYPE2 {
		$新增, $刪除, $變更, $查詢, $報表, $匯出下載, $列印, $登入, $登出;
	}
}
