/*
Mahir Rahman
June 3 2020
Assignment 21: Final Project
ICS3U7-02 Ms. Strelkovska
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckersGUI{
	public static JFrame myFrame;
	public static Container pane;
	public CheckersGUI(){
		myFrame = new JFrame("Checkers");
		pane = myFrame.getContentPane();
	}
	public static void main(String[] args){
		
		CheckersGUI cg = new CheckersGUI();
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		CheckersMenu bg = new CheckersMenu();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.add(bg);
		myFrame.pack();
	}
	public static Container getContainer(){
		return pane;
	}
	
	
	
}