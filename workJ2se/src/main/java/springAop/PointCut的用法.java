package springAop;

import org.aspectj.lang.annotation.Pointcut;

//未測試，先寫一下記錄
public class PointCut的用法 {
    /*
     execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     我想是上面是指 修飾詞(可省略) 回傳型別 package類別(可省略).Method名字(參數) 例外類別(可省略)
     */

    //execution是指向method的
    @Pointcut("execution(public * *(..))")
    public void 全部的公開方法() {
    }

    @Pointcut("execution(* set*(..))")
    public void 全部的setMethod() {
    }

    @Pointcut("execution(* aaa.bbb.Xxx.*(..))")
    public void Xxx類別的全部Method() {
    }

    //如果一個.就只有往下找單層，2個.才找多層
    @Pointcut("execution(* aaa..*.*(..))")
    public void aaa套件下全部的Method() {
    }

    //複合2個pointCut，好像目前看到的實作都是無內容的，實作應該不會有什麼大影嚮吧
    @Pointcut("全部的公開方法() && 全部的setMethod()")
    public void 複合2個pointCut() {

    }


    //within是指向class的，可套用到類別或是介面
    @Pointcut("within(bb.*)")
    public void bbPackage層中全部的類別() {

    }

    @Pointcut("within(bb..*)")
    public void bbPackage下面多層全部的類別() {

    }

    //我猜只能寫完整路徑的介面，不能用*之類的pattern
    //this的pointcut是proxy類別，我猜是指如果Ccc的孫類別要有override Ccc才行
    @Pointcut("this(a.b.Ccc)")
    public void 任何實作Ccc介面的Proxy物件() {

    }

    //我猜和this差不多，只是孫子輩不用override也行
    @Pointcut("target(a.b.Ccc)")
    public void 任何實作Ccc介面的物件() {

    }

    @Pointcut("args(java.io.Serializable)")
    public void 任何有單一參數可序列化的method() {
    }

    @Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
    public void 任何物件Instance有此annotation() {

    }

    @Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
    public void 任何類別Type上有此annotation() {

    }

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void 任何Method有此annotation() {

    }

    @Pointcut("@arg(aaa.bbb.ccc.DddAnnotation)")
    public void 單一參數而且有此DddAnnotation的Method() {

    }

    @Pointcut("bean(xxxService)")
    public void 在spring中為id為xxxService的Bean() {

    }

    @Pointcut("bean(*Service)")
    public void 在spring中id結尾為Service的Bean() {

    }

}
