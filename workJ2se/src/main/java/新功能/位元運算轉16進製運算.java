package 新功能;

public class 位元運算轉16進製運算 {

	public static void main(String[] args) {
		$1();
	}

	public static void $1() {
		int i = 35698;
		String hex = Integer.toHexString(i);
		System.out.println(hex);
		int result = Integer.valueOf(hex, 16);
		System.out.println(result);
	}

}
