/*
Mahir Rahman
June 3 2020
Assignment 21: Final Project
ICS3U7-02 Ms. Strelkovska
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckersGame extends JPanel implements ActionListener{
	int rows = 8;
	int columns = 8;
	Color color1 = Color.BLACK;
	Color color2 = Color.RED;
	JButton pan[][] = new JButton[rows][columns];
	int [][]  virtBoard = new int[8][8];
	String firstClick = "";
	String secondClick = "";
	int tempInt1;
	int tempInt2;
	int tempInt3;
	int tempInt4;
	int tempIndex1;
	int tempIndex2;
	int counter = 0;
	int counter2 = 0;
	Color temp;
	boolean boardChange = false;
	boolean forceTake = false;
	boolean doubleTake = false;
	int playerTurn=1;
	boolean validTurn;
	public CheckersGame(){
		Container cont = CheckersGUI.getContainer();
		
		
		setLayout(new GridLayout(rows, columns));
		for(int i = 0; i<rows; i++)
		{
			if(i%2 == 0)
			{
				temp = color1;
			}
			else
				temp = color2;
			for(int j = 0; j<columns; j++)
			{
				if(i<3)
					virtBoard[i][j] = 1;
				else if(i>4)
					virtBoard[i][j] = 2;
				else 
					virtBoard[i][j] = 0;
				
				
				if(temp.equals(color2))
				{
					pan[i][j] = new JButton(new ImageIcon("Red.jpg"));
					temp = color1;
				}
				else
				{
					
					if(virtBoard[i][j] == 1)
					{
						pan[i][j] = new JButton(new ImageIcon("BlackWhite.jpg"));
					}
					else if(virtBoard[i][j] == 2)
					{
						pan[i][j] = new JButton(new ImageIcon("BlackBlue.jpg"));
					}
					else
						pan[i][j] = new JButton(new ImageIcon("Black.jpg"));
					temp = color2;
				}
				add(pan[i][j]);
				pan[i][j].setActionCommand(i + "" + j);
				pan[i][j].addActionListener(this);
			}
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	 public void actionPerformed(ActionEvent e) 
	 {
		counter++;
		validTurn = true;
		if(doubleTake!=true)
		{
		for(int i = 0; i<rows; i++){
		for(int j=0; j<columns; j++)
				{
					if(virtBoard[i][j] == 1 && playerTurn == 1)
					{
						if(i<6 && j<6)//avoiding out of bounds error
						{
							if((virtBoard[i+1][j+1] == 2 || virtBoard[i+1][j+1] == 22) && virtBoard[i+2][j+2]==0)
							{
								forceTake = true;
							}
						}
						if(i<6 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i+1][j-1] == 2 || virtBoard[i+1][j-1] == 22)&& virtBoard[i+2][j-2]==0)
							{
								forceTake = true;
							}
						}
					}
					if(virtBoard[i][j] == 2 && playerTurn == 2)
					{
						if(i>1 && j<6)//avoiding out of bounds error
						{
							if((virtBoard[i-1][j+1] == 1 || virtBoard[i-1][j+1] == 11)&& virtBoard[i-2][j+2] == 0)
							{
								forceTake = true;
							}
						}
						if(i>1 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i-1][j-1] == 1 || virtBoard[i-1][j-1] == 11)&& virtBoard[i-2][j-2] == 0)
							{
								forceTake = true;
							}
						}
						
					}
					if(virtBoard[i][j] == 11 && playerTurn == 1)
					{
						if(i<6 && j<6){//avoiding out of bounds error
							if((virtBoard[i+1][j+1] == 2 || virtBoard[i+1][j+1] == 22) && virtBoard[i+2][j+2]==0)
							{
								forceTake = true;
							}
						}
						if(i<6 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i+1][j-1] == 2 || virtBoard[i+1][j-1] == 22)&& virtBoard[i+2][j-2]==0)
							{
								forceTake = true;
							}
						}
						if(i>1 && j<6){//avoiding out of bounds error
							if((virtBoard[i-1][j+1] == 2 || virtBoard[i-1][j+1] == 22)&& virtBoard[i-2][j+2] == 0)
							{
								forceTake = true;
							}
						}
						if(i>1 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i-1][j-1] == 2 || virtBoard[i-1][j-1] == 22)&& virtBoard[i-2][j-2] == 0)
							{
								forceTake = true;
							}
						}
					}
					if(virtBoard[i][j] == 22 && playerTurn == 2)
					{
						if(i<6 && j<6)//avoiding out of bounds error
						{
							if((virtBoard[i+1][j+1] == 1 || virtBoard[i+1][j+1] == 11) && virtBoard[i+2][j+2]==0 )
							{
								forceTake = true;
							}
						}
						if(i<6 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i+1][j-1] == 1 || virtBoard[i+1][j-1] == 11)&& virtBoard[i+2][j-2]==0)
							{
								forceTake = true;
							}
						}
						if(i>1 && j<6)//avoiding out of bounds error
						{
							if((virtBoard[i-1][j+1] == 1 || virtBoard[i-1][j+1] == 11)&& virtBoard[i-2][j+2] == 0)
							{
								forceTake = true;
							}
						}
						if(i>1 && j>1)//avoiding out of bounds error
						{
							if((virtBoard[i-1][j-1] == 1 || virtBoard[i-1][j-1] == 11)&& virtBoard[i-2][j-2] == 0)
							{
								forceTake = true;
							}
						}
					}
				}
				}
		}
		if(counter%2==1)
		{
			JButton btn = (JButton)e.getSource();
			firstClick = btn.getActionCommand();
			tempInt1 = Integer.parseInt(""+firstClick.charAt(0));
			tempInt2 = Integer.parseInt(""+firstClick.charAt(1));
			if(virtBoard[tempInt1][tempInt2] == 0)
			{
				firstClick = "";
				counter = 0;
			}
			
			
			
		}	
		else
		{
			JButton btn = (JButton)e.getSource();
			secondClick = btn.getActionCommand();
			tempInt3 = Integer.parseInt(""+secondClick.charAt(0));
			tempInt4 = Integer.parseInt(""+secondClick.charAt(1));
			if(virtBoard[tempInt1][tempInt2] != playerTurn || virtBoard[tempInt3][tempInt4] == virtBoard[tempInt1][tempInt2] || (Math.abs(tempInt3-tempInt1)!=1 && Math.abs(tempInt3-tempInt1) !=2) || (Math.abs(tempInt4-tempInt2)!=1 && Math.abs(tempInt4-tempInt2) !=2))
			{
				if(virtBoard[tempInt1][tempInt2] == 11 && playerTurn == 1)
				{
					validTurn = true;
				}
				else if(virtBoard[tempInt1][tempInt2] == 22 && playerTurn == 2)
				{
					validTurn = true;
				}
				else
				{
					firstClick = "";
					secondClick = "";
					counter = 0;
					validTurn = false;
				}
			}
			else
			{
				validTurn = true;
			}
		if(validTurn){
			counter2 = 0;
			if(doubleTake){
				counter2 = 0;
				if(virtBoard[tempIndex1][tempIndex2] == 1)
				{
					if(tempInt1 == tempIndex1 && tempInt2 == tempIndex2)
					{
						if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
							if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 1 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 2 || virtBoard[tempInt1+1][tempInt2-1] == 22)) //if white could take down to the left
							{
								virtBoard[tempInt3][tempInt4] = 1;
								virtBoard[tempInt1+1][tempInt2-1] = 0;
								virtBoard[tempInt1][tempInt2] = 0;
								boardChange = true;
								tempIndex1 = tempInt3;
								tempIndex2 = tempInt4;
								
									if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
									{
										if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
										{
											doubleTake = true;
											counter2++;
										}
									}
									if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
									{
										if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
										{
											doubleTake = true;
											counter2++;
										}
									}
								if(counter2 == 0)
								{
									doubleTake = false;
								}
								if(doubleTake != true)
								{
									if(playerTurn == 1)
										playerTurn = 2;
									else
										playerTurn = 1;
								}
								
							}
							if(tempInt1+1<8 && tempInt2+1<8)//avoiding out of bounds error
							if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 1 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 2 || virtBoard[tempInt1+1][tempInt2+1] == 22)) // if white could take down to the right
							{
								virtBoard[tempInt3][tempInt4] = 1;
								virtBoard[tempInt1+1][tempInt2+1] = 0;
								virtBoard[tempInt1][tempInt2] = 0;
								boardChange = true;
								tempIndex1 = tempInt3;
								tempIndex2 = tempInt4;

									if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
									{
										if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
										{
											doubleTake = true;
											counter2++;
										}
									}
									if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
									{
										if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
										{
											doubleTake = true;
											counter2++;
										}
									}
								if(counter2 == 0)
								{
									doubleTake = false;
								}	
								if(doubleTake != true)
								{
									if(playerTurn == 1)
										playerTurn = 2;
									else
										playerTurn = 1;
								}
													
							}
					}
					
				}
				if(virtBoard[tempIndex1][tempIndex2] == 2)
				{
					if(tempInt1 == tempIndex1 && tempInt2 == tempIndex2)
					{
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 2 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 1 || virtBoard[tempInt1-1][tempInt2-1] == 11)) //if blue could take up to the left
						{
							virtBoard[tempInt3][tempInt4] = 2;
							virtBoard[tempInt1-1][tempInt2-1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;
							if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
							{
								if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
								{
									doubleTake = true;
									counter2++;
								}

							}
							if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
							{
								if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
								{
									doubleTake = true;
									counter2++;
								}

							}
							if(counter2 == 0)
							{
								doubleTake = false;
							}
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}
										
						}
						if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 2 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 1) || (virtBoard[tempInt1-1][tempInt2+1] == 11)) //if blue could take up to the right
						{
							virtBoard[tempInt3][tempInt4] = 2;
							virtBoard[tempInt1-1][tempInt2+1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;	
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}						
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}	
	
						
						}
					}
				}
				if(virtBoard[tempIndex1][tempIndex2] == 11)
				{
					if(tempInt1 == tempIndex1 && tempInt2 == tempIndex2)
					{
						if(tempInt1+1<8 && tempInt2+1<8)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 2 || virtBoard[tempInt1+1][tempInt2+1] == 22))//if white king could take down to the right
						{
							virtBoard[tempInt3][tempInt4] = 11;
							virtBoard[tempInt1+1][tempInt2+1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

								if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}						
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 2 || virtBoard[tempInt1+1][tempInt2-1] == 22))//if white king could take down to the left
						{
							virtBoard[tempInt3][tempInt4] = 11;
							virtBoard[tempInt1+1][tempInt2-1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 2) || (virtBoard[tempInt1-1][tempInt2+1] == 22)) //if white king could take up to the right
						{
							virtBoard[tempInt3][tempInt4] = 11;
							virtBoard[tempInt1-1][tempInt2+1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1-1>0 && tempInt2-1>0)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 2 || virtBoard[tempInt1-1][tempInt2-1] == 22)) // if white king could take up to the left
						{
							virtBoard[tempInt3][tempInt4] = 11;
							virtBoard[tempInt1-1][tempInt2-1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
					}
				}
				if (virtBoard[tempIndex1][tempIndex2] == 22)
				{
					if(tempInt1 == tempIndex1 && tempInt2 == tempIndex2)
					{
						if(tempInt1+1<8 && tempInt2+1<8)		//avoiding out of bounds error		
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 1 || virtBoard[tempInt1+1][tempInt2+1] == 11)) // if black king could take down to the right
						{
							virtBoard[tempInt3][tempInt4] = 22;
							virtBoard[tempInt1+1][tempInt2+1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 1 || virtBoard[tempInt1+1][tempInt2-1] == 11)) //if black king could take down to the left
						{
							virtBoard[tempInt3][tempInt4] = 22;
							virtBoard[tempInt1+1][tempInt2-1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 1) || (virtBoard[tempInt1-1][tempInt2+1] == 11)) // if black king could take up to the right
						{
							virtBoard[tempInt3][tempInt4] = 22;
							virtBoard[tempInt1-1][tempInt2+1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}
						if(tempInt1-1>0 && tempInt2-1>0)//avoiding out of bounds error
						if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 1 || virtBoard[tempInt1-1][tempInt2-1] == 11)) // if black king could take up to the left
						{
							virtBoard[tempInt3][tempInt4] = 22;
							virtBoard[tempInt1-1][tempInt2-1] = 0;
							virtBoard[tempInt1][tempInt2] = 0;
							boardChange = true;
							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;

							tempIndex1 = tempInt3;
							tempIndex2 = tempInt4;
							if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
								if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
								{
									if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
									{
										doubleTake = true;
										counter2++;
									}
								}
							if(counter2 == 0)
							{
								doubleTake = false;
							}	
							if(doubleTake != true)
							{
								if(playerTurn == 1)
									playerTurn = 2;
								else
									playerTurn = 1;
							}							
						}	
					}
				}
				forceTake = false;
			}
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			else if(forceTake)
			{
				counter2 = 0;
				if(tempInt1-1>0 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 2 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 1 || virtBoard[tempInt1-1][tempInt2-1] == 11)) //if blue could take up to the left
				{
					virtBoard[tempInt3][tempInt4] = 2;
					virtBoard[tempInt1-1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;
					if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
					{
						if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
						{
							doubleTake = true;
							counter2++;
						}

					}
					if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
					{
						if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
						{
							doubleTake = true;
							counter2++;
						}

					}
					if(counter2 == 0)
					{
						doubleTake = false;
					}
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}
									
				}
				if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 2 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 1) || (virtBoard[tempInt1-1][tempInt2+1] == 11)) //if blue could take up to the right
				{
					virtBoard[tempInt3][tempInt4] = 2;
					virtBoard[tempInt1-1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;	
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}						
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}	
	
						
				}
				if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 1 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 2 || virtBoard[tempInt1+1][tempInt2-1] == 22)) //if white could take down to the left
				{
					virtBoard[tempInt3][tempInt4] = 1;
					virtBoard[tempInt1+1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;
					
						if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}
					
				}
				if(tempInt1+1<8 && tempInt2+1<8)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 1 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 2 || virtBoard[tempInt1+1][tempInt2+1] == 22)) // if white could take down to the right
				{
					virtBoard[tempInt3][tempInt4] = 1;
					virtBoard[tempInt1+1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

						if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}
										
				}
				if(tempInt1+1<8 && tempInt2+1<8)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 2 || virtBoard[tempInt1+1][tempInt2+1] == 22))//if white king could take down to the right
				{
					virtBoard[tempInt3][tempInt4] = 11;
					virtBoard[tempInt1+1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

						if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}						
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 2 || virtBoard[tempInt1+1][tempInt2-1] == 22))//if white king could take down to the left
				{
					virtBoard[tempInt3][tempInt4] = 11;
					virtBoard[tempInt1+1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 2) || (virtBoard[tempInt1-1][tempInt2+1] == 22)) //if white king could take up to the right
				{
					virtBoard[tempInt3][tempInt4] = 11;
					virtBoard[tempInt1-1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1-1>0 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 2 || virtBoard[tempInt1-1][tempInt2-1] == 22)) // if white king could take up to the left
				{
					virtBoard[tempInt3][tempInt4] = 11;
					virtBoard[tempInt1-1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 2 || virtBoard[tempIndex1+1][tempIndex2+1] == 22) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 2 || virtBoard[tempIndex1+1][tempIndex2-1] == 22)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 2 || virtBoard[tempIndex1-1][tempIndex2+1] == 22)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 2 || virtBoard[tempIndex1-1][tempIndex2-1] == 22)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1+1<8 && tempInt2+1<8)		//avoiding out of bounds error		
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1+1][tempInt2+1]) == 1 || virtBoard[tempInt1+1][tempInt2+1] == 11)) // if black king could take down to the right
				{
					virtBoard[tempInt3][tempInt4] = 22;
					virtBoard[tempInt1+1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1+1<8 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == -2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1+1][tempInt2-1]) == 1 || virtBoard[tempInt1+1][tempInt2-1] == 11)) //if black king could take down to the left
				{
					virtBoard[tempInt3][tempInt4] = 22;
					virtBoard[tempInt1+1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1-1>0 && tempInt2+1<8)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == 2 && ((virtBoard[tempInt1-1][tempInt2+1]) == 1) || (virtBoard[tempInt1-1][tempInt2+1] == 11)) // if black king could take up to the right
				{
					virtBoard[tempInt3][tempInt4] = 22;
					virtBoard[tempInt1-1][tempInt2+1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;
					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;

					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}
				if(tempInt1-1>0 && tempInt2-1>0)//avoiding out of bounds error
				if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 22 && (tempInt1 - tempInt3) == 2 && (tempInt4-tempInt2) == -2 && ((virtBoard[tempInt1-1][tempInt2-1]) == 1 || virtBoard[tempInt1-1][tempInt2-1] == 11)) // if black king could take up to the left
				{
					virtBoard[tempInt3][tempInt4] = 22;
					virtBoard[tempInt1-1][tempInt2-1] = 0;
					virtBoard[tempInt1][tempInt2] = 0;
					boardChange = true;

					tempIndex1 = tempInt3;
					tempIndex2 = tempInt4;
					if(tempIndex1<6 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2+1] == 1 || virtBoard[tempIndex1+1][tempIndex2+1] == 11) && virtBoard[tempIndex1+2][tempIndex2+2]==0 )
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1<6 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1+1][tempIndex2-1] == 1 || virtBoard[tempIndex1+1][tempIndex2-1] == 11)&& virtBoard[tempIndex1+2][tempIndex2-2]==0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2<6)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2+1] == 1 || virtBoard[tempIndex1-1][tempIndex2+1] == 11)&& virtBoard[tempIndex1-2][tempIndex2+2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
						if(tempIndex1>1 && tempIndex2>1)//avoiding out of bounds error
						{
							if((virtBoard[tempIndex1-1][tempIndex2-1] == 1 || virtBoard[tempIndex1-1][tempIndex2-1] == 11)&& virtBoard[tempIndex1-2][tempIndex2-2] == 0)
							{
								doubleTake = true;
								counter2++;
							}
						}
					if(counter2 == 0)
					{
						doubleTake = false;
					}	
					if(doubleTake != true)
					{
						if(playerTurn == 1)
							playerTurn = 2;
						else
							playerTurn = 1;
					}							
				}								
				forceTake = false;
				
			}
			else
			{
			if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 1 && (tempInt3-tempInt1) == 1 && Math.abs(tempInt2-tempInt4) == 1)
			{
				virtBoard[tempInt3][tempInt4] = 1;
				virtBoard[tempInt1][tempInt2] = 0;
				boardChange = true;
				if(playerTurn == 1)
					playerTurn = 2;
				else
					playerTurn = 1;
				
			}
			else if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 2 && (tempInt1-tempInt3)==1 && Math.abs(tempInt4-tempInt2) ==1)
			{
				virtBoard[tempInt3][tempInt4] = 2;
				virtBoard[tempInt1][tempInt2] = 0;
				boardChange = true;
				if(playerTurn == 1)
					playerTurn = 2;
				else
					playerTurn = 1;
			}
			
			else if(virtBoard[tempInt3][tempInt4] == 0 && virtBoard[tempInt1][tempInt2] == 11 || virtBoard[tempInt1][tempInt2] == 22 && (Math.abs(tempInt1-tempInt3) == 1 || Math.abs(tempInt2-tempInt4) == 1))
			{
				if(virtBoard[tempInt1][tempInt2] == 11)
				{
					virtBoard[tempInt3][tempInt4] = 11;
				}
				else 
					virtBoard[tempInt3][tempInt4] = 22;
				virtBoard[tempInt1][tempInt2] = 0;
				boardChange = true;
				if(playerTurn == 1)
					playerTurn = 2;
				else
					playerTurn = 1;	
				
			}
			
			

			}
			for(int i =0; i<rows; i++)
			{
				if(virtBoard[7][i] == 1)
				{
					virtBoard[7][i] = 11;
				}
				if(virtBoard[0][i] == 2)
				{
					virtBoard[0][i] = 22;
				}
				
			}
			
		}
		}
		if(boardChange){//if player moves, redraw board and pieces
			for(int i = 0; i<rows; i++){
			if(i%2 == 0)
			{
				temp = color1;
			}
			else
				temp = color2;
			for(int j = 0; j<columns; j++)
			{
				if(temp.equals(color2))
				{
					pan[i][j].setIcon(new ImageIcon("Red.jpg"));
					temp = color1;
				}
				else
				{
					
					if(virtBoard[i][j] == 1)
					{
						pan[i][j].setIcon(new ImageIcon("BlackWhite.jpg"));
					}
					else if(virtBoard[i][j] == 2)
					{
						pan[i][j].setIcon(new ImageIcon("BlackBlue.jpg"));
					}
					else if(virtBoard[i][j] == 11)
					{
						pan[i][j].setIcon(new ImageIcon("BlackWhiteKing.jpg"));
					}
					else if(virtBoard[i][j] == 22)
					{
						pan[i][j].setIcon(new ImageIcon("BlackBlueKing.jpg"));
					}
					else
						pan[i][j].setIcon(new ImageIcon("Black.jpg"));
					temp = color2;
				}
				add(pan[i][j]);
			}
			}
		}
	}
	
	
	
}
