/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import codefile.Compress;
import codefile.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame implements ActionListener
{
    JButton compressButton;
    JButton decompressButton;
    
    View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,200);
        
        compressButton=new JButton("Select the File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        
        decompressButton=new JButton("Select the File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.getContentPane().setBackground(Color.blue);
        this.setSize(500,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==compressButton)
        {
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
        if(e.getSource()==decompressButton)
        {
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
       View v=new View();
       v.setVisible(true);
    }
    
}
