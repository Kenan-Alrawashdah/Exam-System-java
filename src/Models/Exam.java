/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Mohammad
 */
public class Exam {
    
    private int id;
    private String subject;

    public Exam() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", subject=" + subject + '}';
    }
   
   public static void main(String...arg){
       Exam  obj = new Exam();
       obj.setId(1);
       obj.setSubject("java");
       System.out.println(obj);
   } 
}
