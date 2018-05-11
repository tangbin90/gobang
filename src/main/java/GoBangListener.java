import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GoBangListener extends MouseAdapter implements GoBangInterface
{
    private Judge j;
    private GoBangPanel panel;
    private Graphics2D g;
//    private GoBangAn an;
    private int x,y;
    private static int num = 1;

    public GoBangListener(GoBangPanel panel)
    {
        this.panel = panel;
        g = (Graphics2D)this.panel.getGraphics();
//        an = new GoBangAn(this.panel);
    }

    public void mouseReleased(MouseEvent e)
    {
        //取得坐标  
        x = e.getX();
        y = e.getY();
        //计算行列  
        int row = (y-Y+Size/2)/Size;
        int coloum = (x-X+Size/2)/Size;

        if(row < Row && coloum < Coloum)
        {
            if(array[row][coloum] == 0){
                //确定在数组的位置  
                x = X+coloum*Size-Size/2;
                y = Y+row*Size-Size/2;
                g.setColor(num%2==0?Color.white:Color.black);

                array[row][coloum] = num;

                g.fillOval(x, y, Size, Size);
                j = new Judge(row,coloum);
                j.judge();
//                an.update(row,coloum);
                num++;
//                an.anticipate(num);
//                num++;
            }
        }
    }
}  