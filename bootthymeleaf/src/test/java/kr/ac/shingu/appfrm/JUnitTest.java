package kr.ac.shingu.appfrm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    // 성공 케이스
    @DisplayName("1 + 2는 3이다.") // 테스트 이름
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        Assertions.assertEquals(sum, a + b); // 값이 같은지 확인
    }

    // 실패하는 케이스
    @DisplayName("1 + 3은 4이다.")
    @Test
    public void junitTest2() {
        int a = 1;
        int b = 3;
        int sum = 3;
        Assertions.assertEquals(sum, a + b); // 값이 다르므로 실패
    }
}
