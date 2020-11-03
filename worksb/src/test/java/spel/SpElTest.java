package spel;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public class SpElTest {
    private String name = "name1";
    private int age = 18;
    private List<String> list;

    @Test
    public void 簡單的直接測試() {
        ExpressionParser parser = new SpelExpressionParser();
        ;
        System.out.println(parser.parseExpression("'Hello World'").getValue());
        System.out.println(parser.parseExpression("'Hello World'.bytes").getValue());
        System.out.println(parser.parseExpression("'Hello World'.bytes.length").getValue());
        System.out.println(parser.parseExpression("'Hello World'.bytes[0]").getValue());
        //System.out.println(parser.parseExpression("'Hello World'.bytes[999]").getValue());//SpelEvaluationException

    }

    @Test
    public void 有root物件的測試() {
        ExpressionParser parser = new SpelExpressionParser();
        SpElTest spElTest = new SpElTest();
        EvaluationContext context = new StandardEvaluationContext(spElTest);
        //直接使用Object和Context的結果相同，所以預設就是會幫你使用StandardEvaluationContext
        System.out.println(parser.parseExpression("name").getValue(spElTest));
        System.out.println(parser.parseExpression("age").getValue(spElTest));
        System.out.println(parser.parseExpression("name").getValue(context));
        System.out.println(parser.parseExpression("age").getValue(context));
        System.out.println(parser.parseExpression("name == 'name1'").getValue(context));
        System.out.println(parser.parseExpression("age == 18").getValue(context));
        //利用泛型可以保證回傳的型咷不需要強轉型
        boolean result = parser.parseExpression("age == 18").getValue(context, Boolean.class);
        System.out.println(result);
    }

    @Test
    public void 設值() {
        ExpressionParser parser = new SpelExpressionParser();
        SpElTest spElTest = new SpElTest();
        EvaluationContext context = new StandardEvaluationContext(spElTest);
        parser.parseExpression("age").setValue(context,19);
        System.out.println(spElTest.age);
    }
    @Test
    public void 自動new物件List並填到指定位置元素(){
        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(configuration);
        SpElTest spElTest = new SpElTest();
        Expression expression = parser.parseExpression("list[3]");
        expression.getValue(spElTest);//要跑這一行才行
        System.out.println(spElTest.list);//[, , , ]，三個空字吧也不是null
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
