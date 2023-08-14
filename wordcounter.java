
import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class wordcounter{
    public static void main(String []args)throws Exception{
        JFrame frame=new JFrame("Word Counter");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Color customColor=new Color(0,255,255);
        frame.setBackground(customColor);

        JLabel label=new JLabel(" Word Counter", 0);
        Font bigfount=new Font("Arial", Font.BOLD, 50);
        label.setFont(bigfount);
        label.setBounds(80, 10, 400, 50);

        JButton count=new JButton("Count words in text box");
        count.setBounds(185, 420, 200, 30);
        JButton count2=new JButton("Count words in given file");
        count2.setBounds(185, 460, 200, 30);

       
        JTextArea text=new JTextArea(null, null, 10, 50); 
        JScrollPane scrollPane=new JScrollPane(text);  
        scrollPane.setBounds(90,100,400,150);
                     

        JTextArea counter=new JTextArea(null, null, 1, 5);
        counter.setBounds(245, 350, 80, 30);
        
        count.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String str=text.getText();
                String []words=str.trim().split("\\s+");
                int count1=words.length;
                counter.setText(Integer.toString(count1));
            }
        });
        count2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String str1=text.getText();
                StringBuilder str2=new StringBuilder("");
            try {
                File file=new File(str1);
                Scanner sc=new Scanner(file);
                while(sc.hasNextLine()){
                    str2.append(sc.nextLine());

                }
                sc.close();

            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
            String str4=str2.toString();
            String []words=str4.trim().split("\\s+");
            int count3=words.length;
            counter.setText(Integer.toString(count3));



                
                
            }
        });
        frame.add(counter);
        frame.add(count2);
        frame.add(scrollPane);
        frame.add(label);
        frame.add(count);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
