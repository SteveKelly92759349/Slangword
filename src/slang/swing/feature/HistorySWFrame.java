package slang.swing.feature;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import slang.swing.read.SlangWord;
import slang.swing.shows.MenuSWFrame;
public class HistorySWFrame extends JFrame implements ActionListener {
    JButton btnBack;
    SlangWord slangWord = SlangWord.getInstance();

    public HistorySWFrame() {
        Container con = this.getContentPane();

        // History
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("History Slang Words ");
        titleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.blue);
        titleLabel.setForeground(Color.white);
        titlePanel.setMaximumSize(new Dimension(700, 300));
        // Table
        JPanel panelTable = new JPanel();
        panelTable.setBackground(Color.black);
        // Label total

        JLabel resultLabel = new JLabel();
        resultLabel.setForeground(Color.black);
        resultLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
        resultLabel.setAlignmentX(CENTER_ALIGNMENT);

        String data[][] = slangWord.readHistory();
        String column[] = { "STT", "Slang Word", "Definition" };
        resultLabel.setText("Total: " + data.length + " slang words");
        JTable tableShow = new JTable(data, column);
        tableShow.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableShow.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableShow.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        tableShow.setEnabled(false);
        JScrollPane sp = new JScrollPane(tableShow);
        panelTable.setLayout(new GridLayout(1, 1));
        panelTable.add(sp);
        Dimension size2 = new Dimension(650, 530);
        panelTable.setMaximumSize(size2);
        panelTable.setPreferredSize(size2);
        panelTable.setMinimumSize(size2);
        // 2 Button
        JPanel bottonPanel = new JPanel();
        btnBack = new JButton("Back");
        //btnExit = new JButton("Exit");
        btnBack.addActionListener(this);
        //btnExit.addActionListener(this);
        //Dimension size2 = new Dimension(100, 50);
        //bottonPanel.setMaximumSize(size2);
        //bottonPanel.setPreferredSize(size2);
        //bottonPanel.setMinimumSize(size2);
        //bottonPanel.setLayout(new GridLayout(1, 1));
        bottonPanel.add(btnBack);
        //bottomPanel.add(btnExit);

        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(titlePanel);
        con.add(Box.createRigidArea(new Dimension(0, 20)));
        con.add(resultLabel);
        con.add(Box.createRigidArea(new Dimension(0, 20)));
        con.add(panelTable);
        con.add(Box.createRigidArea(new Dimension(0, 50)));
        con.add(bottonPanel);
        con.add(Box.createRigidArea(new Dimension(0, 20)));

        // Setting JFrame
        this.setTitle("History Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnBack) {
            this.dispose();
            new MenuSWFrame();
        }
    }

}
