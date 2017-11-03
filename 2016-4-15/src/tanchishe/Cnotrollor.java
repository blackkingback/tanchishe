package tanchishe;

import javax.swing.JMenuItem;

public class Cnotrollor {
	private GamePnel gamepanel;
	private JMenuItem neweGame;

	public Cnotrollor(GamePnel gamepanel, She she,JMenuItem neweGame ) {
		this.gamepanel = gamepanel;
		this.she = she;
		this.neweGame=neweGame;
	}

	private She she;

	public Cnotrollor() {

	}

	public void Gamestart() {
		she.initSnake();
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (she.Gameover() >= 0) {
					if (!she.pause) {
						she.move();						
						try {
							Thread.sleep(she.speed);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
					gamepanel.repaint();
					
				}neweGame.setEnabled(true);
			}
		});
		th.start();

	}

}
