package ldap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class NLdapConnection {
	private String ip;
	private int port;
	private String currUserDN;
	private String currPassword;
	private transient LdapContext ctx;
	public static final int SEARCH_OBJECT_SCOPE = 0;
	public static final int SEARCH_ONELEVEL_SCOPE = 1;
	public static final int SEARCH_SUBTREE_SCOPE = 2;
	public static String GROUPMEMBERSHIP = "groupMembership";
	public static String UNIQUEMEMBER = "uniqueMember";
	public static String CTCBROLE = "ctcbRole";
	public static String SEEALSO = "seeAlso";
	public static String OBJECTCLASS = "objectClass";
	public static String GROUPOFNAMES = "groupOfNames";

	public NLdapConnection(String ip, int port) {
		this.ip = "";
		this.port = 389;
		this.currUserDN = null;
		this.currPassword = "";
		this.ctx = null;
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
		env.put("java.naming.factory.initial",
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url", String.valueOf(String
				.valueOf((new StringBuffer("ldap://")).append(ip).append(":")
						.append(port))));
		env.put("java.naming.security.authentication", "simple");
		env.put("java.naming.security.principal", dn);
		env.put("java.naming.security.credentials", password);
		try {
			if (isConnect()) {
				ctx.close();
			}
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

	public DNObj[] searchDN(String baseDN, String filter, int scope,
			String[] sids) throws Exception {
		Vector dns = new Vector();
		try {
			String ids[] = sids;
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(scope);
			constraints.setReturningAttributes(ids);
			DNObj dnobj;
			for (NamingEnumeration result = ctx.search(baseDN, filter,
					constraints); result.hasMore(); dns.addElement(dnobj)) {
				SearchResult sr = (SearchResult) result.next();
				String name = sr.getName();
				String resultDN = "";
				if (baseDN.trim().length() > 0) {
					resultDN = String.valueOf(String.valueOf((new StringBuffer(
							String.valueOf(String.valueOf(name)))).append(",")
							.append(baseDN)));
				} else {
					resultDN = name;
				}
				dnobj = new DNObj(resultDN);
				Attribute attr = null;
				String value = null;
				Attributes attrs = sr.getAttributes();
				for (NamingEnumeration en = attrs.getAll(); en.hasMore();) {
					attr = (Attribute) en.next();
					for (NamingEnumeration values = attr.getAll(); values
							.hasMore();) {
						value = (String) values.next();
						dnobj.putAtt(attr.getID(), value.trim());
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return (DNObj[]) dns.toArray(new DNObj[0]);
	}

	public Map searchDN2Map(String baseDN, String filter, int scope,
			String[] ids, Map attributes, Map dns_all) throws Exception {
		Map dns = new HashMap();
		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(scope);
			constraints.setReturningAttributes(ids);
			DNObj dnobj;
			boolean isAdd = false;
			for (NamingEnumeration result = ctx.search(baseDN,
					"(objectClass=*)", constraints); result.hasMore(); dns_all
					.put(dnobj.getDnName().toLowerCase(), dnobj)) {
				isAdd = false;
				SearchResult sr = (SearchResult) result.next();
				String name = sr.getName();
				String resultDN = "";
				if (baseDN.trim().length() > 0) {
					if (null == name || "".equals(name)) {
						resultDN = baseDN;
					} else {
						resultDN = new StringBuffer(name).append(",").append(
								baseDN).toString();
					}
				} else {
					resultDN = name;
				}
				dnobj = new DNObj(resultDN);
				Attribute attr = null;
				String value = null;
				Attributes attrs = sr.getAttributes();
				for (NamingEnumeration en = attrs.getAll(); en.hasMore();) {
					attr = (Attribute) en.next();
					for (NamingEnumeration values = attr.getAll(); values
							.hasMore();) {
						value = (String) values.next();
						String attrId = attr.getID();
						dnobj.putAtt(attrId, value);
						// System.out.println(attrId+"="+value);
						if (("(" + attrId + "=" + value + ")")
								.equalsIgnoreCase(filter)) {
							isAdd = true;
						}
						if (UNIQUEMEMBER.equalsIgnoreCase(attrId)) {
							// 返回UNIQUEMEMBER的屬性對應DN的map
							String key = new StringBuffer("(").append(
									UNIQUEMEMBER).append("=").append(
									resultDN.toLowerCase()).append(")").toString();
							Object obj = attributes.get(key);
							List l;
							if (null == obj) {
								l = new ArrayList();
								l.add(resultDN);
								attributes.put(key, l);
							} else {
								l = (List) obj;
								l.add(resultDN);
							}
						}
					}
				}
				if (isAdd) {
					dns.put(dnobj.getDnName().toLowerCase(), dnobj);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return dns;
	}

	public Map searchDN2Map(String baseDN, int scope, String[] ids,
			Map attributes, Map dns_all) throws Exception {
		Map dns = new HashMap();
		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(scope);
			constraints.setReturningAttributes(ids);
			DNObj dnobj;
			for (NamingEnumeration result = ctx.search(baseDN,
					"(objectClass=*)", constraints); result.hasMore(); dns_all
					.put(dnobj.getDnName().toLowerCase(), dnobj)) {
				SearchResult sr = (SearchResult) result.next();
				String name = sr.getName();
				String resultDN = "";
				if (baseDN.trim().length() > 0) {
					if (null == name || "".equals(name)) {
						resultDN = baseDN;
					} else {
						resultDN = new StringBuffer(name).append(",").append(
								baseDN).toString();
					}
				} else {
					resultDN = name;
				}
				dnobj = new DNObj(resultDN);
				Attribute attr = null;
				String value = null;
				Attributes attrs = sr.getAttributes();
				for (NamingEnumeration en = attrs.getAll(); en.hasMore();) {
					attr = (Attribute) en.next();
					for (NamingEnumeration values = attr.getAll(); values
							.hasMore();) {
						value = (String) values.next();
						String attrId = attr.getID();
						dnobj.putAtt(attrId, value);
						if (UNIQUEMEMBER.equalsIgnoreCase(attrId)) {
							// 返回UNIQUEMEMBER的屬性對應DN的map
							String key = new StringBuffer("(").append(
									UNIQUEMEMBER).append("=").append(
									resultDN.toLowerCase()).append(")").toString();
							Object obj = attributes.get(key);
							List l;
							if (null == obj) {
								l = new ArrayList();
								l.add(resultDN);
								attributes.put(key, l);
							} else {
								l = (List) obj;
								l.add(resultDN);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return dns;
	}

	public DNObj[] getUserRolesByAp(String ap_dn, Map dns_all, Map attributes,
			DNObj user_dn) throws Exception {
		Vector dnsv = new Vector();
		try {
			/**
			 * todo:move this confirm to out of circle if
			 * (!isSuperWhatObject("ctcbApplication", ap_dn)) { throw new
			 * Exception("No Such Application Object"); }
			 */
			String lower_ap_dn = ap_dn.toLowerCase();
			DNObj role_dns[] = getUserRoles(dns_all, attributes, user_dn);
			for (int i = 0; i < role_dns.length; i++) {
				String dn = role_dns[i].getDnName();
				String lower_dn = dn.toLowerCase();
				if (lower_dn.endsWith(lower_ap_dn)) {
					dnsv.addElement(role_dns[i]);
				}
			}
			DNObj aldapdn[] = (DNObj[]) dnsv.toArray(new DNObj[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public DNObj[] getUserRoles(Map dns_all, Map attributes, DNObj user_dn)
			throws Exception {
		try {
			Vector dnsv = new Vector();
			DNObj[] membershipDNs = getUserMembership(dns_all, attributes,
					user_dn);
			if (null != membershipDNs && membershipDNs.length > 0) {
				for (int i = 0; i < membershipDNs.length; i++) {
					// String dn = membershipDNs[i].getDN();
					// ObjectArray oa = new ObjectArray(dnsv);
					if (isNSuperWhatObject(CTCBROLE, membershipDNs[i])
							&& !containsIgnoreCaseString(dnsv, membershipDNs[i]
									.getDnName())) {
						dnsv.addElement(membershipDNs[i]);
					}
					getRoleSeeAlsoChain(dnsv, membershipDNs[i], dns_all);
				}
			}
			DNObj ldns[] = new DNObj[dnsv.size()];
			for (int j = 0; j < dnsv.size(); j++) {
				DNObj ldn = (DNObj) dnsv.elementAt(j);
				ldns[j] = ldn;
			}

			DNObj aldapdn[] = ldns;
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean containsIgnoreCaseString(Vector v, String s) {
		DNObj dn = null;
		for (int i = 0; i < v.size(); i++) {
			dn = (DNObj) v.elementAt(i);
			if (dn.getDnName().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	public DNObj[] getUserMembership(Map dns_all, Map attributes, DNObj user_dn)
			throws Exception {
		try {
			List list = user_dn.getValues(GROUPMEMBERSHIP);
			if (null == list) {
				list = new ArrayList();
			}
			String filter = String.valueOf(String
					.valueOf((new StringBuffer("(")).append(UNIQUEMEMBER)
							.append("=").append(
									user_dn.getDnName().toLowerCase()).append(
									")")));

			// LdapDN dns1[] = getUserStaticMembership(user_dn);
			// String filter = String.valueOf(String.valueOf((new StringBuffer(
			// "(uniqueMember=")).append(user_dn).append(")")));
			List list2;
			Object obj = attributes.get(filter);
			if (null == obj) {
				list2 = new ArrayList();
			} else {
				list2 = (List) obj;
			}
			// LdapDN dns2[] = searchDN(baseDN, filter, 2);
			TreeMap dns_total = new TreeMap();
			Object obj1 = null;
			for (int i = 0; i < list.size(); i++) {
				obj1 = dns_all.get(list.get(i).toString().toLowerCase());
				if (null == obj1)
					continue;
				DNObj tempDN = (DNObj) obj1;
				if (tempDN.getDnName() != null
						&& tempDN.getDnName().trim().length() != 0) {
					dns_total.put(tempDN.getDnName().toLowerCase(), tempDN);
				}
			}

			for (int j = 0; j < list2.size(); j++) {
				obj1 = (DNObj) dns_all.get(list2.get(j).toString()
						.toLowerCase());
				if (null == obj1)
					continue;
				DNObj tempDN = (DNObj) obj1;
				dns_total.put(tempDN.getDnName().toLowerCase(), tempDN);
			}

			DNObj aldapdn[] = (DNObj[]) dns_total.values()
					.toArray(new DNObj[0]);
			return aldapdn;
		} catch (Exception e) {
			throw e;
		}
	}

	private void getRoleSeeAlsoChain(Vector dnsv, DNObj role_dn, Map dns_all) {
		List list = role_dn.getValues(OBJECTCLASS);
		List list2;
		if (null == list) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).toString()).indexOf(GROUPOFNAMES) != -1) {
				list2 = role_dn.getValues(SEEALSO);
				if (null == list2) {
					break;
				}
				DNObj obj;
				Object obj1;
				for (int j = 0; j < list2.size(); j++) {
					obj1 = dns_all.get(list2.get(j));
					if (obj1 == null)
						continue;
					obj = (DNObj) obj1;
					if (isNSuperWhatObject(CTCBROLE, obj)
							&& !containsIgnoreCaseString(dnsv, obj.getDnName())) {
						dnsv.addElement(obj);
						getRoleSeeAlsoChain(dnsv, obj, dns_all);
					}
				}
				break;
			}
		}

	}

	// public LdapDN[] getUserStaticMembership(DNObj user_dn) throws Exception {
	// try {
	// List list = user_dn.getValues(GROUPMEMBERSHIP);
	//			
	// String returnAttrs[] = { "groupMembership" };
	// Attributes attrs = ctx.getAttributes(user_dn, returnAttrs);
	// Attribute attr = attrs.get("groupMembership");
	// Vector dns = new Vector();
	// if (attr != null) {
	// LdapDN tempLDN;
	// for (NamingEnumeration values = attr.getAll(); values.hasMore(); dns
	// .addElement(tempLDN)) {
	// String value = (String) values.next();
	// tempLDN = new LdapDN(value);
	// }
	//
	// }
	// LdapDN aldapdn[] = (LdapDN[]) dns.toArray(new LdapDN[0]);
	// return aldapdn;
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	private boolean isNSuperWhatObject(String objName, DNObj role_dn) {
		List list = role_dn.getValues("objectClass");
		if (null == list) {
			return false;
		}
		String value = "";
		for (int i = 0; i < list.size(); i++) {
			value = (String) list.get(i);
			if (value.toLowerCase().indexOf(objName.toLowerCase()) != -1) {
				return true;
			}
		}
		return false;
	}

	public boolean isSuperWhatObject(String objName, String role_dn) {
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

	public DNObj getAttributes(String dn, String[] ids) throws Exception {
		DNObj dnobj = new DNObj(dn);
		Attributes attrs = ctx.getAttributes(dn, ids);
		Attribute attr;
		String value;
		try {
			for (NamingEnumeration en = attrs.getAll(); en.hasMore();) {
				attr = (Attribute) en.next();
				for (NamingEnumeration values = attr.getAll(); values.hasMore();) {
					value = (String) values.next();
					String attrId = attr.getID();
					dnobj.putAtt(attrId, value);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return dnobj;
	}

	public void disconnect() {
		try {
			ctx.close();
		} catch (Exception exception) {
		}
	}
	
	public DNObj getAttributes2(String dn, String[] ids) throws Exception {
		DNObj dnobj = new DNObj(dn);
		Attributes attrs = ctx.getAttributes(dn);
		Attribute attr;
		String value;
		try {
			for (NamingEnumeration en = attrs.getAll(); en.hasMore();) {
				attr = (Attribute) en.next();
				for (NamingEnumeration values = attr.getAll(); values.hasMore();) {
					value = (String) values.next();
					String attrId = attr.getID();
					dnobj.putAtt(attrId, value);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return dnobj;
	}
}
