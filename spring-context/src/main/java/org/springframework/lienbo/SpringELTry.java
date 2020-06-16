package org.springframework.lienbo;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/6/1 10:45 上午
 * @version: v1.0
 */
public class SpringELTry {

	private static final ExpressionParser parser = new SpelExpressionParser();

	private static User user = new User();

	static {
		user.setList(Arrays.asList(2, 3, 4));
		user.setName("Lienbo");
		user.setIntarr(new int[]{1, 2, 3});
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "MAP");
		user.setMap(map);
	}
	/**
	 * 注入多个变量
	 *
	 * @param expr #{#shopId}.#{#typeId}.#{#paging.page}
	 * @param map
	 * @return
	 */
	public static String readExpr(String expr, Map<String, Object> map) {
		Expression expression = parser.parseExpression(expr, new TemplateParserContext());

		EvaluationContext context = new StandardEvaluationContext();

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			context.setVariable(entry.getKey(), entry.getValue());
		}

		return expression.getValue(context, String.class);
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Expression expression =
				parser.parseExpression("name");
		Object value = expression.getValue(user);
		System.out.println("value = " + value);
	}


	// 解析properties
	public  static void test1()
	{
		Expression expression =
				// parser.parseExpression("props.getProperty(\"name\")");
				parser.parseExpression("props[name]");
		String value = expression.getValue(user, String.class);
		System.out.println(value);
	}

	// 解析arrays
	public static void test2()
	{
		Expression expression = parser.parseExpression("intarr[1]");
		Integer intvalue = expression.getValue(user, int.class);
		System.out.println(intvalue);
	}


	// 解析lists和indexers(索引器)
	public static void test3()
	{
		// 测试lists
		Expression expression = parser.parseExpression("list.get(0)");
		Integer intvalue = expression.getValue(user, Integer.class);
		System.out.println(intvalue);
		// 测试indexers(索引器)
		Expression expression2 = parser.parseExpression("list[1]");
		System.out.println("expression2 = " + expression2.getValue(user, Integer.class));
		System.out.println(user.list);
	}

	// 测试maps
	public static void test4()
	{
		// 采用indexers(索引器)的方式访问.
		Expression expression = parser.parseExpression("map[1]");
		String value = expression.getValue(user, String.class);
		System.out.println(value);
	}


	// spel的内部初始化,inner lists和inner maps
	// 使用符号{value}和{key:value},多元素以符号`,`间隔.
	public void test5()
	{
		// inner lists
		Expression expression =
				parser.parseExpression("{'jack','rose','lili'}");
		List<?> list = expression.getValue(user, List.class);
		System.out.println(list);
		// inner maps
		Expression expression2 =
				parser.parseExpression("{0:'jack',1:'rose',2:'lili'}");
		Map<?, ?> map = expression2.getValue(user, Map.class);
		System.out.println(map);
	}

	// 使用数组的构造器
	public void test6()
	{
		// 还可以使用其他创建形式
		// new int[num]
		// new int[num0][num1]
		Expression expression = parser.parseExpression("new int[]{1,2,3,4,5}");
		int[] intarr = expression.getValue(user, int[].class);
		System.out.println(Arrays.toString(intarr));
	}

}
