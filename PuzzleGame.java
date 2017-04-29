import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PuzzleGame extends JFrame implements ActionListener{

    private JButton EmptySpace;

    public PuzzleGame() throws IOException
    {
        //Initialize Window
        JFrame frameWindow = new JFrame("Puzzle Game");
        frameWindow.setSize(240,280);
        frameWindow.setLayout(null);
        frameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Initialize Buttons
        //Button 1
        ImageIcon img = loadIMG("images/1");
        JButton button1 = new JButton();
        button1.setBounds(10,30,62 ,63);
        button1.setIcon(resizeIcon(img, button1.getWidth(), button1.getHeight()));

        //Button 2
        ImageIcon img2 = loadIMG("images/2");
        JButton button2 = new JButton();
        button2.setBounds(80,30,62 ,63);
        button2.setIcon(resizeIcon(img2, button2.getWidth(), button2.getHeight()));

        //Button 3
        ImageIcon img3 = loadIMG("images/3");
        JButton button3 = new JButton();
        button3.setBounds(150,30,62 ,63);
        button3.setIcon(resizeIcon(img3, button3.getWidth(), button3.getHeight()));

        //Button 4
        ImageIcon img4 = loadIMG("images/4");
        JButton button4 = new JButton();
        button4.setBounds(10,100,62 ,63);
        button4.setIcon(resizeIcon(img4, button4.getWidth(), button4.getHeight()));

        //Button 5
        ImageIcon img5 = loadIMG("images/5");
        JButton button5 = new JButton();
        button5.setBounds(80,100,62 ,63);
        button5.setIcon(resizeIcon(img5, button5.getWidth(), button5.getHeight()));

        //Button 6
        ImageIcon img6 = loadIMG("images/6");
        JButton button6 = new JButton();
        button6.setBounds(150,100,62 ,63);
        button6.setIcon(resizeIcon(img6, button6.getWidth(), button6.getHeight()));

        //Button 7
        ImageIcon img7 = loadIMG("images/7");
        JButton button7 = new JButton();
        button7.setBounds(10,170,62 ,63);
        button7.setIcon(resizeIcon(img7, button7.getWidth(), button7.getHeight()));

        //Button 8
        ImageIcon img8 = loadIMG("images/8");
        JButton button8 = new JButton();
        button8.setBounds(80,170,62 ,63);
        button8.setIcon(resizeIcon(img8, button8.getWidth(), button8.getHeight()));

        //Button EmptySpace
        ImageIcon img9 = loadIMG("images/Empty");
        EmptySpace = new JButton();
        EmptySpace.setBounds(150,170,62 ,63);
        EmptySpace.setIcon(resizeIcon(img9,EmptySpace.getWidth() ,EmptySpace.getHeight()));


        //Add the images to the Frame
        frameWindow.add(button1);
        frameWindow.add(button2);
        frameWindow.add(button3);
        frameWindow.add(button4);
        frameWindow.add(button5);
        frameWindow.add(button6);
        frameWindow.add(button7);
        frameWindow.add(button8);
        frameWindow.add(EmptySpace);

        //Logic
        //Add Action Listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        //EmptySpace.addActionListener(this);

        frameWindow.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton b = (JButton) e.getSource();

        if(e.getSource() == b)
        {
            int emptyX = EmptySpace.getBounds().x;
            int emptyY = EmptySpace.getBounds().y;
            int thisX = b.getBounds().x;
            int thisY = b.getBounds().y;

            //Check weather the EmptySpace is in the same row
            if(emptyY == thisY)
            {
                //Check weather Empty space is in left or right and if its the Adjacent item
                if(thisX < emptyX && Math.abs(emptyX - thisX) < 100)
                {
                    //Empty space is in Right side
                    //Move this to EmptySpace Location and vice versa
                    b.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
                else if(thisX > emptyX && (Math.abs(emptyX - thisX)) < 100)
                {
                    //Empty Space in Left side
                    //Move this to EmptySpace location and vice versa
                    b.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
            }
            //Check weather EmptySpace and button is in the same column
            else if(emptyX == thisX)
            {
                //Check whether the EmptySpace is in top or bottom and if its only the adjacent column
                if(thisY < emptyY && (Math.abs(emptyY - thisY) < 100))
                {
                    //Empty space is bottom
                    b.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
                else if( thisY > emptyY && (Math.abs(emptyY - thisY) < 100))
                {
                    //EmptySpace is in top
                    b.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
            }
        }

    }


    private ImageIcon loadIMG(String filename) throws IOException{

        String fname = filename + ".png";
        BufferedImage img = ImageIO.read(getClass().getResource(fname));
        ImageIcon imgeico = new ImageIcon(img);
        return imgeico;
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight)
    {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth,resizedHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }


    public static void main(String[] args)
    {
        try {
            PuzzleGame pGame = new PuzzleGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
