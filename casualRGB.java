import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class casualRGB{
    public static void main(final String args[]) throws IOException {
        int h = 300, w = 200, i = 0, j = 100, a = 128, r = 128, g = 128, b = 128, p = 0;
        BufferedImage img = null;
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        File f = null;
        for (int x = 0; x < w; x++){    
            for (int y = 0; y < h; y++){
                if(i<256){
                    a--;r--;g--;b--;i++; 
                    p = (a << 24) | (r << 16) | (g << 8) | b;
                    img.setRGB(x, y, p);   
                }
                else{
                    do{
                        a ++;
                        r ++;
                        g ++;
                        b ++;
                        j--; 
                        p = (a << 24) | (r << 16) | (g << 8) | b;
                        img.setRGB(x, y, p);
                    }
                    while(j>0);
                    System.out.println(x + " " + y + " " + p);
                }        
            }
        try {
            f = new File("C:\\Users\\aless\\OneDrive\\Desktop\\out.png");
            ImageIO.write(img, "png", f);
        } catch (final IOException e) {
            System.out.println("Errore output" + e);
        }
    }
 }
}