package com.javajunittestsourcecode.questionnaire;

public class Answer {
    private int i;
    private Question question;

    public Answer(int i, Question question) {
        this.i = i;
        this.question = question;
    }

    public Answer(Question characteristic, String matchingValue) {
        this.question = characteristic;
        this.i = characteristic.indexOf(matchingValue);
    }
    public String getQuestionText() {
        return question.getText();
    }

    @Override
    public String toString() {
        return String.format("%s %s", question.getText(), question.getAnswerChoices(i));
    }

    public boolean match(int expected) {
        return question.match(expected, i);
    }
    public boolean match(Answer otherAnswer){
        return question.match(i, otherAnswer.i);
    }
    public Question getCharacteristic(){
        return question;
    }
}
