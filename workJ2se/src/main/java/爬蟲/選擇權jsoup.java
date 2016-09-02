package 爬蟲;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 選擇權jsoup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		選擇權jsoup j = new 選擇權jsoup();
		j.$1();

	}

	public void $1() throws IOException {
		// 期貨
		String url = "http://info512.taifex.com.tw/Future/FusaQuote_Norl.aspx";
		Document doc = Jsoup.connect(url).get();
		Elements es = null;
		es = doc.select("tr.custDataGridRow>td:contains(商品)");
		es.forEach(o -> System.out.println(o.parent().text()));

		es = doc.select("tr>td.bu13:contains(小臺指期)");
		es.forEach(o -> System.out.println(o.parent().text()));

		url = "http://info512.taifex.com.tw/Future/OptQuote_Norl.aspx";
		doc = Jsoup.connect(url).get();

		es = doc.select("span[id=ctl00_ContentPlaceHolder1_lblWPrice]");
		String 大盤指數 = es.get(0).text();
		System.out.println("大盤指數:" + 大盤指數);

		es = doc.select("tr.custDataGridRow>td:contains(履約價)");
		es=es.get(0).parent().parent().getElementsByTag("tr");
		es.forEach(o -> System.out.println(o.text()));

		
	}
}
