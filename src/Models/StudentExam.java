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
public class StudentExam {
    private Student student;
    private ArrayList<StudentQuestions> studentQuestionses;
    public static int grade;
    private int numOfQuestion;

    public StudentExam() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<StudentQuestions> getStudentQuestionses() {
        return studentQuestionses;
    }

    public void setStudentQuestionses(ArrayList<StudentQuestions> studentQuestionses) {
        this.studentQuestionses = studentQuestionses;
        this.numOfQuestion = studentQuestionses.size();
    }


    public static void setGrade(int grade) {
        StudentExam.grade += grade;
    }

    public int getNumOfQuestion() {
        return numOfQuestion;
    }

    public void setNumOfQuestion(int numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }
    
    
    
    
    
}
