import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Main extends Compute{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Age Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(2, 2, 1, 1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JButton button = new JButton("Press Me!");

        panelTitle.setBounds(10, 10, 380, 40);
        panelOne.setBounds(10, 60, 360, 80);
        panelTwo.setBounds(10, 200, 360, 40);

        frame.getContentPane().setBackground(Color.white);
        panelTitle.setBackground(Color.gray);
        panelOne.setBackground(Color.white);
        panelTwo.setBackground(Color.white);

        JLabel labelOne, labelTwo, labelTitle;

        final JTextField tFieldOne, tFieldTwo;
        tFieldOne = new JTextField(20);
        tFieldOne.setPreferredSize(new Dimension(80,20));
        tFieldTwo = new JTextField(20);
        tFieldTwo.setPreferredSize(new Dimension(80,20));

        labelTitle = new JLabel("Age Checker", JLabel.CENTER);
        labelOne = new JLabel("Year you were born: ");
        labelTwo = new JLabel("Year today: ");

        labelTitle.setForeground(Color.WHITE);
        tFieldOne.setBackground(Color.BLACK);
        tFieldTwo.setBackground(Color.BLACK);
        tFieldOne.setForeground(Color.WHITE);
        tFieldTwo.setForeground(Color.WHITE);

        labelTitle.setBounds(10,10,90,20);
        labelOne.setBounds(10,10,90,20);
        tFieldOne.setBounds(5, 5, 100, 100);
        labelTwo.setBounds(10,10,90,20);
        tFieldTwo.setBounds(5, 5, 100, 100);

        panelTitle.add(labelTitle);

        panelOne.add(labelOne);
        panelOne.add(tFieldOne);
        panelOne.add(labelTwo);
        panelOne.add(tFieldTwo);

        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = computeAge(tFieldOne.getText(),tFieldTwo.getText());
                displayMessage(String.valueOf(result));
            }
        });

        panelTwo.add(button);

        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);

        frame.setSize(400,300);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

abstract class Methods {
    public void displayMessage(){
        System.out.println("Your change");
    }
}
class Compute extends Methods{
    public static int computeAge(String value1, String value2){
        int val1 = Integer.parseInt(value1);
        int val2 = Integer.parseInt(value2);
        int age = val2 - val1;
        return age;
    }
    public static void displayMessage(String age){
        JOptionPane.showMessageDialog( null, "Your age is: " + age, "Result" , JOptionPane.INFORMATION_MESSAGE );
    }
}
