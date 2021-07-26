package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListFiles extends JFrame implements ActionListener {
    JTextField path;
    JScrollPane scrl;
    JLabel Path;
    JButton done, exit;
    JTextArea txtfield;
    String Devname;
    public  ListFiles() {}
    public ListFiles(String devnam) {
        Devname = devnam;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350,620);
        this.setTitle("List Files And Directories");
        this.setLayout(null);
        this.setVisible(true);


        Path = new JLabel("Path");
        Path.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        Path.setBounds(20,20,100,40);
        this.add(Path);

        path = new JTextField();
        path.setBounds(20,70,300,40);
        this.add(path);


        txtfield = new JTextArea();
        txtfield.setBackground(Color.GRAY);
        txtfield.setEditable(false);
        txtfield.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(txtfield);

        scrl = new JScrollPane(txtfield);
        scrl.setBounds(20,200,300,280);
        this.add(scrl);

        done = new JButton("Done");
        done.setBounds(20,120,300,40);
        done.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        done.addActionListener(this);
        this.add(done);

        exit = new JButton("Close");
        exit.setBounds(20,500,300,40);
        exit.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        exit.addActionListener(this);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            try {
                String temp = path.getText();
                if (temp.charAt(0) == '~' ) {
                    temp = temp.replace("~","");
                    temp = "/home/"+ Devname + temp;
                }
                path.setText(null);
                txtfield.setText(null);
                Process p = Runtime.getRuntime().exec( "ls  " + temp );
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String Output;
                while((Output = reader.readLine()) != null) {
                    txtfield.append(" " + Output + "\n");
                }
            }
            catch(Exception ew) {
                System.out.println("Error Happened Type : " + ew);
            }
        }
        if (e.getSource() == exit)
            this.dispose();
    }
}
