package ldap;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.naming.CompoundName;
import javax.naming.Name;

public class LdapDN {

	public LdapDN(String dn) {
		this.dn = dn;
	}

	public String getDN() {
		return dn;
	}

	public String getParentDN() {
		String parentDN = "";
		int index = dn.indexOf(",");
		if (index != -1)
			parentDN = dn.substring(index + 1);
		else
			parentDN = "";
		return parentDN;
	}

	public boolean isValidFormat() {
		Properties syntax = new Properties();
		syntax.put("jndi.syntax.direction", "left_to_right");
		syntax.put("jndi.syntax.separator", ",");
		syntax.put("jndi.syntax.ignorecase", "true");
		try {
			Name dnName = new CompoundName(dn, syntax);
			for (int i = 0; i < dnName.size(); i++) {
				String component = dnName.get(i);
				if (component.indexOf("=") == -1) {
					boolean flag1 = false;
					return flag1;
				}
			}

		} catch (Exception e) {
			boolean flag = false;
			return flag;
		}
		return true;
	}

	public String firstNameSpace() {
		String namespace = "";
		int index = dn.indexOf(",");
		if (index != -1)
			namespace = dn.substring(0, index);
		else
			namespace = dn;
		return namespace;
	}

	public String changeParent(String new_parent_dn) {
		String newdn = "";
		if (new_parent_dn.trim().length() > 0)
			newdn = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(firstNameSpace()))))
					.append(",").append(new_parent_dn.trim())));
		else
			newdn = firstNameSpace();
		return newdn;
	}

	public String getName() {
		String name = "";
		int firstIndex = dn.indexOf("=");
		if (firstIndex != -1) {
			int lastIndex = dn.indexOf(",");
			if (lastIndex != -1)
				name = dn.substring(firstIndex + 1, lastIndex);
			else
				name = dn.substring(firstIndex + 1);
		}
		return name;
	}

	public boolean isExist(LdapConnection lc) {
		String filter = "(objectClass=*)";
		boolean flag2;
		try {
			LdapDN dns[] = lc.searchDN(dn, filter, 0);
			if (dns.length == 1) {
				boolean flag = true;
				return flag;
			} else {
				boolean flag1 = false;
				return flag1;
			}
		} catch (Exception e) {
			flag2 = false;
		}
		return flag2;
	}

	public String toSlashDN() {
		String ndsDN = "";
		Vector cells = new Vector();
		String name;
		for (StringTokenizer st = new StringTokenizer(dn, ","); st.hasMoreTokens(); cells.add(name)) {
			String temp = st.nextToken();
			name = temp.substring(temp.indexOf("=") + 1);
		}

		for (int i = 0; i < cells.size(); i++)
			if (i == 0)
				ndsDN = (String) cells.elementAt(i);
			else
				ndsDN = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(ndsDN)))).append(
						"/").append((String) cells.elementAt(i))));

		return ndsDN;
	}

	private String dn;
}