package OneonOneBattle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class MoveableThing extends Moveable {
	
	private Player player;
	private int deltaX;

	public MoveableThing (final Player player, final int deltaX, final int xPos,final int yPos, final int width, final int height,final String img)
	{
		this.player = player;
		this.deltaX = deltaX;
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle(xPos, yPos, width, height);
		this.img = getImage(img);
		
	
	}
	


	@Override
	void draw(Graphics g) 
	{
		g.drawImage(img, xPos, yPos, height, width, null);
	}

		
		

	@Override
	void update(final Shooter shooter, final int id) {
		if(rect.intersects(player.rect)){
			player.setHealth(player.getHealth() -1);
			shooter.bullets.remove(this);
		} else if(xPos < 5 || xPos > 595){
			shooter.bullets.remove(this);
		} else {
			xPos += deltaX;
			rect.x += deltaX;
		}
	}
	
	private Rectangle rect() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	Image getImage(String img) {
		
		return Toolkit.getDefaultToolkit().getImage(img);
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}
	
	public int getDeltaX() {
		return deltaX;
	}



	public Player getPlayer() {
		return player;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}


}
