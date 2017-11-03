package tanchishe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class GamePnel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=500,HEIGHT=500;
	private	She she;
	public GamePnel(She she) {
		this();
		this.she = she;
	}
	public GamePnel() {
		setSize(WIDTH, HEIGHT);
		setBorder(null);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(new Color(0xEEDFFC));
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				super.keyPressed(e);
				switch(e.getKeyCode()){
				case KeyEvent.VK_RIGHT:she.changedirection(She.RIGHT);break;
				case KeyEvent.VK_LEFT:she.changedirection(She.LEFT);break;
				case KeyEvent.VK_UP:she.changedirection(She.UP);break;
				case KeyEvent.VK_DOWN:she.changedirection(She.DOWN);break;
				 
				}
					
				}
			
		});
		
		
	}
	public void paint(Graphics g){
		super .paint(g);
		LinkedList<Node> body=she.getbody();
		if(body==null) return;
		for(int i=0;i<body.size();i++)
			{	
			
			 if(i%2==0) g.setColor(Color.red);
		else g.setColor(Color.blue);
			Node node=body.get(i);
			g.fill3DRect(node.getX(), node.getY(), Node.WIDTH, Node.HEIGHT, true);
		}
		Node food=she.getFood();
		g.setColor(Color.pink);
		g.fill3DRect(food.getX(), food.getY(), Node.WIDTH,Node.HEIGHT,true);

	}
	
}
