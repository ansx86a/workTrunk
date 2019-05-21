package bean.free.bulider;

/**
 * <pre>
 * 也許和auto value衝到，目前用起來沒有很順
 * 一開始用maven+update project會長出來，後來就又不見了
 * 所以我才會認為和auto value有衝到
 * 
 * In your projects properties dialog, go to Java Compiler > Annotation Processing 
 * and ensure Enable annotation processing is checked. Next, 
 * go to Java Compiler > Annotation Processing > Factory Path, select Add JARs,
 *  and select the FreeBuilder JAR.
 * 
 * 
 * </pre>
 * 
 * @author ai
 *
 */

//@FreeBuilder
public interface Person {
    /** Returns the person's full (English) name. */
    String name();

    /** Returns the person's age in years, rounded down. */
    int age();

//    class Builder extends Person_Builder {
//
//    }
}