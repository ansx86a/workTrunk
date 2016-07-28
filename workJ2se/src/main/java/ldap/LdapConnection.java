package ldap;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * 主要看connect 30行，注意ctx = (LdapContext) ctx.lookup("");可能會多出一個ldapcontext造成多出執行緒來<br>
 * 可參考但是這一支程式明顯寫得不好，不管是close還是oo都沒弄好<br>
 *
 */
public class LdapConnection {

	public LdapConnection(String ip, int port) {
		this.ip = "";
		this.port = 389;
		currUserDN = null;
		currPassword = "";
		ctx = null;
		this.ip = ip;
		this.port = port;
	}

	public void connect(String dn, String password) throws Exception {
		if (dn == null || password == null) {
			dn = "";
			password = "";
		}
		currPassword = password;
		currUserDN = dn;
		Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url",
				String.valueOf(String.valueOf((new StringBuffer("ldap://")).append(ip).append(":").append(port))));
		env.put("java.naming.security.authentication", "simple");
		env.put("java.naming.security.principal", dn);
		env.put("java.naming.security.credentials", password);
		try {
			if (isConnect())
				ctx.close();
			ctx = new InitialLdapContext(env, null);
			ctx = (LdapContext) ctx.lookup("");
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isConnect() {
		boolean flag1;
		try {
			LdapContext testCtx = (LdapContext) ctx.lookup("");
			testCtx.close();
			boolean flag = true;
			return flag;
		} catch (Exception e) {
			flag1 = false;
		}
		return flag1;
	}

	public void reconnect() throws Exception {
		try {
			ctx.close();
			connect(currUserDN, currPassword);
		} catch (Exception e) {
			throw e;
		}
	}

	public void contextLessConnect(String username, String password, String rootBaseDn) throws Exception {
		LdapConnection conn = new LdapConnection(ip, port);
		try {
			conn.connect("", "");
			currUserDN = conn.getUserDN(username, rootBaseDn).getDN();
			conn.disconnect();
			connect(currUserDN, password);
		} catch (Exception e) {
			conn.disconnect();
			throw e;
		}
	}

	public LdapContext getLdapContext() {
		return ctx;
	}

	public LdapDN getLoginDN() {
		LdapDN ldn = new LdapDN(currUserDN);
		return ldn;
	}

	public void disconnect() {
		try {
			ctx.close();
		} catch (Exception exception) {
		}
	}

	public LdapDN getUserDN(String username, String baseDN) throws Exception {
		String userDN = null;
		String filter = String.valueOf(String.valueOf((new StringBuffer("(&(name=")).append(username).append(
				")(objectClass=inetOrgPerson))")));
		int scope = 2;
		LdapDN dns[] = searchDN(baseDN, filter, scope);
		LdapDN ldn;
		if (dns.length == 1) {
			userDN = dns[0].getDN();
			ldn = new LdapDN(userDN);
		} else if (dns.length == 0)
			throw new Exception("RCODE:biz-01(No such user)");
		else
			throw new Exception("RCODE:biz-02(Find Mutiple User DN)");
		return ldn;
	}

	public LdapDN[] listDN(String baseDN) throws Exception {
		Vector dns = new Vector();
		try {
			LdapDN ldn;
			for (NamingEnumeration name = ctx.list(baseDN); name.hasMore(); dns.addElement(ldn)) {
				NameClassPair sr = (NameClassPair) name.next();
				String childDN = null;
				if (baseDN.trim().length() > 0)
					childDN = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(sr
							.getName())))).append(",").append(baseDN)));
				else
					childDN = sr.getName();
				ldn = new LdapDN(childDN);
			}

			LdapDN aldapdn[] = (LdapDN[]) dns.toArray(new LdapDN[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] searchDN(String baseDN, String filter, int scope) throws Exception {
		Vector dns = new Vector();
		try {
			String ids[] = new String[0];
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(scope);
			constraints.setReturningAttributes(ids);
			LdapDN ldn;
			for (NamingEnumeration result = ctx.search(baseDN, filter, constraints); result.hasMore(); dns
					.addElement(ldn)) {
				SearchResult sr = (SearchResult) result.next();
				String name = sr.getName();
				String resultDN = "";
				if (baseDN.trim().length() > 0)
					resultDN = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(name))))
							.append(",").append(baseDN)));
				else
					resultDN = name;
				ldn = new LdapDN(resultDN);
			}

		} catch (Exception e) {
			throw e;
		}
		return (LdapDN[]) dns.toArray(new LdapDN[0]);
	}

	public LdapDN[] searchDN(String baseDN, Attributes attrs) throws Exception {
		Vector dns = new Vector();
		try {
			String ids[] = new String[0];
			LdapDN ldn;
			for (NamingEnumeration result = ctx.search(baseDN, attrs, ids); result.hasMore(); dns.addElement(ldn)) {
				SearchResult sr = (SearchResult) result.next();
				String name = sr.getName();
				String resultDN = "";
				if (baseDN.trim().length() > 0)
					resultDN = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(name))))
							.append(",").append(baseDN)));
				else
					resultDN = name;
				ldn = new LdapDN(resultDN);
			}

		} catch (Exception e) {
			throw e;
		}
		return (LdapDN[]) dns.toArray(new LdapDN[0]);
	}

	public void changePassword(String oldPass, String newPass) throws Exception {
		try {
			ModificationItem mods[] = new ModificationItem[2];
			Attribute attr0 = new BasicAttribute("userPassword", oldPass);
			mods[0] = new ModificationItem(3, attr0);
			Attribute attr1 = new BasicAttribute("userPassword", newPass);
			mods[1] = new ModificationItem(1, attr1);
			ctx.modifyAttributes(currUserDN, mods);
		} catch (Exception e) {
			throw e;
		}
	}

	public void resetPassword(String dn, String newPass) throws Exception {
		try {
			Attributes attrs = new BasicAttributes();
			attrs.put("userPassword", new String(newPass));
			ctx.modifyAttributes(dn, 2, attrs);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isPasswordExpired() {
		return isPasswordExpired(currUserDN);
	}

	public boolean isPasswordExpired(String dn) {
		Calendar rightNow = Calendar.getInstance();
		Calendar expireTime = getPasswordExpirationTime(dn);
		return expireTime != null && rightNow.after(expireTime);
	}

	public Calendar getPasswordExpirationTime(String dn) {
		Calendar calendar;
		try {
			String ids[] = { "passwordExpirationTime" };
			Attributes attrs = ctx.getAttributes(dn, ids);
			Attribute attr = attrs.get("passwordExpirationTime");
			String expireTimeString = (String) attr.get();
			TimeTransform tt = new TimeTransform();
			Calendar expireTime = tt.ndsTime2Calendar(expireTimeString);
			Calendar calendar1 = expireTime;
			return calendar1;
		} catch (Exception e) {
			calendar = null;
		}
		return calendar;
	}

	public Attributes getAttributes(String dn) throws Exception {
		try {
			Attributes attrs = ctx.getAttributes(dn);
			Attributes attributes = attrs;
			return attributes;
		} catch (Exception e) {
			throw e;
		}
	}

	public Attributes getAttributes(String dn, String returnAttrs[]) throws Exception {
		try {
			Attributes attrs = ctx.getAttributes(dn, returnAttrs);
			Attributes attributes = attrs;
			return attributes;
		} catch (Exception e) {
			throw e;
		}
	}

	public String getApByRole(String role_dn) throws Exception {
		try {
			if (!isSuperWhatObject("ctcbRole", role_dn)) {
				throw new Exception("No Such Role Object");
			} else {
				LdapDN ldn = new LdapDN(role_dn);
				String parentDN = ldn.getParentDN();
				String s = parentDN;
				return s;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] getRolesByAp(String ap_dn) throws Exception {
		try {
			if (!isSuperWhatObject("ctcbApplication", ap_dn)) {
				throw new Exception("No Such Application Object");
			} else {
				LdapDN dns[] = listDN(ap_dn);
				LdapDN aldapdn[] = dns;
				return aldapdn;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] getUserAps(String baseDN, String user_dn) throws Exception {
		try {
			TreeMap dns = new TreeMap();
			LdapDN role_dns[] = getUserRoles(baseDN, user_dn);
			for (int i = 0; i < role_dns.length; i++) {
				String apDN = role_dns[i].getParentDN();
				LdapDN ldn = new LdapDN(apDN);
				dns.put(apDN.toLowerCase(), ldn);
			}

			LdapDN aldapdn[] = (LdapDN[]) dns.values().toArray(new LdapDN[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] getUserRolesByAp(String ap_dn, String baseDN, String user_dn) throws Exception {
		Vector dns = new Vector();
		try {
			if (!isSuperWhatObject("ctcbApplication", ap_dn))
				throw new Exception("No Such Application Object");
			String lower_ap_dn = ap_dn.toLowerCase();
			LdapDN role_dns[] = getUserRoles(baseDN, user_dn);
			for (int i = 0; i < role_dns.length; i++) {
				String dn = role_dns[i].getDN();
				String lower_dn = dn.toLowerCase();
				if (lower_dn.endsWith(lower_ap_dn))
					dns.addElement(role_dns[i]);
			}

			LdapDN aldapdn[] = (LdapDN[]) dns.toArray(new LdapDN[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] getUserRoles(String baseDN, String user_dn) throws Exception {
		try {
			Vector dns = new Vector();
			LdapDN membershipDNs[] = getUserMembership(baseDN, user_dn);
			for (int i = 0; i < membershipDNs.length; i++) {
				String dn = membershipDNs[i].getDN();
				ObjectArray oa = new ObjectArray(dns);
				if (isSuperWhatObject("ctcbRole", dn) && !oa.containsIgnoreCaseString(dn))
					dns.addElement(dn);
				getRoleSeeAlsoChain(dns, dn);
			}

			LdapDN ldns[] = new LdapDN[dns.size()];
			for (int j = 0; j < dns.size(); j++) {
				LdapDN ldn = new LdapDN((String) dns.elementAt(j));
				ldns[j] = ldn;
			}

			LdapDN aldapdn[] = ldns;
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	private void getRoleSeeAlsoChain(Vector dns, String role_dn) {
		try {
			ObjectArray oa = new ObjectArray(dns);
			String ids[] = { "seeAlso", "objectClass" };
			Attributes attrs = ctx.getAttributes(role_dn, ids);
			Attribute attr = attrs.get("objectClass");
			if (attr.contains(new String("groupOfNames"))) {
				attr = attrs.get("seeAlso");
				NamingEnumeration seealsoObjs = attr.getAll();
				do {
					if (!seealsoObjs.hasMoreElements())
						break;
					String value = (String) seealsoObjs.nextElement();
					if (isSuperWhatObject("ctcbRole", value) && !oa.containsIgnoreCaseString(value)) {
						dns.addElement(value);
						getRoleSeeAlsoChain(dns, value);
					}
				} while (true);
			}
		} catch (Exception exception) {
		}
	}

	private boolean isSuperWhatObject(String objName, String role_dn) {
		try {
			String ids[] = { "objectClass" };
			Attributes attrs = ctx.getAttributes(role_dn, ids);
			Attribute attr = attrs.get("objectClass");
			if (attr.contains(new String(objName))) {
				boolean flag = true;
				return flag;
			}
		} catch (Exception exception) {
		}
		return false;
	}

	public LdapDN[] getUserMembership(String baseDN, String user_dn) throws Exception {
		try {
			LdapDN dns1[] = getUserStaticMembership(user_dn);
			String filter = String.valueOf(String.valueOf((new StringBuffer("(uniqueMember=")).append(user_dn).append(
					")")));
			LdapDN dns2[] = searchDN(baseDN, filter, 2);
			TreeMap dns_total = new TreeMap();
			for (int i = 0; i < dns1.length; i++) {
				LdapDN tempDN = dns1[i];
				dns_total.put(tempDN.getDN().toLowerCase(), tempDN);
			}

			for (int j = 0; j < dns2.length; j++) {
				LdapDN tempDN = dns1[j];
				dns_total.put(tempDN.getDN().toLowerCase(), tempDN);
			}

			LdapDN aldapdn[] = (LdapDN[]) dns_total.values().toArray(new LdapDN[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public LdapDN[] getUserStaticMembership(String user_dn) throws Exception {
		try {
			String returnAttrs[] = { "groupMembership" };
			Attributes attrs = ctx.getAttributes(user_dn, returnAttrs);
			Attribute attr = attrs.get("groupMembership");
			Vector dns = new Vector();
			if (attr != null) {
				LdapDN tempLDN;
				for (NamingEnumeration values = attr.getAll(); values.hasMore(); dns.addElement(tempLDN)) {
					String value = (String) values.next();
					tempLDN = new LdapDN(value);
				}

			}
			LdapDN aldapdn[] = (LdapDN[]) dns.toArray(new LdapDN[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	private String ip;
	private int port;
	private String currUserDN;
	private String currPassword;
	private transient LdapContext ctx;
	public static final int SEARCH_OBJECT_SCOPE = 0;
	public static final int SEARCH_ONELEVEL_SCOPE = 1;
	public static final int SEARCH_SUBTREE_SCOPE = 2;

}