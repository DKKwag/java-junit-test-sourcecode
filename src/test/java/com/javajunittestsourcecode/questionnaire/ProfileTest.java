package com.javajunittestsourcecode.questionnaire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @BeforeEach
    public void create() {
        profile = new Profile("Bull Hockey, inc");
        question = new BooleanQuestion(1, "Got Bonuses?");
        criteria = new Criteria();
    }

    @Test
    void mustMatch_기준을_충족못하면_답변은_false() {
        Answer profileAnswer = new Answer(Bool.FALSE, question);
        profile.add(profileAnswer);

        Answer creteriaAnswer = new Answer(Bool.TRUE, question);
        Criterion criterion = new Criterion(creteriaAnswer, Weight.MustMatch);
        criteria.add(criterion);
        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    @Test
    void dontcare_기준을_충족못해도_답변은_true() {
        Answer profileAnswer = new Answer(Bool.FALSE, question);
        profile.add(profileAnswer);

        Answer criteriaAnswer = new Answer(Bool.TRUE, question);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }
}
