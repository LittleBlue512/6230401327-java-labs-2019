/**
 * This class is to implement ActionListener by showing a dialog window when one of the radio buttons is pressed.
 * This class is also ingerited from PersonFormV6.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 17, 2020
 */

package sirimul.chattipoom.lab8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV7 extends PersonFormV6 implements ActionListener {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FRAME_TITLE = "PersonFormV7 Title";

    public PersonFormV7() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV7(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        this.studentRadioBtn.addActionListener(this);
        this.teacherRadioBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object obj = e.getSource();

        if (obj == this.studentRadioBtn)
            createDialogFormV7("Student");
        else if (obj == this.teacherRadioBtn)
            createDialogFormV7("Teacher");
    }

    protected void createDialogFormV7(String buttonName) {
        // Get message.
        String message = "Type : " + buttonName + " has been selected";

        // Show message dialog.
        JOptionPane.showMessageDialog(this, message, "Person Information", JOptionPane.INFORMATION_MESSAGE,
                PersonFormV6.icon);
    }

    public static void createAndShowGUI() {
        PersonFormV7 PersonFormV7 = new PersonFormV7("Person form V7");

        PersonFormV7.initComponent();
        PersonFormV7.addMenus();
        PersonFormV7.addListeners();
        PersonFormV7.addComponents();
        PersonFormV7.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}