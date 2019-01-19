import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JTextField textField1;
    private JButton sendButton;
    private JTextPane textPane1;
    private JPanel mainPanel;
    private JLabel label1;

    public Main(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        ChatController cc = new ChatController("18");
        cc.setPane(textPane1);
        cc.obnovitChat();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = textField1.getText().toString();
                cc.dobavitSoobsch(msg);
                textField1.setText(null);
                cc.obnovitChat();
            }
        });
    }

}
