import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Circle extends JFrame { 
	private MyPanel panel = new MyPanel(); //JPannel을 상속받은 MyPanel
	
	public Circle() {
		setContentPane(panel);
		Container c = getContentPane();
		c.addMouseListener(new Mouse());
		setTitle("원을 0.5초 간격으로 이동시키자"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(250,220); 
		setVisible(true);
	}
	
	class MyPanel extends JPanel{ // 지름이 50픽셀인 원 생성
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			g.setColor(Color.MAGENTA); 
			g.drawOval(20,20,50,50); 
			}
	}
		public static void main(String[] args)
        { 
        	new Circle(); }
        }
		
        class Mouse implements MouseListener //mouse 리스너
        {
        	public void mouseClicked(MouseEvent e) //마우스 클릭시 랜덤한 위치에 이동
                {
        		JPanel g= (JPanel)e.getSource();
        		int X = (int)(Math.random()*300);
        		int Y = (int)(Math.random()*300);
        		g.setLocation(X, Y);
                }
                public void mouseEntered(MouseEvent e)
                { 	
                }
                public void mouseExited(MouseEvent e)
            	{               	
            	}
                public void mousePressed(MouseEvent e)
                {                	
                }
                public void mouseReleased(MouseEvent e)
                {
                }  
                }
