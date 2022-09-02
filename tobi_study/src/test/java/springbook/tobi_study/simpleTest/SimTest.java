package springbook.tobi_study.simpleTest;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimTest {

//    @Getter
    static class TestList{
        private List<String> strings = new ArrayList<>();

        public TestList(List<String> names){
            if( names != null) {
                this.strings = new ArrayList<String>(names);
            }
        }

        // 새로 만든 getter
        public List<String> getStrings(){
            return new ArrayList<>(strings);
        }
    }

    @Test
    void nullList(){
        TestList tl = new TestList(null);

        System.out.println(tl.getStrings());
    }

    @Test
    void list_copy(){

        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("cdb");

        TestList tl = new TestList(stringList);

        stringList.clear(); // 복사한 개체라서 비워도 문제가 없다.
        assertThat(tl.getStrings()).contains("abc");

        List<String> copyList = tl.getStrings();
        copyList.clear(); // 복사가 아니라서 원본에 영향을 준다.

        // 원본이 손상되었다.
//        assertThat(tl.getStrings()).doesNotContain("abc");
        assertThat(tl.getStrings()).contains("abc");

    }

    @Test
    void listCopy2(){
        List<String> list01 = new ArrayList<>(); // null
        List<String> list02 = new ArrayList<>();

        // null 에러가 터진다.
        for(int i=0; i< list01.size() ; i++){
            list02.add(list01.get(i));
        }
    }


    @Test
    void prefixTest(){

        String field = "TEST";
        String values = "aaa,bbb,ccc";

        System.out.println(getPrefix(field,values));
    }

    private String getPrefix(String field, String values) {
        if(!StringUtils.hasText(values)) return "";

        StringBuilder prefix_condition = new StringBuilder();
        String[] list = values.split(",");
        prefix_condition.append("<"+field+":contains:");
        for (String value : list) {
            prefix_condition.append(value + "|");

        }
        System.out.println(prefix_condition);

        return prefix_condition.append(">").toString();
    }
}
