package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateSymbLink extends JFrame implements ActionListener {
    public static boolean CreateSymbolLink(String path, String linkName) {
        try {
            Process p = Runtime.getRuntime().exec( "ln -v -s " + path + "  "  + linkName);
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
    JTextField fname,pathh;
    JLabel fn,pth;
    JButton done;
    String devname;
    public CreateSymbLink() {}
    public CreateSymbLink(String dename) {
        devname = dename;
        fn = new JLabel("Source");
        fn.setBounds(16,15,180,50);
        fn.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(fn);

        fname = new JTextField();
        fname.setBounds(15,60,270,35);
        this.add(fname);

        pth = new JLabel("Destination");
        pth.setBounds(16,100,180,50);
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
        this.setTitle("Create Symbolic Link");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp = new String(),temp2 = new String();
        if (e.getSource() == done) {
            temp2 = fname.getText();
            temp = pathh.getText();
            if (temp.charAt(0) == '~') {
                temp = temp.replace("~","");
                temp = "/home/" + devname + temp;
            }
            if (temp2.charAt(0) == '~') {
                temp2 = temp2.replace("~","");
                temp2 = "/home/" + devname + temp2;
            }
            System.out.println(temp);
            System.out.println(temp2);
            CreateSymbolLink(temp2,temp);
            this.dispose();
        }
    }

}
