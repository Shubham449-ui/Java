package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {

    //JFrame jf = new JFrame();
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField t1, t2;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JComboBox<String> day, month, year;
    JTextArea ta1,screen;
    JCheckBox terms;
    JButton submit;
    JLabel msg;

    Form() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setTitle("Registration Form");

        Container c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("Name");
        label1.setBounds(50, 50, 100, 25);
        c.add(label1);

        label2 = new JLabel("Mobile");
        label2.setBounds(50, 110, 100, 30);
        c.add(label2);

        label3 = new JLabel("Gender");
        label3.setBounds(50, 180, 100, 30);
        c.add(label3);

        label4 = new JLabel("DOB");
        label4.setBounds(50, 250, 100, 50);
        c.add(label4);

        label5 = new JLabel("Address");
        label5.setBounds(50, 320, 100, 50);
        c.add(label5);

        t1 = new JTextField();
        t1.setBounds(120, 50, 110, 30);
        t1.setForeground(Color.blue);
        c.add(t1);

        t2 = new JTextField();
        t2.setBounds(120, 110, 110, 30);
        t2.setForeground(Color.blue);
        c.add(t2);

        male = new JRadioButton("male");
        male.setBounds(120, 180, 100, 30);
        //male.setBackground(Color.red);
        c.add(male);

        female = new JRadioButton("female");
        female.setBounds(230, 180, 100, 30);
        //female.setBackground(Color.BLUE);
        c.add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        day = new JComboBox<>(days);
        day.setBounds(120, 265, 50, 20);
        c.add(day);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        month = new JComboBox<>(months);
        month.setBounds(200, 265, 80, 20);
        c.add(month);

        String[] years = new String[16];
        for (int i = 1999; i < 2015; i++) {
            years[i - 1999] = Integer.toString(i);
        }
        year = new JComboBox<>(years);
        year.setBounds(300, 264, 80, 21);
        c.add(year);

        ta1 = new JTextArea();
        ta1.setBounds(120, 320, 200, 80);
        c.add(ta1);

        terms = new JCheckBox();
        terms.setBounds(50, 420, 50, 50);
        c.add(terms);

        label6 = new JLabel("Please Accept Terms and Condition ");
        label6.setBounds(120, 420, 210, 50);
        c.add(label6);
        
        
        submit = new JButton("Submit");
        submit.setBounds(200, 500, 100, 30);
        submit.addActionListener(this);
        c.add(submit);
        
        screen = new JTextArea();
        screen.setBounds(500, 50, 400, 400);
        c.add(screen);
        
        msg = new JLabel("");
        msg.setBounds(50, 520, 200, 60);
        c.add(msg);

        setVisible(true);

    }

    public static void main(String[] args) {
        Form f = new Form();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(terms.isSelected())
        {
            msg.setText("Registration is successfull");
            
            String name = t1.getText();
            String phone = t2.getText();
            String gender = "male";
            
            if(female.isSelected())
            {
                gender = "female";
            }
            
            String dob = day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem();
            String adr = ta1.getText();
            
            screen.setText("Name: "+name+"\n"+"Phone: "+phone+"\n"+"Gender: "+gender+"\n"+"DOB: "+dob+"\n"+"Address: "+adr+"\n");
       
        }
    }
}
