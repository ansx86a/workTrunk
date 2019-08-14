package bean.orika;

import java.util.ArrayList;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

public class 基本例子 {

    static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Test
    public void $1基本映射() {
        System.out.println("==================================");
        Person p = this.getPerson();

        // 有名字不一樣的，要輸入field，其它一樣的就用byDefault就可以了
        // register照理說只要設定一次就可以了，不用method每次重設
        mapperFactory.classMap(Person.class, OtherPerson.class)//
                .field("firstName", "otherFirstName")//
                .field("lastName", "otherLastName")//
                .field("skill", "otherSkill")//
                .byDefault().register();//

        OtherPerson op = mapperFactory.getMapperFacade().map(p, OtherPerson.class);
        System.out.println("==================================");
        System.out.println(ToStringBuilder.reflectionToString(p));
        System.out.println(ToStringBuilder.reflectionToString(op));
        System.out.println("==================================");
        // 以上的寫法，是以1對1來說的寫法，每次都要傳入source傳數
        // 如果要寫成1對多的話，可用以下的寫法，少帶入source傳，基本上差不多
        BoundMapperFacade<Person, OtherPerson> boundMapper = mapperFactory.getMapperFacade(Person.class,
                OtherPerson.class);

        OtherPerson op2 = boundMapper.map(p);
        System.out.println(ToStringBuilder.reflectionToString(op2));

        boundMapper.map(p, op2);// 也可以用map來copy到原來的物件，預防有物件建構子的問題
        p = boundMapper.mapReverse(op);// 反相映射回去
        boundMapper.mapReverse(op2, p);// 反相映射，Object放的順序有變，因為前面都放source

    }

    @Test
    public void $2基本映射2() {
        mapperFactory.classMap(Person.class, OtherPerson.class)//
                //映射是雙向的，fieldAToB是不是就變單向了呢？
                .fieldAToB("firstName", "otherFirstName")// 左邊映射到右邊
                //暫時註解fieldBToA，拿掉這一行之後，exclude age就正常了不會有下面註解的問題
                //.fieldBToA("otherLastName", "lastName")// 右邊映射到左邊，只是改寫法順序而已
                .field("skill", "otherSkill")//
                .exclude("address")// 不要映射，怎麼age寫了反而會映射呢，但是address就正常，怪怪
                .exclude("age")// 就算age 由int改成integer仍然試不出來，沒default時有寫反而會映射出來，怪怪
                .byDefault()//
                .register();//

        Person p = this.getPerson();
        OtherPerson op = mapperFactory.getMapperFacade().map(p, OtherPerson.class);

        System.out.println(ToStringBuilder.reflectionToString(p));
        System.out.println(ToStringBuilder.reflectionToString(op));
    }

    @Test
    public void $3建構子映射() {
        // 不懂，沒試出來
        Person p = this.getPerson();
        mapperFactory.classMap(Person.class, OtherPerson.class)//
                .constructorB("firstName", "lastName", "age")//
                .register();//
        OtherPerson op = mapperFactory.getMapperFacade().map(p, OtherPerson.class);
        System.out.println(ToStringBuilder.reflectionToString(p));
        System.out.println(ToStringBuilder.reflectionToString(op));

    }

    @Test
    public void $4物件轉成對陣列的映射() {
        Person p = this.getPerson();
        mapperFactory.classMap(Person.class, OtherPerson.class)//
                .field("firstName", "otherSkill[0]")//數字是插入的位置，有夠特別的
                .field("lastName", "otherSkill[0]")//
                .field("address", "otherSkill[0]")//
                .register();//
        OtherPerson op = mapperFactory.getMapperFacade().map(p, OtherPerson.class);
        System.out.println(ToStringBuilder.reflectionToString(p));
        System.out.println(ToStringBuilder.reflectionToString(op));

    }

    public Person getPerson() {
        Person p = new Person();
        p.setFirstName("firstName");
        p.setLastName("lastName");
        p.setAddress("address");
        p.setAge(18);
        ArrayList<String> list = new ArrayList<>();
        list.add("skll1");
        list.add("skll2");
        list.add("skll3");
        p.setSkill(list);
        return p;
    }

    public OtherPerson getOtherPerson() {
        OtherPerson p = new OtherPerson();
        p.setOtherFirstName("otherFirstName");
        p.setOtherLastName("otherLastName");
        p.setAddress("address");
        p.setAge(30);
        ArrayList<String> list = new ArrayList<>();
        list.add("skll1");
        list.add("skll2");
        list.add("skll3");
        p.setOtherSkill(list);
        return p;
    }
}
