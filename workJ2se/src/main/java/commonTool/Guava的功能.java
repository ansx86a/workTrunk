package commonTool;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class Guava的功能 {

    public static void main(String a[]) {
        // http://ifeve.com/google-guava/
        // http://www.codedata.com.tw/java/guava-tutorial-1-getting-started
        // http://ifeve.com/google-guava-collectionutilities/

        // 建議看一下Guava，好像有蠻多簡單的寫法
    }

    @Test
    public void $1() {
        //立用pair的特性，也可是等於使用table，或是拓展table到6個key？
        Pair p = Pair.of("A", "B");
        System.out.println(p.hashCode());


        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        int seatCount
                = universityCourseSeatTable.get("Mumbai", "IT");
        System.out.println(seatCount);
        Integer seatCountForNoEntry
                = universityCourseSeatTable.get("Oxford", "IT");
        System.out.println(seatCountForNoEntry);


    }

    @Test
    public void givenTable_whenContains_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        boolean entryIsPresent
                = universityCourseSeatTable.contains("Mumbai", "IT");
        boolean courseIsPresent
                = universityCourseSeatTable.containsColumn("IT");
        boolean universityIsPresent
                = universityCourseSeatTable.containsRow("Mumbai");
        boolean seatCountIsPresent
                = universityCourseSeatTable.containsValue(60);

    }

    @Test
    public void givenTable_whenRemove_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);

        int seatCount
                = universityCourseSeatTable.remove("Mumbai", "IT");
        //remove回傳value，沒remove到回傳null

    }

    @Test
    public void givenTable_whenColumn_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Integer> universitySeatMap
                = universityCourseSeatTable.column("IT");

        //assertThat(universitySeatMap).hasSize(2);
        //assertThat(universitySeatMap.get("Mumbai")).isEqualTo(60);
        //assertThat(universitySeatMap.get("Harvard")).isEqualTo(120);
    }

    @Test
    public void givenTable_whenColumnMap_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Map<String, Integer>> courseKeyUniversitySeatMap
                = universityCourseSeatTable.columnMap();

        //assertThat(courseKeyUniversitySeatMap).hasSize(3);
        //assertThat(courseKeyUniversitySeatMap.get("IT")).hasSize(2);
        //assertThat(courseKeyUniversitySeatMap.get("Electrical")).hasSize(1);
        //assertThat(courseKeyUniversitySeatMap.get("Chemical")).hasSize(1);
    }

    @Test
    public void givenTable_whenRow_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Map<String, Integer> courseSeatMap
                = universityCourseSeatTable.row("Mumbai");

        //assertThat(courseSeatMap).hasSize(2);
        //assertThat(courseSeatMap.get("IT")).isEqualTo(60);
        //assertThat(courseSeatMap.get("Chemical")).isEqualTo(120);
    }

    @Test
    public void givenTable_whenRowKeySet_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Set<String> universitySet = universityCourseSeatTable.rowKeySet();

        //assertThat(universitySet).hasSize(2);
    }

    @Test
    public void givenTable_whenColKeySet_returnsSuccessfully() {
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        Set<String> courseSet = universityCourseSeatTable.columnKeySet();

        //assertThat(courseSet).hasSize(3);
    }
}
