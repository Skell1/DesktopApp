import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm1 {
    private JPanel mainPanel;
    private JTextField patronymic;
    private JTextField surname;
    private JTextField name;
    private JPanel panel10;
    private JTextField FIO;
    private JButton button1;
    private JPanel panel11;
    private JPanel panel12;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MainForm1(){
        button1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = button1.getText();
                if (buttonText.equals("Collapse")) {
                    String nameText = name.getText();
                    String surnameText = surname.getText();
                    String patronymicText = patronymic.getText();
                    if (nameText.isEmpty() || surnameText.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                mainPanel, "Незаполнены поля имени или фамилии, повторите ввод",
                                "Ошибка ввода",
                                JOptionPane.PLAIN_MESSAGE
                        );
                    }
                    if (nameText.contains(" ") || surnameText.contains(" ") || patronymicText.contains(" ")){
                        JOptionPane.showMessageDialog(
                                mainPanel, "Найдите и удалите пробелы",
                                "Ошибка ввода",
                                JOptionPane.PLAIN_MESSAGE
                        );
                    }
                    else {
                        FIO.setText(surnameText + " " + nameText + " " + patronymicText);
                        panel10.setVisible(false);
                        panel12.setVisible(true);
                        button1.setText("Expand");
                    }
                }
                else {
                    String fioText = FIO.getText();
                    if (fioText.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                mainPanel, "Незаполнено поле ФИО, повторите ввод",
                                "Ошибка ввода",
                                JOptionPane.PLAIN_MESSAGE
                        );
                    } else {
                        String[] array = fioText.split(" ");
                        if (array.length>3){
                            JOptionPane.showMessageDialog(
                                    mainPanel, "Неверно введен ФИО, повторите ввод",
                                    "Ошибка ввода",
                                    JOptionPane.PLAIN_MESSAGE
                            );
                        }
                        else {
                            surname.setText(array[0]);
                            name.setText(array[1]);
                            if (array.length==3) {
                                patronymic.setText(array[2]);
                            }
                            panel10.setVisible(true);
                            panel12.setVisible(false);
                            button1.setText("Collapse");
                        }
                    }
                }
            }
        });
    }
}
