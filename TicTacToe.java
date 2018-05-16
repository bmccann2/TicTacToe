import javax.swing.JApplet;
import java.awt.*;
import java.util.StringTokenizer;
import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TicTacToe extends JApplet
{
   public void paint (Graphics page)
   {
   int box, Xwins=0, Owins=0, Ties=0, games;
   int turn=0;
   char[] board= new char[9];
   char winner;
   String cont;
   boolean tie=false;
   
   games= Integer.parseInt(JOptionPane.showInputDialog(null, "How many rounds would you like to play?", JOptionPane.PLAIN_MESSAGE));
   
   for (int a=0; a<games; a++)
   {
   turn=0;
   page.setColor(Color.cyan);
   page.fillRect(0,0,400,400);
   page.setColor(Color.black);
   page.drawLine(125, 50, 125, 300);
   page.drawLine(275, 50, 275, 300);
   page.drawLine(50, 100, 350, 100);
   page.drawLine(50, 250, 350, 250);
   
   for (int x=0; x<board.length; x++)
      board[x]='a';
   
   do
   { 
   if (turn %2==0)
   {
   box= Integer.parseInt(JOptionPane.showInputDialog(null, "It's X turn, Which box would you like to fill?", JOptionPane.PLAIN_MESSAGE ));
   
   
   if ((board[box-1]=='X')||(board[box-1]=='O'))
   {
   JOptionPane.showMessageDialog (null,  "Invalid move",   
            "ERROR", JOptionPane.PLAIN_MESSAGE );
   turn--;
   }
   
   if (board[box-1]=='a')
   board[box-1]= 'X';
   }
   
   if (turn%2 !=0)
   {
   box= Integer.parseInt(JOptionPane.showInputDialog(null, "It's O turn, Which box would you like to fill?", JOptionPane.PLAIN_MESSAGE ));
   
   if ((board[box-1]=='X')||(board[box-1]=='O'))
   {
   JOptionPane.showMessageDialog (null,  "Invalid move",   
            "ERROR", JOptionPane.PLAIN_MESSAGE );
   turn--;
   }
   
   if (board[box-1]=='a')
   board[box-1]= 'O';
   }
   
   if (board[0]=='O')
   page.drawOval(65,50,50,50);
   
   if (board[1]=='O')
   page.drawOval(175,50,50,50);
   
   if (board[2]=='O')
   page.drawOval(275,50,50,50);
   
   if (board[3]=='O')
   page.drawOval(65,150,50,50);
   
   if (board[4]=='O')
   page.drawOval(175,150,50,50);
   
   if (board[5]=='O')
   page.drawOval(275,150,50,50);
   
   if (board[6]=='O')
   page.drawOval(65,250,50,50);
   
   if (board[7]=='O')
   page.drawOval(175,250,50,50);
   
   if (board[8]=='O')
   page.drawOval(275,250,50,50);
   
   if (board[0]=='X')
   {
   page.drawLine(65,50,125,100);
   page.drawLine(125,50,65,100);
   }
   
   if (board[1]=='X')
   {
   page.drawLine(175,50,225,100);
   page.drawLine(225,50,175,100);
   }

   if (board[2]=='X')
   {
   page.drawLine(275,50,325,100);
   page.drawLine(325,50,275,100);
   }
   
   if (board[3]=='X')
   {
   page.drawLine(65,150,115,200);
   page.drawLine(115,150,65,200);
   }

    if (board[4]=='X')
   {
   page.drawLine(175,150,225,200);
   page.drawLine(225,150,175,200);
   }
   
   if (board[5]=='X')
   {
   page.drawLine(275,150,325,200);
   page.drawLine(325,150,275,200);
   }

   if (board[6]=='X')
   {
   page.drawLine(65,250,115,300);
   page.drawLine(115,250,65,300);
   }
   
   if (board[7]=='X')
   {
   page.drawLine(175,250,225,300);
   page.drawLine(225,250,175,300);
   }
   
   if (board[8]=='X')
   {
   page.drawLine(275,250,325,300);
   page.drawLine(325,250,275,300);
   }
   turn++;
   winner= checkWin(board, page);
   if (winner=='a')
   tie= checkTie(board);
   }while (winner=='a' && turn!=9);
   
   if (winner=='X')
   {
   JOptionPane.showMessageDialog (null,  "Player X is the winner","WINNER", JOptionPane.PLAIN_MESSAGE );
   Xwins++;
   }
   
   if (winner=='O')
   {
   JOptionPane.showMessageDialog (null,  "Player O is the winner","WINNER", JOptionPane.PLAIN_MESSAGE );
   Owins++;
   }
   
   if (winner=='a')
   {
   JOptionPane.showMessageDialog (null,  "Tie game chumps","TIE", JOptionPane.PLAIN_MESSAGE );
   Ties++;
   }
   
   JOptionPane.showMessageDialog (null,  "X WINS: "+ Xwins+ " O WINS: "+ Owins+ " TIES: "+ Ties  ,"CURRENT RESULTS", JOptionPane.PLAIN_MESSAGE );
      
}  


if(Xwins>Owins)
JOptionPane.showMessageDialog (null,"X is the champion"  , "CHMAPION", JOptionPane.PLAIN_MESSAGE );

if(Owins>Xwins)
JOptionPane.showMessageDialog (null,"O is the champion"  , "CHAMPION", JOptionPane.PLAIN_MESSAGE );

if (Owins==Xwins)
JOptionPane.showMessageDialog (null,"You know what this means? Rematch..."  , "CHAMPION", JOptionPane.PLAIN_MESSAGE );
}   

public char checkWin(char[] board, Graphics page)
{
if(board[0]=='X' && board[1]=='X' && board[2]=='X')
   {
   page.drawLine(65,75,350,75);
   return 'X';
   }
   
else if(board[3]=='X' && board[4]=='X' && board[5]=='X')
   {
   page.drawLine(65,175,350,175);
   return 'X';
   }
else if(board[6]=='X' && board[7]=='X' && board[8]=='X')
   {
   page.drawLine(65,275,350,275);
   return 'X';
   }
else if(board[0]=='X' && board[3]=='X' && board[6]=='X')
   {
   page.drawLine(95,50,95,300);
   return 'X';
   }
else if(board[1]=='X' && board[4]=='X' && board[7]=='X')
   {
   page.drawLine(200,50,200,300);
   return 'X';
   }
else if(board[2]=='X' && board[5]=='X' && board[8]=='X')
   {
   page.drawLine(300,50,300,300);
   return 'X';
   }
else if(board[0]=='X' && board[4]=='X' && board[8]=='X')
   {
   page.drawLine(65,50,325,300);
   return 'X';
   }
else if(board[2]=='X' && board[4]=='X' && board[6]=='X')
   {
   page.drawLine(325,50,65,300);
   return 'X';
   }

else if(board[0]=='O' && board[1]=='O' && board[2]=='O')
   {
   page.drawLine(65,75,350,75);
   return 'O';
   }

   
else if(board[3]=='O' && board[4]=='O' && board[5]=='O')
   {
   page.drawLine(65,175,350,175);
   return 'O';
   }

   
else if(board[6]=='O' && board[7]=='O' && board[8]=='O')
   {
   page.drawLine(65,275,350,275);
   return 'O';
   }

   
else if(board[0]=='O' && board[3]=='O' && board[6]=='O')
   {
   page.drawLine(95,50,95,300);
   return 'O';
   }

   
else if(board[1]=='O' && board[4]=='O' && board[7]=='O')
   {
   page.drawLine(200,50,200,300);
   return 'O';
   }
   
else if(board[2]=='O' && board[5]=='O' && board[8]=='O')
   {
   page.drawLine(300,50,300,300);
   return 'O';
   }
   
else if(board[0]=='O' && board[4]=='O' && board[8]=='O')
   {
   page.drawLine(65,50,325,300);
   return 'O';
   }

   
else if(board[2]=='O' && board[4]=='O' && board[6]=='O')
   {
   page.drawLine(325,50,65,300);
   return 'O';
   }

else return 'a';

}   
public boolean checkTie(char[] board)
{
int count=0;
   for(int i=0; i<board.length; i++)
   {
      if ((board[i]=='X')||(board[i]=='O'))
      count++;
   }
if (count==9)
return true;

else
return false;      
         
}

}