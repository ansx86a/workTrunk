package junit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

import controller.第一個Controller;
import controller.第一個Service;

//預設值"file:src/main/webapp
@WebAppConfiguration
// @ContextConfiguration("/junit/root-context.xml")
// @ContextConfiguration(locations={"/app-config.xml", "/test-config.xml"})
// 上面二個或下面這一個選一個來用即可
// @ContextHierarchy({ @ContextConfiguration("/root-context.xml"), @ContextConfiguration("/web-context.xml") })
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:web-context.xml" })
// 這裡用runwith和繼承AbstractJUnit4SpringContextTests都能跑
// @RunWith(SpringJUnit4ClassRunner.class)
public class MvcTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	第一個Controller controller;
	@Autowired
	第一個Service service;
	@Autowired
	WebApplicationContext wac; // cached
	@Autowired
	MockServletContext servletContext; // cached
	@Autowired
	MockHttpSession session;
	@Autowired
	MockHttpServletRequest request;
	@Autowired
	MockHttpServletResponse response;
	@Autowired
	ServletWebRequest webRequest;

	@Test
	public void 一般的serviceMock測試2() {
		// 因為是單一thread的，這邊的request不會蓋來蓋去，多個thread就會出問題了嗎？？？
		System.out.println(request.getAttribute("123") + "--" + Thread.currentThread().getId());
		request.setAttribute("123", "test2");

	}

	@Test
	public void 一般的serviceMock測試() {
		System.out.println("test1");
		// 這個也可以
		// MockHttpServletRequest request = new MockHttpServletRequest();
		System.out.println(request.getAttribute("123") + "--" + Thread.currentThread().getId());
		request.setAttribute("123", "test1");
		// Utils.setRequest(request);
		// service.最簡單的select();
		controller.test1(request, response);
	}

	// 再來是mvc的模擬測試
	private MockMvc mockMvc;

	@Before
	public void setup() {
		System.out.println("create mvc*****************************");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testMvc() throws Exception {
		System.out.println("=====測試MVC============================");
		// this.mockMvc.perform(get("/test001.mvc").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		// .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
		// .andExpect(jsonPath("$.name").value("Lee"));
		MockHttpServletRequestBuilder b = get("/unitTest1.mvc");
		b.accept("application/json;charset=UTF-8");
		b.param("form1", "formValue1");
		b.param("form2", "formValue2");
		b.param("form3", "formValue31", "formValue32");
		ResultActions r = this.mockMvc.perform(b);

		r.andExpect(status().isOk());
		// 這邊的contentType要寫和controller的一樣，有沒有utf-8有差
		r.andExpect(content().contentType("application/json;charset=utf-8"));
		r.andExpect(jsonPath("$.name").value("中文名字"));
		// 參照org.hamcrest.CoreMatchers物件來了解jsonPath的用法
		r.andExpect(jsonPath("$.name", containsString("文名")));
		// jsonPath ex：
		// $.store.book[0].title
		// $['store']['book'][0]['title']
		// $ 根对象
		// $[-1] 最后元素
		// $[:-2] 第1个至倒数第2个
		// $[1:] 第2个之后所有元素
		// $[1,2,3] 集合中1,2,3个元素

		// ===取得request
		System.out.println(r.andReturn().getRequest().getAttribute("test"));
		System.out.println("=====測試MVCend============================");
	}

}
