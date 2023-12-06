package org.blackfish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PickFileToRead extends JFrame implements ActionListener {
    private JLabel forrasLabel;
    private JLabel datumLabel;
    private JLabel nevLabel;
    private JLabel celLabel;
    JButton forrasFileButton;
    JTextField datumOszlopSorszamaArea;
    JTextField nevOszlopSorszamaArea;
    JButton celFileButton;
    JButton goButton;
    String forrasfile;
    String celfile;
    public PickFileToRead() {
        this.setTitle("Elso utolso meres");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        forrasFileButton = new JButton("Forrasfile");
        forrasFileButton.addActionListener(this);
        this.getContentPane().add(forrasFileButton);
        datumOszlopSorszamaArea = new JTextField("Datum Oszlop Sorszama");
        this.getContentPane().add(datumOszlopSorszamaArea);
        nevOszlopSorszamaArea = new JTextField("Nev Oszlop Sorszama");
        this.getContentPane().add(nevOszlopSorszamaArea);
        celFileButton = new JButton("Celfile");
        celFileButton.addActionListener(this);
        this.getContentPane().add(celFileButton);

        goButton = new JButton("Go");
        goButton.addActionListener(this);

        datumLabel= new JLabel("Datum Oszlop Sorszama");
        datumLabel.setLabelFor(datumOszlopSorszamaArea);
//        this.getContentPane().add(datumLabel);

        this.getContentPane().add(datumOszlopSorszamaArea);
        nevLabel = new JLabel("Nev Oszlop Sorszama");
        nevLabel.setLabelFor(nevOszlopSorszamaArea);
//        this.getContentPane().add(nevLabel);
        this.getContentPane().add(nevOszlopSorszamaArea);
        this.getContentPane().add(celFileButton);
        this.getContentPane().add(forrasFileButton);
        this.getContentPane().add(goButton);


        this.setSize(400, 400);

        this.setVisible(true);}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == forrasFileButton) {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(".")); //sets current directory

            int response = fileChooser.showOpenDialog(null); //select file to open
            //int response = fileChooser.showSaveDialog(null); //select file to save

            if(response == JFileChooser.APPROVE_OPTION) {
               forrasfile= fileChooser.getSelectedFile().getAbsolutePath();

            }
        }
        if(e.getSource() == celFileButton) {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(".")); //sets current directory

            int response = fileChooser.showSaveDialog(null); //select file to save

            if(response == JFileChooser.APPROVE_OPTION) {
               celfile = fileChooser.getSelectedFile().getAbsolutePath();

            }
        }
        if(e.getSource() == goButton) {
            ExcelReader excelReader = new ExcelReader();
            NapiBontas napiBontas = excelReader.readExcel(forrasfile,Integer.parseInt(datumOszlopSorszamaArea.getText()),Integer.parseInt(nevOszlopSorszamaArea.getText()) );
            ExcelWriter.printNapiBontas(napiBontas,celfile);

        }

    }
}
