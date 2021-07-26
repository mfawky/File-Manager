package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class FileManager extends JFrame  implements ActionListener {
    JButton crDir,delDir,delFile,crFile,lsFiles,lsDirs,CrSymLink,chngPer,lsfiless;
    JLabel filemanager;
    int x = 20;
    int hi = 60;
    public static boolean CreateNewDirectory(String path, String DirectoryName) {
        try {
            Process p = Runtime.getRuntime().exec( "mkdir  -p " + path + "/" + DirectoryName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder Out = new StringBuilder();
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
    String DevName;
    public FileManager() {}

    public FileManager(String DeviceName) {
        DevName = DeviceName;
        filemanager = new JLabel("File Manager",SwingConstants.CENTER);
        filemanager.setBounds(125,10, 300, 60);
        filemanager.setFont(new Font(Font.MONOSPACED,Font.ITALIC,40));
        this.add(filemanager);

        //Create Directory Styling
        crDir = new JButton("Create Directory");
        crDir.setBounds(125,25 + hi,280 + x,40);
        crDir.setForeground(Color.DARK_GRAY);
        crDir.setOpaque(true);
        crDir.setBackground(Color.lightGray);
        crDir.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        crDir.addActionListener(this);

        delDir = new JButton("Delete Directory");
        delDir.setBounds(125,85 + hi,280 + x,40);
        delDir.setForeground(Color.DARK_GRAY);
        delDir.setOpaque(true);
        delDir.setBackground(Color.lightGray);
        delDir.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        delDir.addActionListener(this);

        delFile = new JButton("Delete File");
        delFile.setBounds(125,145 + hi,280 + x,40);
        delFile.setForeground(Color.DARK_GRAY);
        delFile.setOpaque(true);
        delFile.setBackground(Color.lightGray);
        delFile.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        delFile.addActionListener(this);

        crFile = new JButton("Create File");
        crFile.setBounds(125,205 + hi,280 + x,40);
        crFile.setForeground(Color.DARK_GRAY);
        crFile.setOpaque(true);
        crFile.setBackground(Color.lightGray);
        crFile.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        crFile.addActionListener(this);

        lsFiles = new JButton("List Files/Directories");
        lsFiles.setBounds(125,265 + hi,280 + x,40);
        lsFiles.setForeground(Color.DARK_GRAY);
        lsFiles.setOpaque(true);
        lsFiles.setBackground(Color.lightGray);
        lsFiles.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        lsFiles.addActionListener(this);

        lsDirs = new JButton("List Directories");
        lsDirs.setBounds(125,325 + hi,280 + x,40);
        lsDirs.setForeground(Color.DARK_GRAY);
        lsDirs.setOpaque(true);
        lsDirs.setBackground(Color.lightGray);
        lsDirs.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        lsDirs.addActionListener(this);

        lsfiless = new JButton("List Files");
        lsfiless.setBounds(125,60 + 325 + hi,280 + x,40);
        lsfiless.setForeground(Color.DARK_GRAY);
        lsfiless.setOpaque(true);
        lsfiless.setBackground(Color.lightGray);
        lsfiless.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        lsfiless.addActionListener(this);

        CrSymLink = new JButton("Create Symbolic Link");
        CrSymLink.setBounds(125,120 + 325 + hi,280 + x,40);
        CrSymLink.setForeground(Color.DARK_GRAY);
        CrSymLink.setOpaque(true);
        CrSymLink.setBackground(Color.lightGray);
        CrSymLink.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        CrSymLink.addActionListener(this);


        chngPer = new JButton("Change File Permission");
        chngPer.setBounds(125,120 + 385 + hi,300,40);
        chngPer.setForeground(Color.DARK_GRAY);
        chngPer.setOpaque(true);
        chngPer.setBackground(Color.lightGray);
        chngPer.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        chngPer.addActionListener(this);


        this.add(crDir);
        this.add(crFile);
        this.add(delDir);
        this.add(delFile);
        this.add(lsFiles);
        this.add(lsDirs);
        this.add(lsfiless);
        this.add(CrSymLink);
        this.add(chngPer);

        this.setTitle("File Manager");
        this.setSize(550,720);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(560,150);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crFile)
            new CreateFIle(DevName);
        else if (e.getSource() == delFile)
            new DeleteFile(DevName);
        else if (e.getSource() == crDir)
            new CreateDirectory(DevName);
        else if (e.getSource() == delDir)
            new DeleteDirectory(DevName);
        else if (e.getSource() == lsFiles)
            new ListFiles(DevName);
        else if (e.getSource() == lsDirs)
            new ListDirectories(DevName);
        else if (e.getSource() == CrSymLink)
            new CreateSymbLink(DevName);
        else if (e.getSource() == chngPer)
            new chngePerm(DevName);
        else if (e.getSource() == lsfiless)
            new listfiles(DevName);
    }
}
