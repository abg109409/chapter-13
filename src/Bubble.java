import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Point;  
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

	public class Bubble extends JFrame {   
		ArrayList<Point> bubblelist = new ArrayList<Point>();  
		public Bubble() {        
			addMouseListener( new MouseAdapter() {          
				@Override          
				public void mousePressed(MouseEvent e) { //마우스가 누르면     
					bubblelist.add( e.getPoint() );  //버블 추가
					}       
				});
			setTitle("버블 게임");
			setSize(300, 300);     
			setDefaultCloseOperation(EXIT_ON_CLOSE);    
			setVisible(true);        
new Thread(new Runnable() {      
	@Override        
	public void run() {   
		while( true ) {     
			try {               
				repaint();              
				Thread.sleep(20); //20초동안 잠자기      
				} catch(Exception e) {   
					e.printStackTrace();    
					}             
			}       
		}     
	}).start(); 
}    
		public void paint(Graphics g) {  
			Image image = createImage(getWidth(), getHeight()); 
			Graphics g2 = image.getGraphics();    
			g2.clearRect(0, 0, getWidth(), getHeight()); 
			for(int i=0 ; i<bubblelist.size() ; i++) {    
				Point point = bubblelist.get(i);         
				g2.drawOval(point.x, point.y, 20, 20); //풍선 대신 원으로 표현    
				point.y -=5;             
				bubblelist.set(i, point);       
				if( point.y == 0 ) {   
					bubblelist.remove(i);  
					}       
				}      
			g.drawImage(image, 0, 0, null);    
			}     
		public static void main(String[] args) {   
			new Bubble();   
			} 
		}  
