package tanchishe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class InfoPanel extends JPanel {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private She she;
	JLabel l3 = new JLabel("0");
	JLabel l4 = new JLabel("0");
	
	
	public InfoPanel(She s) {
		this();
		this.she = s;
		Thread th=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					l4.setText(String.valueOf(she.speed));
					if(she.jiafen()>0)
					{she.grade=she.grade+1;}
					l3.setText(String.valueOf(she.grade));
					
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		th.start();
	}

	public InfoPanel() {

		setLayout(null);
		setSize(200, GamePnel.HEIGHT);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(new Color(0xCDCDB4));
		JLabel l1 = new JLabel("分数");
		JLabel l2 = new JLabel("速度");
		Font ziti = new Font("微软雅黑", Font.TRUETYPE_FONT, 30);
		l1.setBounds(57, 100, 100, 70);
		l2.setBounds(57, 200, 70, 70);
		l3.setBounds(130, 100, 100, 70);
		l4.setBounds(130, 200, 100, 70);
		l1.setFont(ziti);
		l2.setFont(ziti);
		l3.setFont(ziti);
		l4.setFont(ziti);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
	}
	
}
