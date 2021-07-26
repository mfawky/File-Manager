package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateDirectory extends JFrame implements ActionListener {
    public static boolean CreateNewDirectory(String path, String DirectoryName) {
        try {
            Process p = Runtime.getRuntime().exec("mkdir  -p " + path + "/" + DirectoryName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder Out = new StringBuilder();
            String Output;
            while ((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }

    }
    String devname;
    JTextField fname, pathh;
    JLabel fn, pth;
    JButton done;
    public CreateDirectory() {}
    public CreateDirectory(String dename) {
        devname = dename;
        fn = new JLabel("Directory Name");
        fn.setBounds(16, 15, 180, 50);
        fn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        this.add(fn);

        fname = new JTextField();
        fname.setBounds(15, 60, 270, 35);
        this.add(fname);

        pth = new JLabel("Path");
        pth.setBounds(16, 100, 100, 50);
        pth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        this.add(pth);

        pathh = new JTextField();
        pathh.setBounds(15, 145, 270, 35);
        this.add(pathh);

        done = new JButton("Done");
        done.setBounds(15, 200, 220, 35);
        done.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        done.addActionListener(this);
        this.add(done);

        this.setLocation(SwingConstants.CENTER, SwingConstants.CENTER);
        this.setSize(300, 300);
        this.setLayout(null);
        this.setTitle("Create Directory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            String temp = pathh.getText();
            if (temp.charAt(0) == '~') {
                temp = temp.replace("~", "");
                temp = "/home/"+ devname + temp;
            }


            CreateNewDirectory(temp, fname.getText());
            this.dispose();
        }
    }
}
