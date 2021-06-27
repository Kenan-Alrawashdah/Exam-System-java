/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Mohammad
 */
public class StudentQuestions {
    private Question question;
    private ArrayList<Answer> answersList;
    private static double grade = 0;

    public StudentQuestions() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(ArrayList<Answer> answersList) {
        this.answersList = answersList;
    }

    public static double getGrade() {
        return grade;
    }

    public static void setGrade(double grade) {
        StudentQuestions.grade += grade;
    }
    
    
    
}
