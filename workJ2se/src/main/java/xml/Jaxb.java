package xml;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.stream.XMLInputFactory;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;

import tool.Utils;

public class Jaxb {
	// 已經把八成的用處實現出來了，如有更難的就參照java world的jaxb新手學習筆記，已放到package下
	public static void main(String[] args) throws Exception {
		// cdata幾乎無解，解法可參照一下http://blog.csdn.net/wantken/article/details/50675549
		// namespace修改前端pre部分也很難解，雖然可以用NamespacePrefixMapper來解，但感覺不順不好用

		Jaxb p = new Jaxb();
		// p.$1物件寫出xml();
		// p.$2xml轉物件();
		// p.$3多層物件轉xml();
		// p.$4物件轉xml有namespace();
		// p.$5物件轉xml客製namespace();
		// p.$6map設定值();
		p.$7map設定值簡化xml();
	}

	public String $1取得物件的xmlString(Object o) throws Exception {
		return $1取得物件的xmlString(o, null);
	}

	public String $1取得物件的xmlString(Object o, Object mapper) throws Exception {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// 漂亮排版
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// 拿掉<?xml version="1.0" encoding="UTF-8"standalone="yes"?>
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		// 加入預設值<?xml version="1.0" encoding="UTF-8" ?>
		sw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");

		// 當沒有拿掉<?xml ....?>的時候，這會另外寫在第二行
		// jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<!-- 這是表頭檔 -->\r\n");

		// 設定namespace
		if (mapper != null) {
			try {
				// jaxbMarshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", mapper);
			} catch (Exception e) {
				// In case another JAXB implementation is used
				e.printStackTrace();
			}
		}

		jaxbMarshaller.marshal(o, sw);
		return sw.toString();
	}

	public void $1物件寫出xml() throws Exception {
		Obj1 o = new Obj1();
		System.out.println($1取得物件的xmlString(o));
	}

	public <T extends Object> T $2xml轉物件(String xml, Class<T> cls) throws Exception {
		XMLInputFactory xif = XMLInputFactory.newInstance();

		xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);// 禁止插入實體，安全性考慮
		// xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

		JAXBContext jaxbContext2 = JAXBContext.newInstance(cls);
		Unmarshaller jaxbUnmarshaller = jaxbContext2.createUnmarshaller();

		Object output = jaxbUnmarshaller.unmarshal(xif.createXMLStreamReader(new StringReader(xml)));
		return (T) output;
	}

	public void $2xml轉物件() throws Exception {
		Obj1 o = new Obj1();
		o.setMyint(87);
		o.setMydouble(87.87);
		o.setMystr("changeStr");
		String resultXml = $1取得物件的xmlString(o);

		Obj1 o2 = $2xml轉物件(resultXml, Obj1.class);
		System.out.println(o2);
	}

	public void $3多層物件轉xml() throws Exception {
		Obj2 obj = new Obj2();
		obj.getList().add(new Obj1());
		obj.getList().add(new Obj1());
		obj.getList().add(new Obj1());
		System.out.println($1取得物件的xmlString(obj));

	}

	public void $4物件轉xml有namespace() throws Exception {
		Obj3 obj = new Obj3();
		obj.setId(999999999);
		String resultXml = $1取得物件的xmlString(obj);
		System.out.println(resultXml);
		Obj3 o2 = $2xml轉物件(resultXml, Obj3.class);
		System.out.println(o2);
	}

	public void $5物件轉xml客製namespace() throws Exception {
		Obj3 obj = new Obj3();
		obj.setId(999999999);

		Object m = null;
		// Mynamespace m = new Mynamespace();

		String resultXml = $1取得物件的xmlString(obj, m);
		System.out.println(resultXml);
		Obj3 o2 = $2xml轉物件(resultXml, Obj3.class);
		System.out.println(o2);
	}

	// 雖然可行，但是問題<>這兩個變換後的問題還蠻大的，在不會有html特別字元出現的地方才使用吧
	public void $6map設定值() throws Exception {
		JaxbMap map = new JaxbMap();
		String html = "<html>\n\t<p>\n\t\taaaa\n\t</p>\n</html>";
		// System.out.println(html);
		// map.getMap().put("html1", html);
		String resultXml = FileUtils.readFileToString(Utils.getResourceFromRoot("xml/1.xml"));
		// System.out.println(resultXml);
		map = $2xml轉物件(resultXml, JaxbMap.class);
		System.out.println(map.getMap());
	}

	public void $7map設定值簡化xml() throws Exception {
		JaxbConfig map = new JaxbConfig();
		寫出測試: {
			// String html = "<html>\n\t<p>\n\t\taaaa\n\t</p>\n</html>";
			// map.add("html1", html);
			// map.add("html2", html);
			// String resultXml = $1取得物件的xmlString(map);
			// System.out.println(resultXml);
		}

		讀取測試: {
			String resultXml = FileUtils.readFileToString(Utils.getResourceFromRoot("xml/2.xml"));
			map = $2xml轉物件(resultXml, JaxbConfig.class);
			System.out.println(map);
		}

	}

	@XmlRootElement(name = "myobj1")
	static class Obj1 {

		private String mystr = "<html>aaabbcc<br>ddddd<br></html>";

		private int myint = 199;

		private double mydouble = 3.14159;

		private Date mydate = new Date();

		private MyAttribute mmyyaatt = new MyAttribute();

		public String getMystr() {
			return mystr;
		}

		@Override
		public String toString() {
			return "Obj1 [mystr=" + mystr + ", myint=" + myint + ", mydouble=" + mydouble + ", mydate=" + mydate
					+ ", mmyyaatt=" + mmyyaatt + "]";
		}

		public MyAttribute getMmyyaatt() {
			return mmyyaatt;
		}

		public void setMmyyaatt(MyAttribute mmyyaatt) {
			this.mmyyaatt = mmyyaatt;
		}

		@XmlElement
		public void setMystr(String mystr) {
			this.mystr = mystr;
		}

		public int getMyint() {
			return myint;
		}

		@XmlElement(name = "newMyInt")
		public void setMyint(int myint) {
			this.myint = myint;
		}

		public double getMydouble() {
			return mydouble;
		}

		@XmlElement
		public void setMydouble(double mydouble) {
			this.mydouble = mydouble;
		}

		@XmlElement
		public Date getMydate() {
			return mydate;
		}

		public void setMydate(Date mydate) {
			this.mydate = mydate;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "MyType")
		static class MyAttribute {

			@XmlAttribute
			private String type = "type1";

			@XmlAttribute
			private String group = "group1";

			@XmlValue
			private String value = "庫嗶不要棒賽";

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getGroup() {
				return group;
			}

			public void setGroup(String group) {
				this.group = group;
			}

			@Override
			public String toString() {
				return "MyAttribute [type=" + type + ", group=" + group + ", value=" + value + "]";
			}

		}
	}

	@XmlRootElement(name = "myobj2")
	static class Obj2 {
		private String title = "titleObj2";
		private List<Obj1> list = new ArrayList<>();

		public String getTitle() {
			return title;
		}

		@XmlElement
		public void setTitle(String title) {
			this.title = title;
		}

		public List<Obj1> getList() {
			return list;
		}

		@XmlElement(name = "列表")
		public void setList(List<Obj1> list) {
			this.list = list;
		}
	}

	@XmlRootElement(name = "myobj3", namespace = "http://www.example.com/abc")
	static class Obj3 {
		private String title = "titleObj3";
		private int value = 123;
		private int id = 11;

		public int getId() {
			return id;
		}

		@XmlElement(namespace = "http://www.example.com/abc")
		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		@XmlElement(namespace = "http://www.example.com/BAR")
		public void setTitle(String title) {
			this.title = title;
		}

		public int getValue() {
			return value;
		}

		@XmlElement(namespace = "http://www.example.com/FOO")
		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Obj3 [title=" + title + ", value=" + value + ", id=" + id + "]";
		}

	}

	// 修改$5物件轉xml客製namespace可以回復namesapce

	// NamespacePrefixMapper有問題，不用:{
	// import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
	// static class Mynamespace extends NamespacePrefixMapper {
	//
	// private static final String FOO_PREFIX = "foo"; // DEFAULT NAMESPACE
	// private static final String FOO_URI = "http://www.example.com/FOO";
	//
	// private static final String BAR_PREFIX = "bar";
	// private static final String BAR_URI = "http://www.example.com/BAR";
	//
	// @Override
	// public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
	// if (FOO_URI.equals(namespaceUri)) {
	// return FOO_PREFIX;
	// } else if (BAR_URI.equals(namespaceUri)) {
	// return BAR_PREFIX;
	// }
	// return suggestion;
	// }
	//
	// @Override
	// public String[] getPreDeclaredNamespaceUris() {
	// return new String[] { FOO_URI, BAR_URI };
	// }
	// }
	// }
	@XmlRootElement(name = "config")
	static class JaxbMap {
		HashMap<String, String> map = new HashMap<>();

		public HashMap<String, String> getMap() {
			return map;
		}

		@XmlElement
		public void setMap(HashMap<String, String> map) {
			this.map = map;
		}

	}

	@XmlRootElement(name = "configMap")
	static class JaxbConfig {
		private ArrayList<MapAttribute> list = new ArrayList<MapAttribute>();

		public ArrayList<MapAttribute> getList() {
			return list;
		}

		@XmlElement(name = "map")
		// 這行可以沒有，tag就會變list
		public void setList(ArrayList<MapAttribute> list) {
			this.list = list;
		}

		public void add(String key, String value) {
			this.list.add(new MapAttribute(key, value));
		}

		@Override
		public String toString() {
			return "JaxbConfig [list=" + list + "]";
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "map")
	static class MapAttribute {

		@XmlAttribute
		private String key;

		@XmlValue
		private String value;

		// 一定要有空白的建構子，不然讀取時會有錯誤
		public MapAttribute() {
		};

		public MapAttribute(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "MapAttribute [key=" + key + ", value=" + value + "]";
		}

	}

}
