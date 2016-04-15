package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		String all = "ISO8859_1,ISO8859_2,ISO8859_4,ISO8859_5,ISO8859_7,ISO8859_9,ISO8859_13,ISO8859_15,KOI8_R,ASCII,UTF8,UTF-16,UnicodeBigUnmarked,UnicodeLittleUnmarked,Cp1250,Cp1251,Cp1252,Cp1253,Cp1254,Cp1257,UnicodeBig,UnicodeLittle,Big5,Big5_HKSCS,EUC_JP,EUC_KR,GB18030,EUC_CN,GBK,Cp838,Cp858,Cp1140,Cp1141,Cp1142,Cp1143,Cp1144,Cp1145,Cp1146,Cp1147,Cp1148,Cp1149,Cp037,Cp1026,Cp1047,Cp273,Cp277,Cp278,Cp280,Cp284,Cp285,Cp297,Cp420,Cp424,Cp437,Cp500,Cp775,Cp850,Cp852,Cp855,Cp857,Cp860,Cp861,Cp862,Cp863,Cp864,Cp865,Cp866,Cp868,Cp869,Cp870,Cp871,Cp918,ISO2022CN,ISO2022JP,ISO2022KR,ISO8859_3,ISO8859_6,ISO8859_8,SJIS,TIS620,Cp1255,Cp1256,Cp1258,MS932,Big5_Solaris,EUC_JP_LINUX,EUC_TW,EUC_JP_Solaris,Cp1006,Cp1025,Cp1046,Cp1097,Cp1098,Cp1112,Cp1122,Cp1123,Cp1124,Cp1381,Cp1383,Cp33722,Cp737,Cp856,Cp874,Cp875,Cp921,Cp922,Cp930,Cp933,Cp935,Cp937,Cp939,Cp942,Cp942C,Cp943,Cp943C,Cp948,Cp949,Cp949C,Cp950,Cp964,Cp970,ISCII91,x-iso-8859-11,JISAutoDetect,x-Johab,MacArabic,MacCentralEurope,MacCroatian,MacCyrillic,MacDingbat,MacGreek,MacHebrew,MacIceland,MacRoman,MacRomania,MacSymbol,MacThai,MacTurkish,MacUkraine,MS950_HKSCS,MS936,PCK,MS874,MS949,MS950";
		File f = new File("Z:/2/RBNKTES2.D");
		// byte[] bs = FileUtils.readFileToByteArray(f);
		//
		//
		//
		// String ns = new String(bs, "Cp937");
		// FileUtils.write(new File("z:/aaaa.txt"), ns);
		// System.out.println(ns);
		// System.exit(0);
		ArrayList<String> list = new ArrayList<String>();
		byte[] bs = FileUtils.readFileToByteArray(f);
		for (int i = 0; i < bs.length; i += 106) {
			list.add(new String(Arrays.copyOfRange(bs, i, i + 106), "Cp937"));
		}

		// String s = FileUtils.readFileToString(f, "Cp937");

		// for (int i = 0; i < s.length() - 102; i += 102) {
		// list.add(s.substring(i, i + 102));
		// }
		System.out.println(list.get(list.size() - 1));

	}

}
