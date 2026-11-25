package kr.ac.shingu.appfrm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행됨. 메소드는 static으로 선언.
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전에 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("@Test1");
    }

    @Test
    public void test2() {
        System.out.println("@Test2");
    }

    @Test
    public void test3() {
        System.out.println("@Test3");
    }

    @AfterAll // 전체 테스트를 종료하기 전에 1회 실행됨. 메소드는 static으로 선언.
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach // 각 테스트를 종료하기 전에 실행됨.
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
