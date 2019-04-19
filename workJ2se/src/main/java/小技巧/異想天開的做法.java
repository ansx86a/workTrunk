package 小技巧;

public class 異想天開的做法 {
    public void 生成對應字串位元的索引表() {
        String str = "測試123測試321再測試123";
        int[] byte2StringIndex = new int[str.length() * 2 + 1];
        int indexPosition = 0;
        for (int i = 0; i < str.length(); i++) {
            byte2StringIndex[indexPosition++] = i;
            if (str.charAt(i) > 255) {// 只要不是ascii就是2byte
                byte2StringIndex[indexPosition++] = 1;
            }
        }
        byte2StringIndex[indexPosition++] = str.length();
    }
}
