package ldap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * DN的object，與AD上的結構相同
 * 
 * @author longjiang.hu
 * 
 */
public class DNObj {
	/**
	 * DN的名字
	 */
	private String dnName;
	/**
	 * DN屬性List
	 */
	private Map attMap = new HashMap();

	DNObj() {
	}

	DNObj(String dnName) {
		this.dnName = dnName;
	}

	public String getParentDNName() {
		String parentDN = "";
		int index = this.dnName.indexOf(",");
		if (index != -1) {
			parentDN = this.dnName.substring(index + 1);
		} else {
			parentDN = "";
		}
		return parentDN;
	}

	/**
	 * 把屬性增加到DN里 key：屬性名稱 key對應一個list放屬性值
	 * 
	 * @param attribute
	 */
	public void putAtt(DNAttrib attribute) {
		Object obj = attMap.get(attribute.getAttribute());
		List list;
		if (null == obj) {
			list = new ArrayList();
			list.add(attribute.getValue());
			attMap.put(attribute.getAttribute(), list);
		} else {
			list = (List) obj;
			list.add(attribute.getValue());
		}
	}

	public void putAtt(String attribute, String value) {
		Object obj = attMap.get(attribute);
		List list;
		if (null == obj) {
			list = new ArrayList();
			list.add(value);
			attMap.put(attribute, list);
		} else {
			list = (List) obj;
			list.add(value);
		}
	}

	public void printMe() {
		Set set = attMap.keySet();
		Iterator it;
		List list;
		for (it = set.iterator(); it.hasNext();) {
			String s = (String) it.next();
			list = (List) attMap.get(s);
			System.out.print(s + ":");
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					System.out.print("[" + list.get(i) + "]");
				} else {
					System.out.print(",[" + list.get(i) + "]");
				}
			}
			System.out.println();
		}

	}

	/**
	 * 返回屬性對應的第一個值
	 * 
	 * @param attribute
	 * @return
	 */
	public String getFirstValue(String attribute) {
		Object obj = attMap.get(attribute);
		if (null == obj) {
			return null;
		} else {
			List list = (List) obj;
			if (list.size() <= 0) {
				return null;
			} else {
				return list.get(0).toString();
			}
		}
	}

	/**
	 * 返回屬性對應的值的list
	 * 
	 * @param attribute
	 * @return
	 */
	public List getValues(String attribute) {
		Object obj = attMap.get(attribute);
		if (null == obj) {
			return null;
		} else {
			return (List) obj;
		}
	}

	public static void main(String[] args) {
		DNAttrib att1 = new DNAttrib("1", "a");
		// DNAttrib att2 = new DNAttrib("2", "b");
		// DNObj obj = new DNObj();
		// obj.putAtt(att1);
		// obj.putAtt(att1);
		// obj.putAtt(att2);
		// obj.printMe();
		// System.out.println(obj.getFirstValue("1"));
		Vector dnsv = new Vector();
		ObjectArray oa = new ObjectArray(dnsv);
		dnsv.add(att1);
		System.out.println(oa.containsIgnoreCaseString("a"));
	}

	public String getDnName() {
		return dnName;
	}

	public void setDnName(String dnName) {
		this.dnName = dnName;
	}

	public Map getAttMap() {
		return attMap;
	}

	public void setAttMap(Map attMap) {
		this.attMap = attMap;
	}

}
