package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chngePerm extends JFrame implements ActionListener {
    // addOrDelete Mode either [+] for add or [-] for delete
    // user either [u] for owner, [g] for group, or [o] for others
    // permission either [r] for read, [w] for write, or [x] for execute
    public static void ChangePermission(char addOrDelete, String fileName, char user, char permission)
            throws IOException, InterruptedException {
        try {
            String cmd = "chmod " + user + addOrDelete + permission + " " + fileName;

            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String Output;
            while ((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
        } catch (Exception e) {
            System.out.println("Error Happened Type: " + e);
        }
    }


    JTextField pathh;
    JLabel Path,UserOpt,Perm,addOrdel;
    ButtonGroup userOption;
    ButtonGroup addOdel;
    ButtonGroup others;
    JRadioButton user,grop,othr
            ,write,read,execute
            ,add,del;
    JButton done;
    String devname;
    public chngePerm() {}
    public chngePerm(String dename) {
        devname = dename;
        Path = new JLabel("Filename Or Path");
        Path.setBounds(20,20,250,30);
        Path.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(Path);

        pathh = new JTextField();
        pathh.setBounds(20, 50,270,40);
        this.add(pathh);

        UserOpt = new JLabel("Label 1 :" );
        UserOpt.setBounds(20,95,200,30);
        UserOpt.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(UserOpt);

        user = new JRadioButton("User");
        user.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        user.setBounds(20,120,85,30);
        this.add(user);

        grop = new JRadioButton("Group");
        grop.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        grop.setBounds(105,120,85,30);
        this.add(grop);

        othr = new JRadioButton("Other");
        othr.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        othr.setBounds(195,120,85,30);
        this.add(othr);

        Perm = new JLabel("Permission : ");
        Perm.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        Perm.setBounds(20,150,200,30);
        this.add(Perm);

        write = new JRadioButton("Write");
        write.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        write.setBounds(20,185,85,30);
        this.add(write);


        read = new JRadioButton("Read");
        read.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        read.setBounds(105,185,85,30);
        this.add(read);

        execute = new JRadioButton("Execute");
        execute.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        execute.setBounds(195,185,100,30);
        this.add(execute);

        addOrdel = new JLabel("Add or Delete :" );
        addOrdel.setBounds(20,210,200,30);
        addOrdel.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        this.add(addOrdel);

        add = new JRadioButton("Add");
        add.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        add.setBounds(20,240,80,30);
        this.add(add);

        del = new JRadioButton("Delete");
        del.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        del.setBounds(100,240,85,30);
        this.add(del);

        addOdel = new ButtonGroup();
        addOdel.add(execute);
        addOdel.add(read);
        addOdel.add(write);

        userOption = new ButtonGroup();
        userOption.add(grop);
        userOption.add(othr);
        userOption.add(user);

        others = new ButtonGroup();
        others.add(del);
        others.add(add);

        done = new JButton("Done");
        done.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        done.setBounds(20,280,280,40);
        done.addActionListener(this);
        this.add(done);

        this.setLocation(400, 250);
        this.setSize(320, 400);
        this.setLayout(null);
        this.setTitle("Change Permission");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


        @Override
    public void actionPerformed(ActionEvent e) {
            char addOrDelete = ' ',usr = ' ',per = ' ';
            if (e.getSource() == done) {
            if (add.isSelected())
                addOrDelete = '+';
            else if (del.isSelected())
                addOrDelete = '-';



            if (user.isSelected())
                usr = 'u';
            else if (grop.isSelected())
                usr = 'g';
            else if (othr.isSelected())
                usr = 'o';


            if (write.isSelected())
                per = 'w';
            else if (read.isSelected())
                per = 'r';
            else if (execute.isSelected())
                per = 'x';

                try {
                    String temp = pathh.getText();
                    if (temp.charAt(0) == '~' ) {
                        temp = temp.replace("~","");
                        temp = "/home/" + devname + temp;
                    }

                    ChangePermission(addOrDelete,temp,usr,per);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                this.dispose();
            }
    }
}
