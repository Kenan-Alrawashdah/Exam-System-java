
import Models.Answer;
import Models.Exam;
import Models.Question;
import Models.StudentExam;
import Models.StudentQuestions;
import java.awt.Color;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mohammad
 */
public class ExamFram extends javax.swing.JFrame {

    private int examId;
    private String studentId;
    Connection coon = null;
    PreparedStatement prs = null;
    ResultSet res = null;
    Statement st = null;
    StudentExam exam = new StudentExam();
    ArrayList<StudentQuestions> studentQuestionsList = new ArrayList<>();
    ArrayList<Question> questionsList = new ArrayList<>();
    ArrayList<Answer> answerList = new ArrayList<>();
    ArrayList<String> obj = new ArrayList<>();
    String selectedAnswer = "";
    private static int i = 0;
    
    
    public ExamFram(int examId, String studentId) {
        // this();
        initComponents();
        setLocationRelativeTo(null);
        coon = concat.connectD();
    
        this.examId = examId;
        this.studentId = studentId;

        Date myd = new Date();
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
        String str = obj.format(myd);
        labld.setText(str);

//        addArrayList();
        getQuestions();
        for (Question question : questionsList) {
            StudentQuestions studentQuestions = new StudentQuestions();
            studentQuestions.setQuestion(question);
            studentQuestions.setAnswersList(getAnswers(question.getId()));
            studentQuestionsList.add(studentQuestions);
        }
        getQuestion(i);
        i++;
        
    }

    public ExamFram() {

    }

    private void getQuestions() {

        try {
            String questionQuery = "select * from question where examId=? LIMIT 11";
            prs = coon.prepareStatement(questionQuery);
            prs.setInt(1, examId);
            res = prs.executeQuery();
            while (res.next()) {
                Question question = new Question();
                question.setId(res.getInt("id"));
                question.setDesc(res.getString("desc"));
                questionsList.add(question);
             }
            prs.close();
            res.close();
            exam.setStudentQuestionses(studentQuestionsList);
            exam.setNumOfQuestion(questionsList.size());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ArrayList<Answer> getAnswers(int questionId) {
        ArrayList<Answer> list = new ArrayList<>();
        try {

            String answersQuery = "select * from answer where questionId=? LIMIT 4";
            PreparedStatement pre = coon.prepareStatement(answersQuery);
            pre.setInt(1, questionId);
            res = pre.executeQuery();
            while (res.next()) {
                Answer answer = new Answer();
                answer.setId(res.getInt("id"));
                answer.setAnswer(res.getString("answer"));
                boolean isCorrect = res.getInt("isCorrect")== 1 ? true: false;
                answer.setIsCorrect(isCorrect);
                list.add(answer);
            }

            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    private void getQuestion(int num) {
        String questionTxt = exam.getStudentQuestionses().get(num).getQuestion().getDesc();
        numberq.setText((num + 1) + "");
        lq.setText(questionTxt);
        r1.setText(exam.getStudentQuestionses().get(num).getAnswersList().get(0).getAnswer());
        r2.setText(exam.getStudentQuestionses().get(num).getAnswersList().get(1).getAnswer());
        r3.setText(exam.getStudentQuestionses().get(num).getAnswersList().get(2).getAnswer());
        r4.setText(exam.getStudentQuestionses().get(num).getAnswersList().get(3).getAnswer());
    }

    public boolean answerQuestion(int questionNumber, String selectedAnswer) {
        StudentQuestions studentQuestion = exam.getStudentQuestionses().get(questionNumber-1);
        for (Answer answer : studentQuestion.getAnswersList()) {
             if (answer.getAnswer().equals(selectedAnswer) ) {
                   return answer.isIsCorrect();
            }
        }
        return false;
    }
   



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labld = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        finish = new javax.swing.JButton();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        lablq = new javax.swing.JPanel();
        lq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        r4 = new javax.swing.JRadioButton();
        numberq = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labld.setBackground(new java.awt.Color(102, 51, 255));
        labld.setForeground(new java.awt.Color(255, 0, 0));

        next.setBackground(new java.awt.Color(153, 153, 153));
        next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        finish.setBackground(new java.awt.Color(153, 153, 153));
        finish.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        finish.setForeground(new java.awt.Color(255, 0, 0));
        finish.setText("Finish");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        lablq.setBackground(new java.awt.Color(247, 247, 247));

        lq.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout lablqLayout = new javax.swing.GroupLayout(lablq);
        lablq.setLayout(lablqLayout);
        lablqLayout.setHorizontalGroup(
            lablqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        lablqLayout.setVerticalGroup(
            lablqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lablqLayout.createSequentialGroup()
                .addComponent(lq, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 193, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("Question :");

        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        numberq.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        numberq.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberq, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(lablq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                                .addComponent(labld, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(r1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r4, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(finish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numberq, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lablq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67)
                .addComponent(r1)
                .addGap(18, 18, 18)
                .addComponent(r2)
                .addGap(18, 18, 18)
                .addComponent(r3)
                .addGap(18, 18, 18)
                .addComponent(r4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finish, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        r1.setSelected(false);
        r2.setSelected(false);
        r4.setSelected(false);
        selectedAnswer = r3.getText();
    }//GEN-LAST:event_r3ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        r1.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        selectedAnswer = r2.getText();
    }//GEN-LAST:event_r2ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        selectedAnswer = r1.getText();
    }//GEN-LAST:event_r1ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
         if(!selectedAnswer.equals("")){
             if (i < exam.getNumOfQuestion()){
            if (answerQuestion(i, selectedAnswer)) {
                StudentExam.setGrade(2);
            }
             getQuestion(i);
             i++;
             selectedAnswer = "";
             r2.setSelected(false);
             r3.setSelected(false);
             r4.setSelected(false);
             r1.setSelected(false);
             }
           
             
         }else{
             JOptionPane.showMessageDialog(null,"Please select one of the options");
         }
         if (i==11){
             next.setForeground(Color.lightGray);
             next.setEnabled(false);
         }
    }//GEN-LAST:event_nextActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        selectedAnswer = r4.getText();
    }//GEN-LAST:event_r4ActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
       if (answerQuestion(i, selectedAnswer)) {
                StudentExam.setGrade(2);}
        FinalResult obj = new FinalResult(studentId,StudentExam.grade);
           obj.setVisible(true);
           this.setVisible(false);
    }//GEN-LAST:event_finishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExamFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finish;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labld;
    private javax.swing.JPanel lablq;
    private javax.swing.JLabel lq;
    private javax.swing.JButton next;
    private javax.swing.JLabel numberq;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    // End of variables declaration//GEN-END:variables
}
