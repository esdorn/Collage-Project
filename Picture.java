import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;
  }

    public void grey()
    {
        int grey=0;
        Pixel[] parr=this.getPixels();
        for(Pixel p : parr)
        {
            grey = (p.getRed()+p.getGreen()+p.getBlue())/3;
            p.setRed(grey);
            p.setGreen(grey);
            p.setBlue(grey);
        }
    }

    public void copy(Picture target,int x, int y)
    {
        //Picture target = new Picture(location);
        Pixel pc;
        Pixel pt;
        for (int xc = 0, xt = x; xc<this.getWidth();xc++,xt++)
        {
            for (int yc = 0, yt = y; yc<this.getHeight();yc++,yt++)
            {
                pc = this.getPixel(xc,yc);
                pt = target.getPixel(xt,yt);
                pt.setColor(pc.getColor());
            }
        }
    }

    public void VMirror()
    {
        Pixel pc;
        Pixel pt;
        for (int xc = 0, xt = 0; xc<this.getWidth();xc++,xt++)
        {
            for (int yc = 0, yt = this.getHeight()-1;yt>=yc;yc++,yt--)
            {
                pc = this.getPixel(xc,yc);
                pt = this.getPixel(xt,yt);
                pt.setColor(pc.getColor());
            }
        }
    }
    public void HMirror()
        {
            Pixel pc;
            Pixel pt;
            for (int xc = 0, xt = this.getWidth()-1; xc<=xt;xc++,xt--)
            {
                for (int yc = 0, yt = 0;yc<this.getHeight();yc++,yt++)
                {
                    pc = this.getPixel(xc,yc);
                    pt = this.getPixel(xt,yt);
                    pt.setColor(pc.getColor());
                }
            }
        }

    public void fix(int xs, int xf, int ys, int yf)
    {
        Pixel pc;
        Pixel pt;
        for (int xc = xs, xt = xf; xc<=xt;xc++,xt--)
        {
            for (int yc = ys, yt = ys;yc<yf;yc++,yt++)
            {
                pc = this.getPixel(xc,yc);
                pt = this.getPixel(xt,yt);
                pt.setColor(pc.getColor());
            }
        }
    }

    public void flip()
    {
        //pixel copied from
        Pixel pc;
        //pixel to be replaced
        Pixel pt;
        for (int xc = 0, xt = this.getWidth()-1; xc<(this.getWidth()/2);xc++,xt--)
        {
            for (int yc = 0, yt = this.getHeight()-1;yc<this.getHeight();yc++,yt--)
            {
                pc = this.getPixel(xc,yc);
                pt = this.getPixel(xt,yt);
                Color color = pt.getColor();
                pt.setColor(pc.getColor());
                pc.setColor(color);
            }
        }
    }

    public void qSwap()
        {
            Color color;
            //pixel copied from
            Pixel pc;
            Pixel pc2;
            //pixel to be replaced
            Pixel pt;
            Pixel pt2;
            for (int xc = 0, xt = this.getWidth()/2; xc<this.getWidth()/2;xc++,xt++)
            {
                for (int yc = 0, yt = this.getHeight()/2;yc<this.getHeight()/2;yc++,yt++)
                {
                    pc = this.getPixel(xc,yc);
                    pt = this.getPixel(xt,yt);
                    pc2 = this.getPixel(xc,yt);
                    pt2 = this.getPixel(xt,yc);
                    color = pt.getColor();
                    pt.setColor(pc.getColor());
                    pc.setColor(color);
                    color = pt2.getColor();
                    pt2.setColor(pc2.getColor());
                    pc2.setColor(color);
                }
            }
    }
    public void negitive()
    {
        Pixel p;
        for (int x = 0; x<this.getWidth();x++)
        {
            for (int y = 0; y<this.getHeight();y++)
            {
                p = this.getPixel(x,y);
                p.setRed(255-p.getRed());
                p.setGreen(255-p.getGreen());
                p.setBlue(255-p.getBlue());
            }
        }
    }

    public void scale(Picture target)
    {
        //pixel copied from
        Pixel pc;
        //pixel  to be replaced
        Pixel pt;
        for(int xc=0,xt=0;xc<this.getWidth();xc+=2,xt++)
        {
            for(int yc=0,yt=0;yc<this.getHeight();yc+=2,yt++)
            {
                pc = this.getPixel(xc,yc);
                pt = target.getPixel(xt,yt);
                pt.setColor(pc.getColor());
            }
        }
    }

    public void blend(Picture target)
    {
        Pixel pc;
        Pixel pt;
        for (int xc=0,xt=0;xc<this.getWidth();xc++,xt++)
        {
            for (int yc=0,yt=0;yc<this.getHeight();yc++,yt++)
            {
                pt = target.getPixel(xt,yt);
                pc = this.getPixel(xc,yc);
                pc.setColor(new Color((((pt.getRed()*3)/2)+(pc.getRed()/2))/2,
                                      (((pt.getGreen()*3)/2)+(pc.getGreen()/2))/2,
                                      (((pt.getBlue()*3)/2)+(pc.getBlue()/2))/2));
            }
        }
    }

    public void DMirror()
    {
        DMirror(0,this.getHeight());
    }

    public void DMirror(int x, double y)
    {
        Pixel pc;
        Pixel pt;
        for (int yc=0;yc<y;yc++)
        {
            pc = this.getPixel(x,yc);
            pt = this.getPixel((this.getWidth()-x-1),(this.getHeight()-yc-1));
            pt.setColor(new Color(255-pc.getRed(),
                                  255-pc.getGreen(),
                                  255-pc.getBlue()));
        }
        if (x<this.getWidth())
        {
            DMirror((x+1),(y-.5625));
        }
    }

    public void redStrip()
    {
        Pixel p;
        for (int x = 0; x<this.getWidth();x++)
        {
            for (int y = 0; y<this.getHeight();y++)
            {
                p = this.getPixel(x,y);
                p.setRed(0);
            }
        }
    }

    public void Bgrey()
    {
		Pixel p;
		int grey;
		for (int x = 0; x<this.getWidth();x++)
		        {
		            for (int y = 0; y<this.getHeight();y++)
		            {
		                p = this.getPixel(x,y);
		                if (!(p.getRed()>=p.getBlue()&&p.getRed()>=p.getGreen()))
		                {
		                    grey = (p.getRed()+p.getGreen()+p.getBlue())/3;
					        p.setRed(grey);
							p.setGreen(grey);
            				p.setBlue(grey);
						}
		            }
        }
	}

    public static void main(String[] args)
    {
       String fileName = FileChooser.pickAFile();
       Picture pictObj = new Picture(fileName);
       pictObj.explore();
    }

} // this } is the end of class Picture, put all new methods before this