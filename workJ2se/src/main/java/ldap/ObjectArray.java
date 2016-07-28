package ldap;

import java.util.Vector;

public class ObjectArray {

	public ObjectArray(Vector v) {
		this.v = null;
		this.v = v;
	}

	public boolean containsIgnoreCaseString(String ics) {
		for (int i = 0; i < v.size(); i++)
			try {
				String temp = (String) v.elementAt(i);
				if (temp.equalsIgnoreCase(ics)) {
					boolean flag = true;
					return flag;
				}
			} catch (Exception exception) {
			}

		return false;
	}

	private Vector v;
}