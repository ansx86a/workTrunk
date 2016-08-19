/**
 * @Class description: To get data from LDAP
 * @author: Melanie Hou
 * @Date: 2006-12-25
 * 
 * 
 * Known Bugs :  
 * 
 */
package ldap;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 由main看下去，主要留這個程式的原因是因為他的search用得蠻複雜的，留下來參考<br>
 * 主要配kissconfig和dnAttrib,Dnobj三個物件才能正常運作
 * @author ai
 *
 */
public class KISSGetEmployeefromNewLdapTestAIX {
	// counter for test performance
	// private long readtime = 0;
	// private long writetime = 0;
	// private long reademptime = 0;
	// private long writeemptime = 0;

	public static String CTCB_ROLE_FILTER = "(objectClass=ctcbRole)";
	public static String CTCB_EMP_FILTER = "(objectClass=inetOrgPerson)";
	public static String[] CTCB_EMP_IDS = { "objectClass", "groupMembership", "seeAlso", "groupOfNames",
			"uniqueMember", "fullName", "ou", "title" };
	public static String CTCB_DN1 = "o=ctcb";
	// change
	/**
	 * public static String CTCB_ROLE_FILTER = "(objectClass=top)"; public static String CTCB_EMP_FILTER =
	 * "(objectClass=person)"; public static String[] CTCB_EMP_IDS = { "objectClass", "groupMembership" };
	 */
	// LDAP server ID address
	private String ldapIp_ = null;

	// LDAP server port
	private String port_ = null;

	// LDAP base DN
	private String baseDn_ = null;

	// LDAP login user DN
	private String id_ = null;

	// LDAP login password
	private String pswd_ = null;

	// determine the connection method
	private String needbackUp_ = null;

	// LDAP log file name
	private String logFile_ = null;

	// LDAP output employee data file name
	private String outputFile_ = null;

	// the max number of employee records getting from LDAP
	private String empNum_ = null;

	// LDAP output role data file name
	private String outputFile2_ = null;

	// the max number of role records getting from LDAP
	private String empNum2_ = null;

	// seperator mark between every output data
	private String delimiter_ = null;

	// attribute names list
	private String[] empAttrNames_ = null;

	private String[] empAttrs_ = null;

	private String[] deptAttrs_ = null;

	private String[] deptRawAttrs_ = null;

	private String[] roles_ = null;

	private String[] emps_ = null;

	private String adscription = "";

	// static values
	// change
	private static final String DEFAULT_PORT = KissConfig.getString("HC_KISS_LDAP", "DEFAULT_LDAP_PORT");

	private static final String DEFAULT_IP = KissConfig.getString("HC_KISS_LDAP", "DEFAULT_LDAP_IP");

	private static final String DEFAULT_BASEDN = KissConfig.getString("HC_KISS_LDAP", "DEFAULT_LDAP_BASEDN");

	private static final String DEFAULT_EMPLOYEE_OUTPUTFILE = KissConfig.getString("HC_KISS_LDAP",
			"DEFAULT_LDAPDATA_EMPLOYEE_OUTPUTFILE");

	private static final String DEFAULT_ROLE_OUTPUTFILE = KissConfig.getString("HC_KISS_LDAP",
			"DEFAULT_LDAPDATA_ROLE_OUTPUTFILE");

	private static final String DEFAULT_SEPERATOR = KissConfig.getString("HC_KISS_LDAP", "DEFAULT_LDAPDATA_SEPERATOR");

	private static final int INPUT_EMPLOYEE_ATTRIBUTE_NUMBER = 12;

	private static final String adscriptionCredit = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_CREDITID");

	private static final String adscriptionRetail = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_RETAILID");
	private static final String ap_dn = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_EMPLOYEE_ROLE_OBJ_DN");

	private static final String ldap_devision = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_DIVISION");

	private static final String ldap_dept = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_DEPT");

	private static final String ldap_team = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_TEAM");
	/**
	 * private static final String DEFAULT_PORT = "389";
	 * 
	 * private static final String DEFAULT_IP = "192.168.31.40";
	 * 
	 * private static final String DEFAULT_BASEDN = "o=ctcb";
	 * 
	 * private static final String DEFAULT_EMPLOYEE_OUTPUTFILE = "c:\\log_emp.txt";
	 * 
	 * private static final String DEFAULT_ROLE_OUTPUTFILE = "c:\\log_role.txt";
	 * 
	 * private static final String DEFAULT_SEPERATOR = "/";
	 * 
	 * private static final int INPUT_EMPLOYEE_ATTRIBUTE_NUMBER = 12;
	 * 
	 * private static final String adscriptionCredit = "M00022881";
	 * 
	 * private static final String adscriptionRetail = "M00022311";
	 * 
	 * private static final String ap_dn = "ou=APPs,o=ctcb";
	 * 
	 * private static final String ldap_devision = "TW_DIVISION_LVL";
	 * 
	 * private static final String ldap_dept = "TW_DEPT_LVL";
	 * 
	 * private static final String ldap_team = "TW_TEAM_LVL";
	 */
	private String current_objectID = null;

	private String errorString = null;

	public KISSGetEmployeefromNewLdapTestAIX() throws Exception {
		super();
	}

	/**
	 * @Method description: assign the global variables
	 * @Author: Melanie Hou
	 * @Date: 2006-12-25
	 * @param ldapIp: LDAP server ID address
	 * @param port: LDAP server port
	 * @param baseDn: LDAP base DN
	 * @param id: LDAP login user DN
	 * @param pswd: LDAP login password
	 * @param contextLessConnect: determine the connection method
	 * @param logFile: LDAP log file name
	 * @param outputFile: LDAP employee output data file name
	 * @param empNum: the max number of employee records getting from LDAP
	 * @param outputFile2: LDAP role output data file name
	 * @param empNum2: the max number of role records getting from LDAP
	 * @param delimiter: seperator mark between every output data
	 * @param empAttrNames: attribute names list
	 */
	public KISSGetEmployeefromNewLdapTestAIX(String ldapIp, String port, String baseDn, String id, String pswd,
			String needbackUp, String logFile, String outputFile, String empNum, String outputFile2, String empNum2,
			String delimiter, String[] empAttrNames) {
		ldapIp_ = ldapIp;
		port_ = port;
		baseDn_ = baseDn;
		id_ = id;
		pswd_ = pswd;
		needbackUp_ = needbackUp;
		logFile_ = logFile;
		outputFile_ = outputFile;
		empNum_ = empNum;

		outputFile2_ = outputFile2;
		empNum2_ = empNum2;

		delimiter_ = delimiter;
		empAttrNames_ = empAttrNames;
	}

	/**
	 * @Method description: This method will be run when execute this class.
	 * @Author: Melanie Hou
	 * @Date: 2006-12-25
	 * @throws Exception: throw Exeception if can't get data from LDAP
	 */
	private Object updateEmployee = new Object();

	public void run() throws Exception {
		NLdapConnection lc = null;
		Connection dbconn = null;
		try {
			// check and get the input parametters

			isReady();

			// backup the current data file before rewrite
			backupFile(logFile_);

			// create a new LDAP connection
			lc = prepareConnection(ldapIp_, Integer.parseInt(port_.trim()));
			// connect LDAP
			if (!connectLdap(lc, baseDn_, id_, pswd_))
				return;
			// connect DB for writing LDAP data into file and DB
			// change

			// dbconn = updateEmployee.getConnection();
			dbconn = null;
			if (dbconn == null)
				return;

			// write LDAP data into role, employeerole and privilegerole table
			// change
			if (!writeRoleFlatFile(lc))
				throw new Exception();

			// write LDAP data into Employee table if data is correct
			if (!writeFlatFile(lc))
				throw new Exception();

			// if succeed, write data to output file
			System.out.println("Process Succeeded. ");
			System.out.println("Check file [" + outputFile_ + " and " + outputFile2_ + "] for output!");
			System.out.println("Check DB for updated User/Role/User-Role/Role-Privilege tables!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			// disconnect LDAP
			if (lc != null)
				lc.disconnect();

			if (dbconn != null) {

			}
			// updateEmployee.closeConnection();
		}
	}

	/**
	 * @description : get parameters
	 * @Exception :throw Exeception if can't get parameter data
	 */
	private void isReady() throws Exception {
		// there should be at least one attribute name
		if (empAttrNames_ == null || empAttrNames_.length == 0)
			throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_SUBDEPARYMRNT_LEN"));
		// contain all the none department attributes
		ArrayList empAttrs = new ArrayList();
		// contain all the department attributes without prefix
		ArrayList deptAttrs = new ArrayList();
		// contain all the raw attributes started with string : "DEPT_"
		ArrayList deptRawAttrs = new ArrayList();
		String PREFIX = "DEPT_";

		// define default log file name
		if (logFile_ == null || logFile_.trim().length() == 0)
			logFile_ = "KISSGetEmployeefromLdap.exception";
		else
			logFile_ = logFile_.trim();

		// loop: distinguish the PREFIX="DEPT_" args(departemt relative
		// attributes) from other attrubutes
		for (int i = 0; i < empAttrNames_.length; i++) {
			if (empAttrNames_[i] == null)
				continue;
			if (empAttrNames_[i].startsWith(PREFIX)) {
				deptAttrs.add(empAttrNames_[i].trim());
				deptRawAttrs.add(empAttrNames_[i].substring(empAttrNames_[i].indexOf(PREFIX) + PREFIX.length()));
			} else
				empAttrs.add(empAttrNames_[i].trim());
		}

		// get all the attributes except department relative attributes
		if (!empAttrs.isEmpty()) {
			empAttrs_ = new String[empAttrs.size()];
			empAttrs.toArray(empAttrs_);
		}
		// get all the departement relative attributes
		if (!deptAttrs.isEmpty()) {
			deptAttrs_ = new String[deptAttrs.size()];
			deptAttrs.toArray(deptAttrs_);
		}
		// get all the "ou=D, ou=T, ou=S" raw attributes
		if (!deptRawAttrs.isEmpty()) {
			deptRawAttrs_ = new String[deptRawAttrs.size()];
			deptRawAttrs.toArray(deptRawAttrs_);
		}

		// define the LDAP sever IP, input arg can be none, the default one is
		// defined here
		if (ldapIp_ == null || ldapIp_.trim().length() == 0)
			ldapIp_ = DEFAULT_IP;
		else
			ldapIp_ = ldapIp_.trim();

		// define the LDAP sever port, input arg can be none, the default one is
		// defined here

		if (port_ != null) {
			try {
				Integer.parseInt(port_.trim());
				port_ = port_.trim();

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				errorString = e.toString() + "\n";
				throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_PORT_TYPE"));
			}
		} else
			port_ = DEFAULT_PORT;

		// define the LDAP base DN, input arg can be none, the default one is
		// defined here
		if (baseDn_ == null || baseDn_.trim().length() == 0)
			baseDn_ = DEFAULT_BASEDN;
		else
			baseDn_ = baseDn_.trim();

		// define the LDAP service ID
		if (id_ == null || id_.trim().length() == 0)
			throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_NONE_SERVICEID"));
		else
			id_ = id_.trim();

		// define password
		if (pswd_ == null || pswd_.trim().length() == 0)
			throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_NONE_PSWD"));
		else
			pswd_ = pswd_.trim();

		// define default employee output file name
		if (outputFile_ == null || outputFile_.trim().length() == 0)
			outputFile_ = DEFAULT_EMPLOYEE_OUTPUTFILE;
		else
			outputFile_ = outputFile_.trim();

		// define employee output number
		if (empNum_ != null && empNum_.trim().length() != 0) {
			try {
				Integer.parseInt(empNum_.trim());
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				errorString = e.toString() + "\n";
				throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_EMPNUMBER_TYPE"));
			}
		}

		// define default roles output file name
		if (outputFile2_ == null || outputFile2_.trim().length() == 0)
			outputFile2_ = DEFAULT_ROLE_OUTPUTFILE;
		else
			outputFile2_ = outputFile2_.trim();

		// define role output number

		if (empNum2_ != null && empNum2_.trim().length() != 0) {
			try {
				Integer.parseInt(empNum2_.trim());
				// empNum2_ = empNum2_.trim();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				errorString = e.toString() + "\n";
				throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_ROLENUMBER_TYPE"));
			}
		}

		// define default seperator
		if (delimiter_ == null || delimiter_.trim().length() == 0)
			delimiter_ = DEFAULT_SEPERATOR;
		else
			delimiter_ = delimiter_.trim();

		System.out.println(this);
		System.out.println("Processing... Please wait!");

	}

	/**
	 * @description : write log file for the exception in getEmployeefromLdap process
	 * @param ex: the exception in getEmployeefromLdap process
	 */
	private void logException(Exception ex) {
		if (ex == null)
			return;
		RandomAccessFile raf = null;
		try {
			backupFile(logFile_);
			raf = new RandomAccessFile(new File(logFile_), "rw");

			if (current_objectID != null)
				raf.write(("Error Record ID:" + current_objectID + System.getProperty("line.separator"))
						.getBytes("UTF-8"));
			if (errorString != null)
				raf.write(("Error:" + errorString + System.getProperty("line.separator")).getBytes("UTF-8"));

			raf.write(getStackTrace(ex).getBytes("UTF-8"));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			errorString = e.toString() + "\n";
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (Exception e2) {
					System.out.println("Error: " + e2.getMessage());
					errorString = e2.toString() + "\n";
				}
			}
		}
	}

	/**
	 * @description : get the exception content from input exception
	 * @param ex: the exception in getEmployeefromLdap process
	 */
	private String getStackTrace(Exception ex) {
		if (ex == null)
			return "";
		PrintWriter writer = null;
		StringWriter output = new StringWriter();
		try {
			writer = new PrintWriter(output, true);
			ex.printStackTrace(writer);
			return output.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null)
					output.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * @description : write backup file of current employee information
	 * @param fileName: the name of generated backup file
	 */
	private void backupFile(String fileName) throws Exception {
		File oldFile = new File(fileName);
		if (oldFile.exists())
			oldFile.renameTo(new File(fileName
					+ "-bakup"
					+ (new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.sql.Date(System
							.currentTimeMillis())))));
		else if (oldFile.getParentFile() != null)
			oldFile.getParentFile().mkdirs();
	}

	/**
	 * @description : write employee LDAP information into file
	 * @param lc: LDAP connnections
	 */
	private boolean writeFlatFile(NLdapConnection lc) throws Exception {
		// create a new UpdateEmployeeInfo instance and connect to DB
		// UpdateEmployeeInfo updateEmployee = new UpdateEmployeeInfo();
		// updateEmployee.getConnection();

		if (lc == null)
			return false;
		// employee Dn
		// change
		String baseDn = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_EMPLOYEE_OBJ_DN");
		// String roleDn = KissConfig.getString("HC_KISS_LDAP",
		// "KISS_LDAP_ROLE_OBJ_DN");
		String role_Dn = "ou=APPs,o=CTCB";
		// String baseDn = "ou=HRIS,o=CTCB";
		// String baseDn = "ou=test,DC=test,DC=com";
		String filter = CTCB_EMP_FILTER;
		int scope = NLdapConnection.SEARCH_SUBTREE_SCOPE;
		// 這里要加String ids[]，要取得的屬性。
		String[] ids = new String[empAttrs_.length + CTCB_EMP_IDS.length];
		for (int i = 0; i < empAttrs_.length + CTCB_EMP_IDS.length; i++) {
			if (i < empAttrs_.length) {
				ids[i] = empAttrs_[i];
			} else {
				ids[i] = CTCB_EMP_IDS[i - empAttrs_.length];
			}
		}
		DNObj ctcbDN = lc.getAttributes(CTCB_DN1, CTCB_EMP_IDS);
		Map attributes = new HashMap();
		Map dns_all = new HashMap();
		Map dns = lc.searchDN2Map(baseDn, filter, scope, ids, attributes, dns_all);
		lc.searchDN2Map(role_Dn, scope, ids, attributes, dns_all);
		dns_all.put(CTCB_DN1.toLowerCase(), ctcbDN);
		if (dns == null || dns.size() == 0)
			throw new Exception("No DN found under baseDn '" + baseDn_ + "' with filter '(objectClass=inetOrgPerson)'!");

		int empNum = dns.size();
		System.out.println("###########################Total of employees:" + empNum);
		if (empNum_.trim().length() != 0 && Integer.parseInt(empNum_) <= empNum)
			empNum = Integer.parseInt(empNum_);

		backupFile(outputFile_);
		RandomAccessFile raf = null;
		try {
			// Date date = new Date();

			raf = new RandomAccessFile(new File(outputFile_), "rw");
			Set set1 = dns.keySet();
			Object ob;
			// for(Iterator it1=set1.iterator();it1.hasNext();){
			// ob = it1.next();
			// raf.write((ob.toString()+"=="+(((DNObj)dns.get(ob.toString())).getAttMap()).toString()+System.getProperty("line.separator")).getBytes("UTF-8"));
			// }
			// set1 = dns_all.keySet();
			// for (Iterator it1 = set1.iterator(); it1.hasNext();) {
			// ob = it1.next();
			// raf.write((ob.toString()
			// + "=="
			// + (((DNObj) dns_all.get(ob.toString())).getAttMap())
			// .toString() + System
			// .getProperty("line.separator")).getBytes("UTF-8"));
			// }
			// set1 = attributes.keySet();
			// for (Iterator it1 = set1.iterator(); it1.hasNext();) {
			// ob = it1.next();
			// List list = (List) attributes.get(ob.toString());
			// String ss= ob.toString()+"##";
			// for (int i = 0; i < list.size(); i++) {
			// ss = ss+list.get(i)+",";
			// }
			// raf.write((ss+System.getProperty("line.separator")).getBytes("UTF-8"));
			// }

			// 驗證ap_dn isSuperWhatObject("ctcbApplication", ap_dn）
			// change
			/**
			 * if (!lc.isSuperWhatObject("ctcbApplication", ap_dn)) { throw new Exception("No Such Application Object");
			 * }
			 */
			// Loop: get every user's roles
			Set set = dns.keySet();
			int n = 0;
			DNObj dn;
			for (Iterator it = set.iterator(); it.hasNext() && n < empNum; n++) {
				if (n % 100 == 0) {
					System.out.println(n + "/" + empNum);
				}
				dn = (DNObj) dns.get((String) it.next());
				if (dn == null || dn.getDnName() == null || dn.getDnName().trim().length() == 0)
					continue;

				// get ap dn of role
				DNObj[] role_dns = lc.getUserRolesByAp(ap_dn, dns_all, attributes, dn);

				// test for all the employee attributes
				// System.out.println("$$$$$$$$$$dns["+i+"]"+dns[i].getDN().toString());
				// System.out.print(role_dns.length);
				String[] role = new String[role_dns.length];
				if (role_dns != null) {
					// Loop: get all the roles that the user has
					for (int j = 0; j < role_dns.length; j++) {
						if (role_dns[j] == null)
							continue;
						String roleDn = role_dns[j].getDnName();
						if (roleDn != null && roleDn.trim().length() != 0) {
							// Attributes attrRole = lc.getAttributes(roleDn);
							// if (attrRole != null) {
							// Attribute attrRoleId = attrRole.get("cn");
							// if (attrRoleId != null) {
							// role[j] = (String) attrRoleId.get();
							// }
							// }
							String r = role_dns[j].getFirstValue("cn");
							if (null != r) {
								role[j] = r;
							}
						}
					}
				}

				// get all the employee attributes
				String[] empAttrs = getEmployeeAttrs(dns_all, dn);
				// write employee data file
				if (empAttrs != null && empAttrs.length != 0) {

					if (needbackUp_ != null && needbackUp_.trim().equalsIgnoreCase("true")) {
						String line = "";
						for (int j = 0; j < empAttrs.length; j++) {

							if (j != 0)
								line = line.concat(delimiter_);
							if (!"".equals(empAttrs[j]) && empAttrs[j] != null)
								line = line.concat(empAttrs[j]);

						}
						if (role.length != 0)
							line = line.concat(delimiter_);
						for (int k = 0; k < role.length; k++)
							line = line.concat(role[k]) + ",";

						// test for every employee's dn
						line = line.concat(delimiter_);
						line = line.concat(dn.getDnName().toString());
						raf.write(line.concat(System.getProperty("line.separator")).getBytes("UTF-8"));
					}
					// Date date2 = new Date();
					// reademptime = reademptime+ date2.getTime() -
					// date.getTime();
					// System.out.println("@@@@@@@@@@@read employee
					// -"+reademptime);

					// Date date3 = new Date();

					// to insert data into employee table
					// change
					// if (!updateEmployee.writeDB(empAttrs, n, empNum, role))
					// return false;

					// Date date4 = new Date();
					// writeemptime = writeemptime
					// +date4.getTime()-date3.getTime();
					// System.out.println("@@@@@@@@@@@write employee
					// DB-"+writeemptime);
				}
			}
			// write total number
			raf.write(("Total: " + String.valueOf(empNum)).getBytes("UTF-8"));
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			printException(e);
			System.out.println("Error: " + e.getMessage());
			errorString = e.toString() + "\n";
			return false;
		}

		finally {
			if (raf != null)
				raf.close();
		}
	}

	/**
	 * @description : write LDAP role information into file
	 * @param lc: LDAP connnections
	 */
	private boolean writeRoleFlatFile(NLdapConnection lc) throws Exception {

		if (lc == null)
			return false;

		// role dn
		// change
		String baseDn = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_ROLE_OBJ_DN");
		// String baseDn = "ou=APPs,o=ctcb";
		// String baseDn = "cn=users,DC=test,DC=com";

		String filter = CTCB_ROLE_FILTER;
		int scope = NLdapConnection.SEARCH_SUBTREE_SCOPE;

		DNObj[] dns = lc.searchDN(baseDn, filter, scope, empAttrs_);
		if (dns == null || dns.length == 0)
			throw new Exception("No DN found under baseDn '" + baseDn_ + "' with filter '(objectClass=ctcbRole)'!");

		int empNum = dns.length;
		System.out.println("###########################Total of roles:" + empNum);
		if (empNum2_.trim().length() != 0 && Integer.parseInt(empNum2_) <= empNum)
			empNum = Integer.parseInt(empNum2_);

		// backup current role file
		backupFile(outputFile2_);
		RandomAccessFile raf = null;
		// write new role file
		try {
			raf = new RandomAccessFile(new File(outputFile2_), "rw");
			for (int i = 0; i < empNum; i++) {
				if (dns[i] == null || dns[i].getDnName() == null || dns[i].getDnName().trim().length() == 0)
					continue;
				String[] empAttrs = getNRoleAttrs(dns[i]);

				if (needbackUp_ != null && needbackUp_.trim().equalsIgnoreCase("true")) {
					if (empAttrs != null && empAttrs.length != 0) {
						String line = "";
						for (int j = 0; j < empAttrs.length; j++) {

							if (j != 0)
								line = line.concat(delimiter_);
							if (!"".equals(empAttrs[j]) && empAttrs[j] != null)
								line = line.concat(empAttrs[j]);
						}

						raf.write(line.concat(System.getProperty("line.separator")).getBytes("UTF-8"));
					}
				}

				// Date date2 = new Date();
				// readtime = readtime+ date2.getTime() - date.getTime();
				// System.out.println("@@@@@@@@@@@read role -"+readtime);

				// Date date3 = new Date();
				// change
				// if (!updateEmployee.writeDB(empAttrs, i, empNum))
				// return false;

				// Date date4 = new Date();
				// writetime = writetime +date4.getTime()-date3.getTime();
				// System.out.println("@@@@@@@@@@@write role DB-"+writetime);
			}
			// write total number of role
			raf.write(("Total: " + String.valueOf(empNum)).getBytes("UTF-8"));
			// if (empNum==0){
			// String noRoleRecords = null;
			// noRoleRecords =
			// noRoleRecords.concat(KissConfig.getString("HC_KISS_LDAP",
			// "MSG_ERR_KISS_NO_ROLE_RECORD"));
			// raf.write(noRoleRecords.getBytes("UTF-8"));
			// }
			return true;

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			errorString = e.toString() + "\n";
			return false;
		} finally {
			if (raf != null)
				raf.close();
		}

	}

	private void putDnAttrs(DNObj dn, String[] attrNames, String[] rawAttrNames, HashMap attrs, String[] roles)
			throws Exception {
		if (dn.getDnName() == null || dn.getDnName().trim().length() == 0 || rawAttrNames == null
				|| rawAttrNames.length == 0 || attrNames == null || attrNames.length == 0
				|| attrNames.length != rawAttrNames.length)
			return;
		if (attrs == null)
			attrs = new HashMap();
		// Attributes attrValues = lc.getAttributes(dn);
		// for test all the user's attribute names
		// NamingEnumeration attrValuesTest = attrValues.getAll();
		// while(attrValuesTest.hasMoreElements())
		// System.out.println("@@@@@@@@@@@"+attrValuesTest.nextElement());

		// Loop: get all atrribute values
		for (int i = 0; i < attrNames.length; i++) {
			String value = dn.getFirstValue(rawAttrNames[i]);
			if (null == value) {
				value = "";
			} else {
				value = value.trim();
			}
			// if (attrValues != null && attrValues.get(rawAttrNames[i]) != null
			// && attrValues.get(rawAttrNames[i]).get() != null) {
			// value = attrValues.get(rawAttrNames[i]).get().toString().trim();
			// }
			// get employee values
			if ("cn".equals(attrNames[i])) {
				current_objectID = value;
			}
			attrs.put(attrNames[i], value);
		}
	}

	/**
	 * // get all the department relative information private void putDnRoleAttrs(LdapConnection lc, String dn, String[]
	 * attrNames, String[] rawAttrNames, HashMap attrs, String[] emps) throws Exception { if (lc == null || dn == null
	 * || dn.trim().length() == 0 || rawAttrNames == null || rawAttrNames.length == 0 || attrNames == null ||
	 * attrNames.length == 0 || attrNames.length != rawAttrNames.length) return; if (attrs == null) attrs = new
	 * HashMap(); Attributes attrValues = lc.getAttributes(dn, rawAttrNames);
	 * 
	 * for (int i = 0; i < attrNames.length; i++) { String value = ""; if (attrValues != null &&
	 * attrValues.get(rawAttrNames[i]) != null && attrValues.get(rawAttrNames[i]).get() != null) { value =
	 * attrValues.get(rawAttrNames[i]).get().toString().trim(); } if ("cn".equals(attrNames[i])) { current_objectID =
	 * value; }
	 * 
	 * attrs.put(attrNames[i], value); } }
	 */
	private void putNDnRoleAttrs(DNObj dn, String[] attrNames, String[] rawAttrNames, HashMap attrs) throws Exception {
		if (dn.getDnName() == null || dn.getDnName().trim().length() == 0 || rawAttrNames == null
				|| rawAttrNames.length == 0 || attrNames == null || attrNames.length == 0
				|| attrNames.length != rawAttrNames.length)
			return;
		if (attrs == null)
			attrs = new HashMap();
		for (int i = 0; i < attrNames.length; i++) {
			String value = "";
			value = dn.getFirstValue(rawAttrNames[i]);
			if ("cn".equals(attrNames[i])) {
				current_objectID = value;
			}
			attrs.put(attrNames[i], value);
		}
	}

	// get different level departments(Department, Sub-department, Group)
	private void putDeptDnAttrs(Map dns_all, DNObj dn, String[] attrNames, String[] rawAttrNames, HashMap attrs)
			throws Exception {
		if (dn == null || dn.getDnName() == null || dn.getDnName().trim().length() == 0 || rawAttrNames == null
				|| rawAttrNames.length == 0 || attrNames == null || attrNames.length == 0
				|| attrNames.length != rawAttrNames.length)
			return;
		if (attrs == null)
			attrs = new HashMap();

		String ouString = dn.getDnName().trim();

		String[] ou = ouString.split(",");

		String tempDn = dn.getDnName();
		// Attributes attrValues = lc.getAttributes(tempDn);
		String unitTitle = null;
		String[] ouIDandChineseNames = new String[3];
		ouIDandChineseNames[0] = "";
		ouIDandChineseNames[1] = "";
		ouIDandChineseNames[2] = "";
		// to determine the adscription
		if (isContains(dn.getDnName(), adscriptionCredit, false)) {
			adscription = adscriptionCredit;
		}
		if (isContains(dn.getDnName(), adscriptionRetail, false)) {
			adscription = adscriptionRetail;
		}

		for (int i = 0; i < ou.length; i++) {
			String tempouIDandChineseName = "";
			if (!"".equals(dn.getFirstValue("fullName")) && dn.getFirstValue("fullName") != null
					&& !"".equals(dn.getFirstValue("ou")) && dn.getFirstValue("ou") != null) {
				tempouIDandChineseName = dn.getFirstValue("ou") + "," + dn.getFirstValue("fullName");
			} else if (!"".equals(dn.getFirstValue("ou")) && dn.getFirstValue("ou") != null)
				tempouIDandChineseName = dn.getFirstValue("ou") + "," + "empty name";
			if (!"".equals(dn.getFirstValue("title")) && dn.getFirstValue("title") != null) {
				unitTitle = dn.getFirstValue("title");

				if (unitTitle.startsWith(ldap_devision)) {
					ouIDandChineseNames[0] = tempouIDandChineseName;
				} else if (unitTitle.startsWith(ldap_dept)) {
					ouIDandChineseNames[1] = tempouIDandChineseName;
				} else if (unitTitle.startsWith(ldap_team)) {
					ouIDandChineseNames[2] = tempouIDandChineseName;
				}
			}
			if (!"".equals(dn.getFirstValue("ou")) && dn.getFirstValue("ou") != null)
				tempDn = tempDn.substring(ou[i].length() + 1);
			dn = (DNObj) dns_all.get(tempDn.toLowerCase());
			if (dn == null) {
				System.out.println("not dn=" + tempDn.toLowerCase());
				break;
			}
		}

		attrs.put(attrNames[0], ouIDandChineseNames[0]);
		attrs.put(attrNames[1], ouIDandChineseNames[1]);
		attrs.put(attrNames[2], ouIDandChineseNames[2]);

	}

	private String[] getEmployeeAttrs(Map dns_all, DNObj empDn) throws Exception {
		if (empDn.getDnName() == null || empDn.getDnName().trim().length() == 0)
			return null;
		HashMap attrs = new HashMap();
		// putDnAttrs(lc, empDn, empAttrs_, empAttrs_, attrs);
		putDnAttrs(empDn, empAttrs_, empAttrs_, attrs, roles_);
		adscription = "M00000000";
		DNObj parentDN = null;
		Object obj = dns_all.get(empDn.getParentDNName().toLowerCase());
		if (null != obj) {
			parentDN = (DNObj) obj;
		}
		putDeptDnAttrs(dns_all, parentDN, deptAttrs_, deptRawAttrs_, attrs);
		if (attrs.isEmpty()) {
			throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_EMPATTR_EMPTY"));
			// return null;
		}
		String[] attrValues = new String[empAttrNames_.length + 1];
		for (int i = 0; i < empAttrNames_.length; i++)
			attrValues[i] = (String) attrs.get(empAttrNames_[i]);
		// add adscription into attributes list
		attrValues[empAttrNames_.length] = adscription;
		return attrValues;
	}

	/**
	 * private String[] getRoleAttrs(LdapConnection lc, String empDn) throws Exception { if (lc == null || empDn == null
	 * || empDn.trim().length() == 0) return null; HashMap attrs = new HashMap(); putDnRoleAttrs(lc, empDn, empAttrs_,
	 * empAttrs_, attrs, emps_); if (attrs.isEmpty()) { throw new Exception(KissConfig.getString("HC_KISS_LDAP",
	 * "MSG_ERR_KISS_EMPATTR_EMPTY")); // return null; }
	 * 
	 * String[] attrValues = new String[empAttrNames_.length]; for (int i = 0; i < empAttrNames_.length; i++)
	 * attrValues[i] = (String) attrs.get(empAttrNames_[i]);
	 * 
	 * return attrValues; }
	 */
	private String[] getNRoleAttrs(DNObj dn) throws Exception {
		if (dn.getDnName() == null || dn.getDnName().trim().length() == 0)
			return null;
		HashMap attrs = new HashMap();
		putNDnRoleAttrs(dn, empAttrs_, empAttrs_, attrs);
		if (attrs.isEmpty()) {
			throw new Exception(KissConfig.getString("HC_KISS_LDAP", "MSG_ERR_KISS_EMPATTR_EMPTY"));
			// return null;
		}
		String[] attrValues = new String[empAttrNames_.length];
		for (int i = 0; i < empAttrNames_.length; i++)
			attrValues[i] = (String) attrs.get(empAttrNames_[i]);
		return attrValues;
	}

	private NLdapConnection prepareConnection(String ldapIp, int port) {
		return new NLdapConnection(ldapIp, port);
	}

	private boolean connectLdap(NLdapConnection lc, String baseDn, String id, String pswd) throws Exception {
		try {
			if (lc != null) {
				lc.connect(id, pswd);
				return true;
			} else
				throw new Exception();
		} catch (Exception e) {
			System.out.println("LDAP Connection Error!!!");
			return false;
		}
	}

	/**
	 * determine whether the first string contains the substring。 if return true: contain if return false: not contain
	 * 
	 * @param S1
	 * @param S2
	 * @return
	 */
	public boolean isContains(String sourceString, String subString, boolean ignoreCase) {
		boolean returnValue = (containNumber(sourceString, subString, ignoreCase) > 0) ? true : false;
		return returnValue;
	}

	public int containNumber(String sourceString, String subString, boolean ignoreCase) {
		String tempStr = "";
		int countNumber = 0;
		if (sourceString != null && subString != null && sourceString.length() >= subString.length()) {
			int length = subString.length();
			int endIndex;
			for (int i = 0; i < sourceString.length(); i++) {
				endIndex = (i + length >= sourceString.length()) ? sourceString.length() : i + length;
				tempStr = sourceString.substring(i, endIndex);
				if ((ignoreCase && tempStr.equalsIgnoreCase(subString)) || (!ignoreCase && tempStr.equals(subString))) {
					countNumber++;
					tempStr = "";
					i += length - 1;
				}
			}
		}
		return countNumber;
	}

	// print input arguments
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("########################\n");
		sb.append("#LDAP IP is [" + ldapIp_ + "]\n");
		sb.append("#LDAP PORT is [" + port_ + "]\n");
		sb.append("#BASE DN is [" + baseDn_ + "]\n");
		sb.append("#SERVICE ID is [" + id_ + "]\n");
		sb.append("#Need BackUp is [" + needbackUp_ + "]\n");
		sb.append("#logFile is [" + logFile_ + "]\n");
		sb.append("#employee outputFile is [" + outputFile_ + "]\n");
		sb.append("#role outputFile is [" + outputFile2_ + "]\n");
		sb.append("#delimiter is [" + delimiter_ + "]\n");
		if (empAttrNames_ != null)
			for (int i = 0; i < empAttrNames_.length; i++)
				sb.append("#empAttrNames is [" + empAttrNames_[i] + "]\n");
		if (empAttrs_ != null)
			for (int i = 0; i < empAttrs_.length; i++)
				sb.append("#empAttrs is [" + empAttrs_[i] + "]\n");
		if (deptAttrs_ != null)
			for (int i = 0; i < deptAttrs_.length; i++)
				sb.append("#deptAttrs is [" + deptAttrs_[i] + "]\n");
		sb.append("########################");
		return sb.toString();
	}

	// main method
	public static void main(String[] s) {
		String ss = "192.168.31.40;389;o=ctcb;ou=CSKS,ou=APPs,o=ctcb;3EDC1QAZ;true;output/log.txt;output/CTCB-employees.txt;40000;output/CTCB-roles.txt;200;/;cn;fullName;title;DEPT_ou=D;DEPT_ou=T;DEPT_ou=S;member";
		ss = "192.168.31.40;389;o=ctcb;ou=CSKS,ou=APPs,o=ctcb;3EDC1QAZ;true;output/log.txt;output/CTCB-employees.txt;40000;output/CTCB-roles.txt;200;/;cn;fullName;title;DEPT_ou=D;DEPT_ou=T;DEPT_ou=S;mail;member";
		s = ss.split(";");
		System.out.println("start time" + new Date());
		// String [] s =
		// "192.168.31.40;389;o=ctcb;ou=CSKS,ou=APPs,o=ctcb;3EDC1QAZ;true;
		// ;c:\\\\log_emp.txt;200;c:\\\\log_role.txt;200;/;cn;fullName;title;DEPT_ou=D;DEPT_ou=T;DEPT_ou=S;member".split(";");
		// change
		// String [] s =
		// "10.5.17.101;389;DC=test,DC=com;cn=hlj,cn=users,DC=test,DC=com;Password1;true;
		// ;d:/output/CTCB-employees.txt;200;d:/output/CTCB-roles.txt;50;/;cn;fullName;title;DEPT_ou=D;DEPT_ou=T;DEPT_ou=S;member".split(";");
		if (s == null || s.length < INPUT_EMPLOYEE_ATTRIBUTE_NUMBER + 1) {
			System.err.println("################Usage################");
			System.err.println("#java -cp bizLdap1.2_ctcb.jar com.ctcb.kiss.LDAP.KISSGetEmployeefromNewLdap ");
			System.err.println("################End of Usage################");

			return;
		}
		String ldapIp = s[0];
		String port = s[1];
		String baseDn = s[2];
		String id = s[3];
		String pswd = s[4];
		String needbackUp = s[5];
		String logFile = s[6];
		String outputFile = s[7];
		String empNum = s[8];

		// LDAP output data file name
		String outputFile2_ = s[9];
		// the max number of records getting from LDAP
		String empNum2_ = s[10];

		String delimiter = s[11];

		int attrNum = s.length - INPUT_EMPLOYEE_ATTRIBUTE_NUMBER;
		String[] empAttrNames = new String[attrNum];
		for (int i = 0; i < attrNum; i++) {
			empAttrNames[i] = s[INPUT_EMPLOYEE_ATTRIBUTE_NUMBER + i];
		}

		KISSGetEmployeefromNewLdapTestAIX instance = new KISSGetEmployeefromNewLdapTestAIX(ldapIp, port, baseDn, id,
				pswd, needbackUp, logFile, outputFile, empNum, outputFile2_, empNum2_, delimiter, empAttrNames);

		try {
			// start
			instance.run2();
		} catch (Exception e) {
			// write exception log file
			instance.logException(e);
			// if fail to write the file, write error info into log file
			if (new File(logFile).exists())
				System.out.println("Process Failed. Check file [" + logFile + "] for log!");
		}
		System.out.println("end time" + new Date());
	}

	public static void printException(Exception e) {
		StackTraceElement[] s = e.getStackTrace();
		for (int i = 0; i < s.length; i++) {
			System.out.println("Exception:" + s[i].toString());
		}
	}

	public void run2() throws Exception {
		NLdapConnection lc = null;
		Connection dbconn = null;
		try {
			// check and get the input parametters
			System.out.println("gogogo1168");
			isReady();
			System.out.println("gogogo1170");
			// backup the current data file before rewrite
			backupFile(logFile_);
			System.out.println("gogogo1173");
			// create a new LDAP connection
			lc = prepareConnection(ldapIp_, Integer.parseInt(port_.trim()));
			// connect LDAP
			System.out.println(id_);
			System.out.println(pswd_);
			if (!connectLdap(lc, baseDn_, id_, pswd_))
				return;
			// connect DB for writing LDAP data into file and DB
			// change
			System.out.println("gogogo1181");
			// dbconn = updateEmployee.getConnection();
			dbconn = null;
			if (dbconn == null)
				return;
			System.out.println(dbconn);

			// write LDAP data into role, employeerole and privilegerole table
			// change
			if (!writeRoleFlatFile2(lc))
				throw new Exception();

			// write LDAP data into Employee table if data is correct
			if (!writeFlatFile2(lc))
				throw new Exception();

			// if succeed, write data to output file
			System.out.println("Process Succeeded. ");
			System.out.println("Check file [" + outputFile_ + " and " + outputFile2_ + "] for output!");
			System.out.println("Check DB for updated User/Role/User-Role/Role-Privilege tables!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			// disconnect LDAP
			if (lc != null)
				lc.disconnect();

			if (dbconn != null) {
			}
			// updateEmployee.closeConnection();
		}
	}

	private boolean writeFlatFile2(NLdapConnection lc) throws Exception {
		if (lc == null)
			return false;
		String baseDn = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_EMPLOYEE_OBJ_DN");
		String role_Dn = "ou=APPs,o=CTCB";
		String filter = CTCB_EMP_FILTER;
		int scope = NLdapConnection.SEARCH_SUBTREE_SCOPE;// 2
		// 這里要加String ids[]，要取得的屬性。
		String[] ids = new String[empAttrs_.length + CTCB_EMP_IDS.length];
		for (int i = 0; i < empAttrs_.length + CTCB_EMP_IDS.length; i++) {
			if (i < empAttrs_.length) {
				ids[i] = empAttrs_[i];
			} else {
				ids[i] = CTCB_EMP_IDS[i - empAttrs_.length];
			}
		}
		DNObj ctcbDN = lc.getAttributes(CTCB_DN1, CTCB_EMP_IDS);
		Map attributes = new HashMap();
		Map dns_all = new HashMap();
		Map dns = lc.searchDN2Map(baseDn, filter, scope, ids, attributes, dns_all);
		lc.searchDN2Map(role_Dn, scope, ids, attributes, dns_all);
		dns_all.put(CTCB_DN1.toLowerCase(), ctcbDN);
		if (dns == null || dns.size() == 0)
			throw new Exception("No DN found under baseDn '" + baseDn_ + "' with filter '(objectClass=inetOrgPerson)'!");

		int empNum = dns.size();
		System.out.println("###########################Total of employees:" + empNum);
		if (empNum_.trim().length() != 0 && Integer.parseInt(empNum_) <= empNum)
			empNum = Integer.parseInt(empNum_);

		backupFile(outputFile_);
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(new File(outputFile_), "rw");
			Set set1 = dns.keySet();
			Object ob;
			// Loop: get every user's roles
			Set set = dns.keySet();
			int n = 0;
			DNObj dn;
			for (Iterator it = set.iterator(); it.hasNext() && n < empNum; n++) {
				if (n % 100 == 0) {
					System.out.println(n + "/" + empNum);
				}
				dn = (DNObj) dns.get((String) it.next());
				if (dn == null || dn.getDnName() == null || dn.getDnName().trim().length() == 0)
					continue;

				// get ap dn of role
				DNObj[] role_dns = lc.getUserRolesByAp(ap_dn, dns_all, attributes, dn);

				String[] role = new String[role_dns.length];
				if (role_dns != null) {
					for (int j = 0; j < role_dns.length; j++) {
						if (role_dns[j] == null)
							continue;
						String roleDn = role_dns[j].getDnName();
						if (roleDn != null && roleDn.trim().length() != 0) {
							String r = role_dns[j].getFirstValue("cn");
							if (null != r) {
								role[j] = r;
							}
						}
					}
				}
				if (dn.getDnName().indexOf("Z00006553") >= 0) {
					System.out.println("ininin");
				}

				// get all the employee attributes
				String[] empAttrs = getEmployeeAttrs(dns_all, dn);
				// write employee data file
				if (empAttrs != null && empAttrs.length != 0) {

					if (needbackUp_ != null && needbackUp_.trim().equalsIgnoreCase("true")) {
						String line = "";
						for (int j = 0; j < empAttrs.length; j++) {

							if (j != 0)
								line = line.concat(delimiter_);
							if (!"".equals(empAttrs[j]) && empAttrs[j] != null)
								line = line.concat(empAttrs[j]);

						}
						if (role.length != 0)
							line = line.concat(delimiter_);
						for (int k = 0; k < role.length; k++)
							line = line.concat(role[k]) + ",";

						// test for every employee's dn
						line = line.concat(delimiter_);
						line = line.concat(dn.getDnName().toString());
						raf.write(line.concat(System.getProperty("line.separator")).getBytes("UTF-8"));
					}
				}
			}
			// write total number
			raf.write(("Total: " + String.valueOf(empNum)).getBytes("UTF-8"));
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			printException(e);
			System.out.println("Error: " + e.getMessage());
			errorString = e.toString() + "\n";
			return false;
		}

		finally {
			if (raf != null)
				raf.close();
		}
	}

	private boolean writeRoleFlatFile2(NLdapConnection lc) throws Exception {

		if (lc == null)
			return false;
		String baseDn = KissConfig.getString("HC_KISS_LDAP", "KISS_LDAP_ROLE_OBJ_DN");

		String filter = CTCB_ROLE_FILTER;
		int scope = NLdapConnection.SEARCH_SUBTREE_SCOPE;

		DNObj[] dns = lc.searchDN(baseDn, filter, scope, empAttrs_);
		if (dns == null || dns.length == 0)
			throw new Exception("No DN found under baseDn '" + baseDn_ + "' with filter '(objectClass=ctcbRole)'!");

		int empNum = dns.length;
		System.out.println("###########################Total of roles:" + empNum);
		if (empNum2_.trim().length() != 0 && Integer.parseInt(empNum2_) <= empNum)
			empNum = Integer.parseInt(empNum2_);

		// backup current role file
		backupFile(outputFile2_);
		RandomAccessFile raf = null;
		// write new role file
		try {
			raf = new RandomAccessFile(new File(outputFile2_), "rw");
			for (int i = 0; i < empNum; i++) {
				if (dns[i] == null || dns[i].getDnName() == null || dns[i].getDnName().trim().length() == 0)
					continue;
				String[] empAttrs = getNRoleAttrs(dns[i]);

				if (needbackUp_ != null && needbackUp_.trim().equalsIgnoreCase("true")) {
					if (empAttrs != null && empAttrs.length != 0) {
						String line = "";
						for (int j = 0; j < empAttrs.length; j++) {

							if (j != 0)
								line = line.concat(delimiter_);
							if (!"".equals(empAttrs[j]) && empAttrs[j] != null)
								line = line.concat(empAttrs[j]);
						}

						raf.write(line.concat(System.getProperty("line.separator")).getBytes("UTF-8"));
					}
				}
				// if (!updateEmployee.writeDB(empAttrs, i, empNum))
				// return false;
			}
			// write total number of role
			raf.write(("Total: " + String.valueOf(empNum)).getBytes("UTF-8"));
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			errorString = e.toString() + "\n";
			return false;
		} finally {
			if (raf != null)
				raf.close();
		}

	}
}