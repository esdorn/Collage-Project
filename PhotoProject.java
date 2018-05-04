

/**
 * Write a description of class PhotoProject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class PhotoProject
{
    public static void main()
    {
        Picture myPic = new Picture("images/MH.jpg");
        Picture myPic2 = new Picture("images/MH.jpg");
        Picture canvas2 = new Picture("images/MyCanvas.jpg");
        Picture scale = new Picture("images/Scale.jpg");
        
        //First photo
        //myPic.copy(canvas2,0,0);
        
        //Second photo
        /*
        myPic.qSwap();
        myPic.scale(scale);
        scale.copy(canvas2,1920,0);
        scale.copy(canvas2,2880,0);
        scale.copy(canvas2,1920,540);
        scale.copy(canvas2,2880,540);
        */
        
        //Third photo
        /*
        myPic.grey();
        myPic2.negitive();
        myPic.blend(myPic2);
        myPic.copy(canvas2,3840,0);
        */
        
        //Forth photo
        //myPic.flip();
        //myPic.copy(canvas2,0,1080);
        
        //Fifth photo
        //myPic.DMirror();
        //myPic.copy(canvas2,1920,1080);
        
        //Sixth photo
        myPic.Bgrey();
        myPic.copy(canvas2,3840,1080);
        
        //Save line
        canvas2.write("images/MyCanvas.jpg");
    }
}
