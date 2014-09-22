import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] colony;

public void setup()
{

  size (500, 500);
  colony=new Bacteria[250];

  for (int i=0; i<colony.length; i++)
  {
    colony[i] = new Bacteria();
  }
}

public void draw()
{
  background(0);
  for (int i=0; i<colony.length; i++)
  {
    colony[i].show();
    colony[i].move();
  }
}


class Bacteria
{
  int X, Y, Width, Length, r, g, b;
  Bacteria()
  {
    X=(int)(Math.random()*501); 
    Y=(int)(Math.random()*501); 
    Width=(int)(Math.random()*10+5);
    Length=(int)(Math.random()*10+5);
    r=(int)(Math.random()*256);
    g=(int)(Math.random()*256);
    b=(int)(Math.random()*256);
  }
  public void move()
  {
    if (X<=mouseX && Y<=mouseY)
    {
      X=X+(int)(Math.random()*8);
      Y=Y+(int)(Math.random()*8);
    } else if (X>=mouseX && Y>=mouseY)
    {
      X=X-(int)(Math.random()*8);
      Y=Y-(int)(Math.random()*8);
    } else if (X>=mouseX && Y<=mouseY)
    {
      X=X-(int)(Math.random()*8);
      Y=Y+(int)(Math.random()*8);
    } else if (X<=mouseX && Y>=mouseY)
    {
      X=X+(int)(Math.random()*8);
      Y=Y-(int)(Math.random()*8);
    }
  }
  public void show()
  {
    fill(r, g, b, (int)(Math.random()*144));
    ellipse(X, Y, Width, Length);
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
