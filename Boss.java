import greenfoot.*;

public class Boss extends Gegner
{
    public Boss(int leben, String image)
    {
        super();
        this.leben = leben;
        setImage(new GreenfootImage(image));
    }
    
    @Override
    public void niederlage()
    {
        leben--;
        if (leben <= 0) {
            Spiel.naechsteEbene();
        }
    }
}
