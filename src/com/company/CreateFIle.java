package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateFIle extends JFrame implements ActionListener {

    JTextField fname,pathh;
    JLabel fn,pth;
    JButton done;
    String devname;
    public static boolean CreateNewFile(String temp, String Filename) {
        try {
            Process p = Runtime.getRuntime().exec( "gedit  " + temp + "/" + Filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }

    }
    public CreateFIle() {}
    public CreateFIle(String dename) {
        devname = dename;
        fn = new JLabel("Filename");
        fn.setBounds(16,15,100,50);
        fn.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(fn);

        fname = new JTextField();
        fname.setBounds(15,60,270,35);
        this.add(fname);

        pth = new JLabel("Path");
        pth.setBounds(16,100,100,50);
        pth.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(pth);

        pathh = new JTextField();
        pathh.setBounds(15,145,270,35);
        this.add(pathh);

        done = new JButton("Done");
        done.setBounds(15,200,220,35);
        done.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        done.addActionListener(this);
        this.add(done);

        this.setLocation(SwingConstants.CENTER,SwingConstants.CENTER);
        this.setSize(300,300);
        this.setLayout(null);
        this.setTitle("Create File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            String temp = pathh.getText();
            temp.replace("~","/home/mustafa");
            if (temp.charAt(0) == '~' ) {
                temp = temp.replace("~","");
                temp = "/home/"+ devname + temp;
            }

            CreateNewFile(temp,fname.getText());
            this.dispose();
        }
    }
}
