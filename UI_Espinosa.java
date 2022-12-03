import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UI_Espinosa extends JPanel {
    public static final String young_age = "Hi young one!";
    public static final String mature_age = "Hello mature person!";
    public static final String bad_age = "Invalid age";
    public static final int minimum_age = 0;
    public static final int maximum_age = 100;
    public static JTextField ageField;
    public static JLabel res;

    public UI_Espinosa() {
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("How old are you? ");
        northPanel.add(label);

        ageField = new JTextField(15);
        northPanel.add(ageField);
        add(northPanel, BorderLayout.NORTH);
        ageField.setBackground(Color.pink);

        JPanel centerPanel = new JPanel();
        JButton btn = new JButton("Press Me");
        btn.addActionListener(new Button());
        centerPanel.add(btn);

        res = new JLabel();
        res.setVisible(false);
        centerPanel.add(res);

        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(" » Age Check « ");
        frame.add(new UI_Espinosa());
        frame.setVisible(true);
        frame.setSize(300, 110);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static class Button implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String content = ageField.getText();
            int age = -1;
            try{
                age = Integer.parseInt(content);
                if(isValid(age)) {
                    res.setText(age < 18 ? young_age : mature_age);
                } else {
                    res.setText(bad_age);
                }
                if(!res.isVisible())
                    res.setVisible(true);
            } catch(NumberFormatException ex) {
                res.setText("Wrong input");
            }
        }
        public boolean isValid(int age) {
            return age > minimum_age && age < maximum_age;
        }
    }
}