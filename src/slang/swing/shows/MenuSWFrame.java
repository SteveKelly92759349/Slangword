package slang.swing.shows;

import slang.swing.feature.*;
import slang.swing.quesstion.QuestionSWFrame;
import slang.swing.quesstion.QuizSWFrame;
import slang.swing.read.SlangWord;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuSWFrame extends JFrame implements ActionListener {
    JButton b9;
    SlangWord slangWord;
    JMenu Menu, Submenu;
    JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;

    JTable jt;
    String dataCopy[][];

    public MenuSWFrame() {
        // A Label
        JLabel label = new JLabel("Slang Words");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
        label.setAlignmentX(CENTER_ALIGNMENT);



        JMenuBar mb = new JMenuBar();

        Menu = new JMenu("Menu");

        Menu = new JMenu("Menu");
        Menu.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        Menu.setFocusable(false);
        Menu.setForeground(Color.BLACK);

        Submenu = new JMenu("Quiz Game");
        Submenu.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        Submenu.setFocusable(false);
        Submenu.setForeground(Color.red);
        Submenu.setBackground(Color.green);

        i1 = new JMenuItem("Add");
        i1.addActionListener(this);
        i1.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i1.setFocusable(false);
        i1.setForeground(Color.red);
//        i1.setBackground(Color.green);

        i2 = new JMenuItem("Edit");
        i2.addActionListener(this);
        i2.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i2.setFocusable(false);
        i2.setForeground(Color.red);
//        i2.setBackground(Color.green);


        i3 = new JMenuItem("Delete");
        i3.addActionListener(this);
        i3.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i3.setFocusable(false);
        i3.setForeground(Color.red);
//        i3.setBackground(Color.green);

        i4 = new JMenuItem("History");
        i4.addActionListener(this);
        i4.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i4.setFocusable(false);
        i4.setForeground(Color.red);
//        i4.setBackground(Color.green);

        i5 = new JMenuItem("Random");
        i5.addActionListener(this);
        i5.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i5.setFocusable(false);
        i5.setForeground(Color.red);
//        i5.setBackground(Color.green);

        i6 = new JMenuItem("Search");
        i6.addActionListener(this);
        i6.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i6.setFocusable(false);
        i6.setForeground(Color.red);
//        i6.setBackground(Color.green);

        i7 = new JMenuItem("Reset");
        i7.addActionListener(this);
        i7.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        i7.setFocusable(false);
        i7.setForeground(Color.red);
//        i7.setBackground(Color.green);

//        i8 = new JMenuItem("Quiz Game");
//        i8.addActionListener(this);
//        i8.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
//        i8.setFocusable(false);
//        i8.setForeground(Color.red);
//        i8.setBackground(Color.green);

        i9 = new JMenuItem("1. Find Definition");
        i9.addActionListener(this);
        i9.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
//        i9.setBackground(Color.cyan);
        i9.setForeground(Color.red);

        i10 = new JMenuItem("2. Find SlangWord");
        i10.addActionListener(this);
        i10.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
//        i10.setBackground(Color.cyan);
        i10.setForeground(Color.red);

        Menu.add(i1);
        Menu.add(i2);
        Menu.add(i3);
        Menu.add(i4);
        Menu.add(i5);
        Menu.add(i6);
        Menu.add(i7);
//        Menu.add(i8);
        Submenu.add(i9); Submenu.add(i10);
        Menu.add(Submenu);
        mb.add(Menu);


        slangWord = SlangWord.getInstance();

        b9 = new JButton("Exit");
        b9.addActionListener(this);
        b9.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
        b9.setFocusable(false);
        b9.setForeground(Color.yellow);
        b9.setBackground(Color.red);


        // Label resultLabel
        JLabel resultLabel = new JLabel();
        resultLabel.setForeground(Color.black);
        resultLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
        resultLabel.setAlignmentX(CENTER_ALIGNMENT);

        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.black);
        String data[][] = slangWord.getData();
        dataCopy = slangWord.getData();
        String column[] = { "STT", "Slang Word", "Definition" };
        resultLabel.setText("Total: " + data.length + " slang words");
        jt = new JTable(data, column);
        jt.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jt.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jt.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jt.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jt.putClientProperty("terminateEditOnFocusLost", true);
        //jt.getModel().addTableModelListener(this);

        JScrollPane sp = new JScrollPane(jt);
        panelCenter.add(sp);

        panelCenter.setBackground(Color.GREEN);
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));


        JPanel bottonPanel = new JPanel();

        Dimension size3 = new Dimension(100, 50);
        bottonPanel.setMaximumSize(size3);
        bottonPanel.setPreferredSize(size3);
        bottonPanel.setMinimumSize(size3);
        bottonPanel.setLayout(new GridLayout(1, 1));
        bottonPanel.add(b9);

        Dimension size2 = new Dimension(650, 530);
        panelCenter.setMaximumSize(size2);
        panelCenter.setPreferredSize(size2);
        panelCenter.setMinimumSize(size2);


        Container con = this.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(label);
        con.add(Box.createRigidArea(new Dimension(0, 20)));
        con.add(resultLabel);
        con.add(Box.createRigidArea(new Dimension(0, 30)));
        con.add(panelCenter);
        con.add(Box.createRigidArea(new Dimension(0, 30)));
        con.add(bottonPanel);
        // Setting Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Window");
        this.setJMenuBar(mb);
        this.setVisible(true);
        this.setSize(800, 850);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

    @Override


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == i1) {
            // Add a slang word
            this.dispose();
            new AddSWFrame();
        } else if (e.getSource() == i2) {

            this.dispose();
            try {
                new EditSWFrame();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (e.getSource() == i3) {

            this.dispose();
            try {
                new DeleteSWFrame();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (e.getSource() == i4) {

            this.dispose();
            new HistorySWFrame();

        } else if (e.getSource() == i5) {

            this.dispose();
            new RandomSWFrame();

        } else if (e.getSource() == i6) {

            System.out.println("Change Actitity");
            this.dispose();
            try {
                new SearchSWFrame();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (e.getSource() == i7) {

            // default icon, custom title
            int n = JOptionPane.showConfirmDialog(this, "Do you really want to reset Slang Word?", "An Inane Question",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                slangWord.reset();
                JOptionPane.showMessageDialog(this, "Reset success.");
            }

        } else if (e.getSource() == i8) {

            this.dispose();
            new QuizSWFrame();

        } else if (e.getSource() == b9) {

            System.exit(0);
        }
        else if (e.getSource() == i9) {

            this.dispose();
            new QuestionSWFrame(1);

        } else if (e.getSource() == i10) {

            this.dispose();
            new QuestionSWFrame(2);

        }
    }
//    public void tableChanged(TableModelEvent e) {
//        // TODO Auto-generated method stub
//        int row = jt.getSelectedRow();
//        int col = jt.getSelectedColumn();
//        if (row == -1 || col == -1)
//            return;
//        String Data = (String) jt.getValueAt(row, col);
//        // System.out.println("Table element selected is: " + Data);
//
//        if (col == 2) {
//            // edit definition
//            System.out.println("Old SlangWord: \t" + row + "\t" + dataCopy[row][2]);
//            slangWord.set((String) jt.getValueAt(row, 1), dataCopy[row][2], (String) jt.getValueAt(row, 2));
//            JOptionPane.showMessageDialog(this, "Updated a row.");
//        }
//    }
}

