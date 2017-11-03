package tanchishe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tanchishe.Snake;

public class Snake extends JFrame implements ActionListener {
	GamePnel gm1 = new GamePnel();
	InfoPanel ifo;
	private Cnotrollor controllor;
	She she = new She();
	private JMenuItem neweGame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Snake() {
		ifo=new InfoPanel(she);
		setSize(gm1.getWidth() + ifo.getWidth(), 64 + gm1.getHeight());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createmenu();
		setLayout(null);
		GamePnel gp = new GamePnel(she);
		gp.setBounds(0, 0, GamePnel.WIDTH, GamePnel.HEIGHT);
		ifo.setBounds(gp.getWidth(), 0, 200, GamePnel.HEIGHT);
		add(gp);
		add(ifo);
		controllor = new Cnotrollor(gp, she,neweGame);
		gp.setFocusable(true);

	}

	private void createmenu() {
		Font font = new Font("微软雅黑", Font.TRUETYPE_FONT, 15);
		JMenuBar mb = new JMenuBar();
		String[] menu = { "游戏", "速度", "帮助" };
		String[][] mi = { { "新游戏", "暂停", "继续" }, { "慢速", "中速", "快速" }, { "关于" } };

		for (int i = 0; i < menu.length; i++) {
			JMenu jm = new JMenu(menu[i]);
			jm.setFont(font);
			for (int j = 0; j < mi[i].length; j++) {
				JMenuItem jmi = new JMenuItem(mi[i][j]);
				jmi.setFont(font);
				jm.add(jmi);
				jmi.addActionListener(this);
				if (mi[i][j].equals("新游戏"))
					neweGame = jmi;
			}
			mb.add(jm);
		}
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Snake();

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "新游戏":
			controllor.Gamestart();
			neweGame.setEnabled(false);
			break;
		case "快速":
			she.speed = She.HIGH;
			break;
		case "中速":
			she.speed = She.MIDDLE;
			break;
		case "慢速":
			she.speed = She.SLOW;
			break;
		case "继续":
			she.pause = false;
			break;
		case "暂停":
			she.pause = true;
			break;
		default:
			break;
		}
		
	}}
