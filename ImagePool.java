import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class ImagePool 
{
    List<GreenfootImage> images;
    
    public ImagePool(String ordner)
    {
        images = new ArrayList();
        
        for (File f : new File(ordner).listFiles())
        {
            images.add(new GreenfootImage(f.getAbsolutePath()));
        }
    }
    
    public GreenfootImage getImage()
    {
        return images.get(Greenfoot.getRandomNumber(images.size()));
    }
}