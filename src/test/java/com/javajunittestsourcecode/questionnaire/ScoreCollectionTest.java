package com.javajunittestsourcecode.questionnaire;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreCollectionTest {

    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        //준비
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        //실행
        int actualResult = collection.arithmeticMean();

        //단언
        //assertThat(actualResult.equalTo(6)); <- JUnit4에서 쓰는방식
        assertThat(actualResult).isEqualTo(6); // <- JUnit5에서 쓰는방식

    }
}
