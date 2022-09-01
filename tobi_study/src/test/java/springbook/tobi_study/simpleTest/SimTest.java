package springbook.tobi_study.simpleTest;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
