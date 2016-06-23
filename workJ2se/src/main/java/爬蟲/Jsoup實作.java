package 爬蟲;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup實作 {
	private static final String userAgent = "Mozilla/5.0 (jsoup)";

	public static void main(String[] args) throws Exception {
		Jsoup實作 p = new Jsoup實作();
		// p.$1最簡單的字串爬蟲();
		// p.$2由body來爬蟲();
		// p.$3由網扯爬蟲();
		// //p.$4由檔案爬蟲未測試();
		// p.$5簡單的取值測試();
		p.$6圖片和連結的爬蟲();
	}

	public void $1最簡單的字串爬蟲() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p><p>Parsed HTML into a doc2.</p></body></html>";
		Document doc = Jsoup.parse(html);

		Elements es = doc.getElementsByTag("p");
		for (Element e : es) {
			System.out.println("1");
			System.out.println(e.toString());
			System.out.println(e.text());
			System.out.println(e.tagName());

		}
	}

	public void $2由body來爬蟲() {
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);// 我分不出來和parse差在那裡
		Element body = doc.body();// =doc.getElementsByTag("body").
		System.out.println(body);
		System.out.println(body.text());
		html = "<html><div><p>Lorem ipsum.</p></html>";
		doc = Jsoup.parseBodyFragment(html);
		body = doc.body();// =doc.getElementsByTag("body").
		System.out.println(body);
		System.out.println(body.text());
	}

	public void $3由網扯爬蟲() throws Exception {
		Document doc = Jsoup.connect("http://www.kimo.com.tw/").get();
		// 上面不行的話，好像要用下面這個
		Document doc2 = Jsoup.connect("http://www.kimo.com.tw").data("query", "Java").userAgent("Mozilla")
				.cookie("auth", "token").timeout(3000).post();
		System.out.println(doc.title());
		System.out.println(doc2.title());
		// 下面就可以捉到kimo的熱門關鍵字了
		Elements els = doc.select("li.D-i.Fl-start");// css selector，把li標籤class為D-i和FL-start的選出來
		System.out.println(els.size());
		for (Element e : els) {
			System.out.println(e.attr("class"));
			Elements ees = e.getElementsByTag("a");
			if (ees.size() > 0) {
				System.out.println(ees.get(0).attr("href"));
			}
			System.out.println(e.text());
		}
		其它的select範例: {
			Elements links = doc.select("a[href]"); // a with href
			Elements pngs = doc.select("img[src$=.png]"); // img with src ending .png
			Element masthead = doc.select("div.masthead").first(); // div with class=masthead
			Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
		}

	}

	public void $4由檔案爬蟲未測試() throws IOException {
		File input = new File("/tmp/input.html");
		// 後面加上的url，可能是為了相對路徑設定的
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		// 不然也可以改成這樣子
		doc = Jsoup.parse(input, "UTF-8");
	}

	public void $5簡單的取值測試() throws IOException {

		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		System.out.println(text);
		String linkHref = link.attr("href"); // "http://example.com/"
		System.out.println(linkHref);
		String linkText = link.text(); // "example""
		System.out.println(linkText);

		String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"
		System.out.println(linkOuterH);
		String linkInnerH = link.html(); // "<b>example</b>"
		System.out.println(linkInnerH);

		doc = Jsoup.connect("http://jsoup.org").get();
		link = doc.select("a").first();
		// 網站的根目錄
		String relHref = link.attr("href"); // == "/"
		System.out.println(relHref);
		// 修正相對目錄為絕對目錄
		String absHref = link.attr("abs:href"); // "http://jsoup.org/"
		System.out.println(absHref);
	}

	public void $6圖片和連結的爬蟲() throws IOException {
		String url = "http://www.kimo.com.tw";
		System.out.printf("Fetching %s...\r\n", url);

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");// 讀取連結
		Elements media = doc.select("[src]");// 讀取可能是圖片的檔
		Elements imports = doc.select("link[href]");// 讀取import，如css之類的

		System.out.printf("\nMedia: (%d)\r\n", media.size());
		// 列印出圖片資訊
		for (Element src : media) {
			if (src.tagName().equals("img"))
				System.out.printf(" * %s: <%s> %sx%s (%s)\r\n", src.tagName(), src.attr("abs:src"), src.attr("width"),
						src.attr("height"), (src.attr("alt")));
			else
				System.out.printf(" * %s: <%s>\r\n", src.tagName(), src.attr("abs:src"));
		}

		System.out.printf("\nImports: (%d)\r\n", imports.size());
		// 列印出import的資訊，感覺沒什麼屁用
		for (Element link : imports) {
			System.out.printf(" * %s <%s> (%s)\r\n", link.tagName(), link.attr("abs:href"), link.attr("rel"));
		}

		System.out.printf("\nLinks: (%d)\r\n", links.size());
		// 列印出所有的連結
		for (Element link : links) {
			System.out.printf(" * a: <%s>  (%s)\r\n", link.attr("abs:href"), link.text());
		}

	}

	public void api() {
		apiFindingelements: {
			// Finding elements
			// getElementById(String id)
			// getElementsByTag(String tag)
			// getElementsByClass(String className)
			// getElementsByAttribute(String key) (and related methods)
			// Element siblings: siblingElements(), firstElementSibling(), lastElementSibling(); nextElementSibling(),
			// previousElementSibling()
			// Graph: parent(), children(), child(int index)
		}
		Elementdata: {
			// attr(String key) to get and attr(String key, String value) to set attributes
			// attributes() to get all attributes
			// id(), className() and classNames()
			// text() to get and text(String value) to set the text content
			// html() to get and html(String value) to set the inner HTML content
			// outerHtml() to get the outer HTML value
			// data() to get data content (e.g. of script and style tags)
			// tag() and tagName()
		}
		ManipulatingHTMLandtext: {
			// append(String html), prepend(String html)
			// appendText(String text), prependText(String text)
			// appendElement(String tagName), prependElement(String tagName)
			// html(String value)
		}

		select: {
			/**
			 * <pre>
			 * 			tagname: find elements by tag, e.g. a
			 * 			ns|tag: find elements by tag in a namespace, e.g. fb|name finds <fb:name> elements
			 * 			#id: find elements by ID, e.g. #logo
			 * 			.class: find elements by class name, e.g. .masthead
			 * 			[attribute]: elements with attribute, e.g. [href]
			 * 			[^attr]: elements with an attribute name prefix, e.g. [^data-] finds elements with HTML5 dataset attributes
			 * 			[attr=value]: elements with attribute value, e.g. [width=500] (also quotable, like [data-name='launch sequence'])
			 * 			[attr^=value], [attr$=value], [attr*=value]: elements with attributes that start with, end with, or contain the value, e.g. [href*=/path/]
			 * 			[attr~=regex]: elements with attribute values that match the regular expression; e.g. img[src~=(?i)\.(png|jpe?g)]
			 *          *: all elements, e.g. *
			 * </pre>
			 */
			// Selector combinations
			/**
			 * <pre>
			 * 
			 * el#id: elements with ID, e.g. div#logo
			 * el.class: elements with class, e.g. div.masthead
			 * el[attr]: elements with attribute, e.g. a[href]
			 * Any combination, e.g. a[href].highlight
			 * ancestor child: child elements that descend from ancestor, e.g. .body p finds p elements anywhere under a block with class "body"
			 * parent > child: child elements that descend directly from parent, e.g. div.content > p finds p elements; and body > * finds the direct children of the body tag
			 * siblingA + siblingB: finds sibling B element immediately preceded by sibling A, e.g. div.head + div
			 * siblingA ~ siblingX: finds sibling X element preceded by sibling A, e.g. h1 ~ p
			 * el, el, el: group multiple selectors, find unique elements that match any of the selectors; e.g. div.masthead, div.logo
			 * </pre>
			 */
			// Pseudo selectors
			/**
			 * <pre>
			 * :lt(n): find elements whose sibling index (i.e. its position in the DOM tree relative to its parent) is less than n; e.g. td:lt(3)
			 * :gt(n): find elements whose sibling index is greater than n; e.g. div p:gt(2)
			 * :eq(n): find elements whose sibling index is equal to n; e.g. form input:eq(1)
			 * :has(seletor): find elements that contain elements matching the selector; e.g. div:has(p)
			 * :not(selector): find elements that do not match the selector; e.g. div:not(.logo)
			 * :contains(text): find elements that contain the given text. The search is case-insensitive; e.g. p:contains(jsoup)
			 * :containsOwn(text): find elements that directly contain the given text
			 * :matches(regex): find elements whose text matches the specified regular expression; e.g. div:matches((?i)login)
			 * :matchesOwn(regex): find elements whose own text matches the specified regular expression
			 * Note that the above indexed pseudo-selectors are 0-based, that is, the first element is at index 0, the second at 1, etc
			 * 
			 * </pre>
			 */

		}

	}
}
