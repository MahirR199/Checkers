/*
Mahir Rahman
Partner: Lorrin Shen
June 3 2020
Assignment 21: Final Project
ICS3U7-01 Ms. Strelkovska
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class CheckersRules {  
	JFrame f;  
	ImageIcon move, noMove, capture, forceCapture, multiCapture, promotion, kingMove;
	JPanel p;
	JLabel lbl1;
	int jop;
	String m1, m2, m3, m4, m5, m6, m7;
	JTextPane pane;
	
	CheckersRules(){  
	
		p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		p.setPreferredSize(new Dimension(800, 600));
		
		//the images of all the pages of the rules
		move = new ImageIcon("move.jpg");
		noMove = new ImageIcon("noMove.jpg");
		capture = new ImageIcon("capture.jpg");
		forceCapture = new ImageIcon("forceCapture.jpg");
		multiCapture = new ImageIcon("multiCapture.jpg");
		promotion = new ImageIcon("promotion.jpg");
		kingMove = new ImageIcon("kingMove.jpg");
		
		int x = 0;
		boolean rules = true;

		//the text for each page of the rules
		m1 = "Regular Move:\n"+
		"A piece can only move one spot down(White Piece)/up(Blue Piece) and one spot to the right or left.\n"+
		"Each piece can only move in one direction on the board(down or up depeding on piece colour).\n"+
		"In this case it is White's turn, the White player decides to use the piece highlighted in green.\n"+
		"The left arrows show where White can move this highlighted piece.\n";
		
		m2 = "Regular Move Restrictions:\n"+
		"Any piece on the board cannot move onto a red square.\n"+
		"Each piece can only move diagonally, this is why a piece cannot go on a red square.\n"+
		"In this case it is White's turn, the White player cannot move their piece onto the red squares that are crossed out.\n";
		
		m3 = "Capturing A Piece:\n"+
		"A piece can capture an opposing piece by jumping over it.\n"+
		"The piece that is capturing the other moves 2 spaces diagonally in the direction of the captured piece.\n"+
		"A captured piece is removed from the board.\n"+
		"In this case it is White's turn, the White player uses the piece highlighted in green and moves it 2 spaces down and to the right(diagonally).\n"+
		"The blue piece that was captured, marked by the gray X, is then captured and will be removed from the board.\n";
		
		m4 = "Force Capture:\n"+
		"If a player can capture an opposing player's piece it is mandatory to play that move.\n"+
		"The player cannot use any other piece and move it.\n"+
		"In this case it is White's turn, they can capture a blue piece, shown by the highlighted white piece and the yellow arrow.\n"+
		"The other pieces that are not in a position to capture an opposing piece cannot move, shown by the pink stop symbols on them.\n";
		
		m5 = "Multiple Capturing:\n"+
		"It is possible to capture more than one piece in one turn.\n"+
		"By using the same piece to chain jumps/captures on opposing pieces it is possible to capture multiple pieces.\n"+
		"As per the Force Capture rule, it is mandatory to capture both pieces.\n"+
		"Capturing only one of the pieces when a double capture is possible is not allowed.\n"+
		"In this case it is Blue's turn, the highlighted blue piece is in a position to be able to capture 2 white pieces.\n"+
		"The Blue player moves their piece 4 spaces to the right and up and captures 2 white pieces with it.\n";
		
		m6 = "Promotion:\n"+
		"If a piece manages to reach the other side of the board that piece is promoted to King.\n"+
		"In this case it is White's turn and they are able to move their piece to the bottom row of the board.\n"+
		"That piece started at the top of the board, since it will get to the other side of where it started it will be promoted.\n"+
		"the green highlighted piece will move to the yellow highlighted square and become a king piece, represented by the gray one.\n"+
		"Once promoted the piece will keep it's color, the piece in the example is gray because it is a piece that will show up in the future.\n";
		
		m7 = "Kinged Piece Movement:\n"+
		"A Kinged Piece can move in both directions.\n"+
		"it still cannot move onto red squares however it can move both up and down diagonally now.\n"+
		"In this case it is White's turn and they have a Kinged piece(highlighted in green).\n"+
		"This piece can move 1 up or 1 down and 1 left or 1 right as shown by the yellow arrows.\n"+
		"In the case of capturing, the Kinged piece captures normally(Multi and Single) except it can do so in both directions(up and down the board).\n";
		
		pane = new JTextPane();
		pane.setEditable(false); 
		pane.setText(m1);
		lbl1 = new JLabel();
		lbl1.setIcon(move);
				
		p.add(lbl1);
		p.add(pane);
		
		while(rules){
			//Change default button's names
			UIManager.put("OptionPane.yesButtonText", "back");
			UIManager.put("OptionPane.okButtonText", "next");
			UIManager.put("OptionPane.noButtonText", "next");
			UIManager.put("OptionPane.cancelButtonText", "exit");
			
			//System.out.println("update: "+x); //testing for the JOP page num
			
			//Show the JOP on screen
			///-x is the page num-
			if(x<=1){ //if it is the 1st page of the rules, only have 2 buttons, next and exit
				jop = JOptionPane.showConfirmDialog(null, p, "Rules pg1", JOptionPane.OK_CANCEL_OPTION); 
			}
			else if(x==7){ //if it is the last page of the rules, only have 2 buttons, back and exit
				UIManager.put("OptionPane.okButtonText","back"); //change the text of the ok button to back for this specific case
				jop = JOptionPane.showConfirmDialog(null,p,"Rules pg7",JOptionPane.OK_CANCEL_OPTION);
			}
			else{ //if it is any other page, have 3 buttons, back next and exit
				jop = JOptionPane.showConfirmDialog(null, p, "Rules pg"+x, JOptionPane.YES_NO_CANCEL_OPTION);
			}

			
			//which JOP user should go to
			if(x==0){ //if on first JOP
				switch(jop){ //set the num for which JOP is wanted
					case JOptionPane.OK_OPTION: x+=2; break;
					case JOptionPane.CANCEL_OPTION: x=100; break;
					case JOptionPane.CLOSED_OPTION: x=100;break;
				}
			}
			else if(x==1){ //if on first JOP after going back from another JOP
				switch(jop){ //set the num for which JOP is wanted
					case JOptionPane.OK_OPTION: x+=1; break;
					case JOptionPane.CANCEL_OPTION: x=100; break;
					case JOptionPane.CLOSED_OPTION: x=100;break;
				}
			}
			else if(x==7){ //if on last JOP
				switch(jop){
					case JOptionPane.OK_OPTION: x-=1; break;
					case JOptionPane.CANCEL_OPTION: x=100; break;
					case JOptionPane.CLOSED_OPTION: x=100;break;
				}
			}
			else{ //if not on first or last JOP
				switch(jop){ //set the num for which JOP is wanted
					case JOptionPane.YES_OPTION: x-=1; break; //yes option = back
					case JOptionPane.NO_OPTION: x+=1; break; //no option = next
					case JOptionPane.CANCEL_OPTION: x=100; break; //cancel option = exit
					case JOptionPane.CLOSED_OPTION: x=100; break; //x button in top left
				}
			}
		
			//update the jpanel that goes on the dif JOPs 
			switch(x){ //depending on the page num the user is on update the images and text
				case 1: lbl1.setIcon(move); pane.setText(m1); p.revalidate(); break;
				case 2: lbl1.setIcon(noMove); pane.setText(m2); p.revalidate(); break;
				case 3: lbl1.setIcon(capture); pane.setText(m3); p.revalidate(); break;
				case 4: lbl1.setIcon(forceCapture); pane.setText(m4); p.revalidate(); break;
				case 5: lbl1.setIcon(multiCapture); pane.setText(m5); p.revalidate(); break;
				case 6: lbl1.setIcon(promotion); pane.setText(m6); p.revalidate(); break;
				case 7: lbl1.setIcon(kingMove); pane.setText(m7); p.revalidate(); break;
				case 100: rules = false; //dont show anymore JOPs
			}
		}
		
	}  


	 
	} 