package DoHoa.copy;

import java.awt.Color;
import java.util.Random;

public class Ball extends Thread{
	double x, y, r, v, dx, dy;
	int sx, sy;
    Random rand = new Random();
	public Ball(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
		this.r = rand.nextDouble()*10+10;
		this.x = rand.nextDouble()*(sx-2*r)+r;
		this.y = rand.nextDouble()*(sy-2*r)+r;
		double alpha = rand.nextDouble()*2*Math.PI;
//		Color c1 = new Color(rand.nextInt(256));
//		Color c1 = new Color(rand.nextInt(256), true);
		dx = Math.cos(alpha);
		dy = Math.sin(alpha);
		this.v = rand.nextDouble()*20;
		
	}
	
	public void run(){
		while(true){
			x += dx *v;
			y += dy * v;
		
			if (x - r <= 0 || x + r >= sx)
				dx *= -1;
			if (y - r <= 0 || y + r >= sy)
				dy *= -1;
		try {
			Thread.sleep(100);//toc do bong
		} catch (InterruptedException e) {

		}
	}
}
}
