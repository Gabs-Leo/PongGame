package PongGame;
import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right, left;
	public int x,y;
	public int width, height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 3;
	}
	
	//Event Tick and Render//
	public void eventTick(){
		if(right){
			x++;
		}
		else if(left) {
			x--;
		}
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
	}
	public void render(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(x, y, width, height);
	}
}
