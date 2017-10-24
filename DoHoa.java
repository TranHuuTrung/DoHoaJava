package DoHoa.copy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JFrame;

public class DoHoa extends JFrame implements Runnable{
	public static void main(String[] args) {
		new DoHoa();
	}

	int sx = 600;
	int sy = 500;
	Ball[] bs = new Ball[100];
	Image img;
	Graphics gg;

	public DoHoa() {
		this.setTitle("Bong Bay");
		this.setSize(sx, sy);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < bs.length; i++) {
			bs[i] = new Ball(sx, sy);
			bs[i].start();
		}

		this.setVisible(true);
		img = this.createImage(sx,sy);
		gg = img.getGraphics();
		new Thread(this).start();
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {

			}
			repaint();
		}
	}
    Random rand = new Random();
	public void paint(Graphics g) {
		if (gg==null) return;
		gg.setColor(Color.WHITE);
		gg.fillRect(0, 0, sx, sy);
		for (int i = 0; i < bs.length; i++) {		
			int x = (int) bs[i].x;
			int y = (int) bs[i].y;
			int r = (int) bs[i].r;			
			gg.setColor(Color.YELLOW);//bs[i].c2
			gg.fillOval(x - r, y - r, r * 2, r * 2);
			gg.setColor(Color.BLUE); //bs[i].c2
			//gg.setColor(bs[i].);
			gg.drawOval(x - r, y - r, r * 2, r * 2);
			
	}
		g.drawImage(img, 0, 0, null);
	}

}
