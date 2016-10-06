package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Customer;
import model.input.MyInput;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tool.ThreadLocalUtils;

import com.github.pagehelper.PageHelper;

import dao.CustomerMapperExt;

@Service
public class 第二個Service {

	@Autowired
	private CustomerMapperExt customerMapperExt;

	public void caseWhen的應用() {

		List<HashMap> list = customerMapperExt.caseWhen的應用();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		ThreadLocalUtils.getRequest().setAttribute("test2",
				list.get(0) + "<br>" + list.get(1) + "<br>" + list.get(2) + "<br>");
	}

	public void 動態sqlIf() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		List<HashMap> list = customerMapperExt.動態sqlIf(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCompanyname("公司2");
		List<HashMap> list2 = customerMapperExt.動態sqlIf(c2);
		System.out.println(list2.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list2.get(0));
	}

	public void 動態sqlCaseWhen() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		// other
		List<HashMap> list3 = customerMapperExt.動態sqlCaseWhen(c);
		System.out.println(list3.get(0));
		// 不能用=，會被當成運算符號
		c.setFax("equal");
		List<HashMap> list = customerMapperExt.動態sqlCaseWhen(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCustomerid("ANAT_");
		// 不能設%，會被當做運算符號
		c2.setFax("百分比");
		List<HashMap> list2 = customerMapperExt.動態sqlCaseWhen(c2);
		System.out.println(list2.get(0));
		ThreadLocalUtils.getRequest()
				.setAttribute("test2", list.get(0) + "<br>" + list2.get(0) + "<br>" + list3.get(0));
	}

	public void 動態sqlIf去化where1等於1() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		List<HashMap> list = customerMapperExt.動態sqlIf去化where1等於1(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCompanyname("公司2");
		List<HashMap> list2 = customerMapperExt.動態sqlIf去化where1等於1(c2);
		System.out.println(list2.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list2.get(0));
	}

	public void 動態sqlIf去化結尾的逗號() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		String newAddress = "address" + System.currentTimeMillis() % 1000;
		c.setAddress(newAddress);
		System.out.println(newAddress);
		int result = customerMapperExt.動態sqlIf去化結尾的逗號(c);
		System.out.println(result);
		ThreadLocalUtils.getRequest().setAttribute("test2", result);
	}

	public void 動態sqlIf內部參數組合Class() {
		Customer c = new Customer();
		c.setCustomerid("ANAT");
		List<HashMap> list = customerMapperExt.動態sqlIf內部參數組合Class(c);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 動態sqlIf內部參數組合Map() {
		HashMap c = new HashMap();
		c.put("customerid", "ALFK");
		List<HashMap> list = customerMapperExt.動態sqlIf內部參數組合Map(c);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 動態sqlForEachMap() {
		HashMap c = new HashMap();
		ArrayList<String> list = new ArrayList<>();
		list.add("ALFKI");
		list.add("ANATR");
		c.put("一堆id資料list", list);

		List<HashMap> list2 = customerMapperExt.動態sqlForEachMap(c);
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		ThreadLocalUtils.getRequest().setAttribute("test2", "" + list2.get(0) + "\r\n" + list2.get(1));
	}

	public void 動態sqlForEachClass() {
		MyInput c = new MyInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("ALFKI");
		list.add("ANATR");
		c.setList1(list);
		List<HashMap> list2 = customerMapperExt.動態sqlForEachClass(c);
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		ThreadLocalUtils.getRequest().setAttribute("test2", "" + list2.get(0) + "\r\n" + list2.get(1));
	}

	public void 多種db支援1() {
		int result = customerMapperExt.多種db支援1();
		System.out.println(result);
		ThreadLocalUtils.getRequest().setAttribute("test2", result);
	}

	public void 多種db支援2() {
		int result = customerMapperExt.多種db支援2();
		System.out.println(result);
		ThreadLocalUtils.getRequest().setAttribute("test2", result);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void 測試交易() {
		// 以下是一個update的交易，會update地扯
		動態sqlIf去化結尾的逗號();
		if (System.currentTimeMillis() % 2 == 0) {
			System.out.println("exception");
			ThreadLocalUtils.getRequest().setAttribute("test2", "交易失敗");
			throw new RuntimeException("這裡故意錯誤測試rollback");
		} else {
			System.out.println("ok");
			ThreadLocalUtils.getRequest().setAttribute("test2", "交易ok");
		}
	}

	public void 預存程序帶參數的Select() {
		HashMap map = new HashMap();
		map.put("參數1", "Beverages");
		List<HashMap> list = customerMapperExt.預存程序帶參數的Select(map);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 邏輯分頁() {
		// 第幾筆開始，捉幾筆
		RowBounds r = new RowBounds(3, 5);// 第index 3(第4筆)筆開始捉5筆
		// 注意，如果導入了物理分頁，這裡會變成第3頁(因為plugin設了offsetAsPageNum)，每頁5筆，另外物理分頁都必須要有order by 怪怪
		// 另外如果用spring導入plugin(因為plugin沒設了offsetAsPageNum)，就又回復正常的第index 3(第4筆)筆開始捉5筆

		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", "%a%");
		List<HashMap> result = customerMapperExt.邏輯分頁(r, map);
		System.out.println(result);
		StringBuffer html = new StringBuffer();
		result.forEach(o -> {
			System.out.println(o);
			html.append("" + o + "<br>");
		});
		ThreadLocalUtils.getRequest().setAttribute("test2", html.toString());
	}

	public void 物理分頁() {
		// 物理分頁的方法1是直接套用本來的RowBounds，就會從邏輯分頁變成物理分頁，但是變數代表的意義會變，而且一定要加order by
		// 方法2就是加入靜態呼叫，我反極不太喜歡這種用法，我會怕同步的問題
		PageHelper.startPage(1, 5);
		List<HashMap> result = customerMapperExt.caseWhen的應用();
		// 注意一般的hashmap會多一個序號的值，但是resultmap有封裝成物件，就會失去序號值
		System.out.println(result);
		StringBuffer html = new StringBuffer();
		result.forEach(o -> {
			System.out.println(o);
			html.append("" + o + "<br>");
		});
		// 注PageInfo 可以把result的包起來wrap成一個另外使用的物件，類似 page.isHasNextPage()等方式可以用，不太考慮用
		ThreadLocalUtils.getRequest().setAttribute("test2", html.toString());
	}

	public void testPager() {
		// http://www.hifreud.com/2015/03/06/mybatis-7-Pagination/

		// https://github.com/miemiedev/mybatis-paginator
	}
}
