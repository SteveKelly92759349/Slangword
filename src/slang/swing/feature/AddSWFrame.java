package slang.swing.feature;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import slang.swing.read.SlangWord;
import slang.swing.shows.MenuSWFrame;

public class AddSWFrame extends JFrame implements ActionListener {
    SlangWord slangWord;
    JButton btnBack, btnAdd;
    JTextField textFieldDefinition, textFieldSlang;

    public AddSWFrame() {
        // Get container & slang word
        slangWord = SlangWord.getInstance();
        Container con = this.getContentPane();

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Add Slang Words ");
        titleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.blue);
        titleLabel.setForeground(Color.white);
        titlePanel.setMaximumSize(new Dimension(700, 300));

        // Form
        JPanel form = new JPanel();

        JPanel slagPanel = new JPanel();
        form.setBackground(Color.CYAN);
        SpringLayout layout = new SpringLayout();
        slagPanel.setLayout(layout);
        JLabel labelForSlang = new JLabel("Slang word: ");
        textFieldSlang = new JTextField("", 10);
        labelForSlang.setPreferredSize(new Dimension(100, 20));
        slagPanel.add(labelForSlang);
        slagPanel.add(textFieldSlang);
        layout.putConstraint(SpringLayout.WEST, labelForSlang, 6, SpringLayout.WEST, slagPanel);
        layout.putConstraint(SpringLayout.NORTH, labelForSlang, 6, SpringLayout.NORTH, slagPanel);
        layout.putConstraint(SpringLayout.WEST, textFieldSlang, 6, SpringLayout.EAST, labelForSlang);
        layout.putConstraint(SpringLayout.NORTH, textFieldSlang, 6, SpringLayout.NORTH, slagPanel);
        layout.putConstraint(SpringLayout.EAST, slagPanel, 6, SpringLayout.EAST, textFieldSlang);
        layout.putConstraint(SpringLayout.SOUTH, slagPanel, 6, SpringLayout.SOUTH, textFieldSlang);

        JPanel definitionPanel = new JPanel();
        SpringLayout layout1 = new SpringLayout();
        definitionPanel.setLayout(layout1);
        JLabel labelForDefinition = new JLabel("Definition: ");
        labelForDefinition.setPreferredSize(new Dimension(100, 20));
        textFieldDefinition = new JTextField("", 10);
        definitionPanel.add(labelForDefinition);
        definitionPanel.add(textFieldDefinition);
        layout1.putConstraint(SpringLayout.WEST, labelForDefinition, 6, SpringLayout.WEST, definitionPanel);
        layout1.putConstraint(SpringLayout.NORTH, labelForDefinition, 6, SpringLayout.NORTH, definitionPanel);
        layout1.putConstraint(SpringLayout.WEST, textFieldDefinition, 6, SpringLayout.EAST, labelForDefinition);
        layout1.putConstraint(SpringLayout.NORTH, textFieldDefinition, 6, SpringLayout.NORTH, definitionPanel);
        layout1.putConstraint(SpringLayout.EAST, definitionPanel, 6, SpringLayout.EAST, textFieldDefinition);
        layout1.putConstraint(SpringLayout.SOUTH, definitionPanel, 6, SpringLayout.SOUTH, textFieldDefinition);

        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(slagPanel);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(definitionPanel);
        // Button Back and button Add
        JPanel bottonPanel = new JPanel();
        btnBack = new JButton("Back ");
        // btnBack.addActionListener(this);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnAdd = new JButton("Add");
        // btnBack.addActionListener(this);
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(this);
        btnAdd.setAlignmentX(CENTER_ALIGNMENT);
        bottonPanel.add(btnBack);
        bottonPanel.add(btnAdd);

        // Setting content
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(titlePanel);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(form);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(bottonPanel);
        // Setting Frame
        this.setTitle("Add Slang Words");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setSize(500, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnBack) {
            this.dispose();
            new MenuSWFrame();
        } else if (e.getSource() == btnAdd) {
            String slag = textFieldSlang.getText();
            String definition = textFieldDefinition.getText();
            if (slag.isEmpty() || definition.isEmpty()) {
                // custom title, error icon
                JOptionPane.showMessageDialog(this, "Slag and Definition maybe empty", "Inane error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println(slag + " = " + definition);

            if (slangWord.checkSlang(slag)) {
                // Duplicate or Overwrite
                Object[] options = { "Overwrite", "Duplicate" };
                int n = JOptionPane.showOptionDialog(this,
                        "Slang `" + slag + "` have already exist on  SlangWord  List", "A Silly Question",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if (n == 0) {
                    // Overwrite
                    slangWord.addOverwrite(slag, definition);
                    JOptionPane.showMessageDialog(this, "Overwrite Slang Word Success.");
                } else if (n == 1) {
                    // Duplicate
                    slangWord.addDuplicate(slag, definition);
                    JOptionPane.showMessageDialog(this, "Dupilicate Slang Word Success.");
                }
            } else {
                // Add new slag
                slangWord.addNew(slag, definition);
                JOptionPane.showMessageDialog(this, "Adding new Slang Word Success.");
            }
            textFieldSlang.setText("");
            textFieldDefinition.setText("");
        }
    }

}
