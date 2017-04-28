import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PuzzleGame extends JFrame implements ActionListener{


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton EmptySpace;

    public PuzzleGame() throws IOException
    {
        //Initialize Window
        JFrame frameWindow = new JFrame("Puzzle Game");
        frameWindow.setSize(240,300);
        frameWindow.setLayout(null);
        frameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Initialize Buttons
        //Button 1
        ImageIcon img = loadIMG("images/1");
        button1 = new JButton();
        int offset1 = button1.getInsets().left;
        button1.setBounds(10,30,62 ,63);
        button1.setIcon(resizeIcon(img,button1.getWidth() - offset1 ,button1.getHeight() - offset1));

        //Button 2
        ImageIcon img2 = loadIMG("images/2");
        button2 = new JButton();
        button2.setBounds(80,30,62 ,63);
        button2.setIcon(resizeIcon(img2,button2.getWidth() - offset1 ,button2.getHeight() - offset1));

        //Button 3
        ImageIcon img3 = loadIMG("images/3");
        button3 = new JButton();
        button3.setBounds(150,30,62 ,63);
        button3.setIcon(resizeIcon(img3,button3.getWidth() - offset1 ,button3.getHeight() - offset1));

        //Button 4
        ImageIcon img4 = loadIMG("images/4");
        button4 = new JButton();
        button4.setBounds(10,100,62 ,63);
        button4.setIcon(resizeIcon(img4,button4.getWidth() - offset1 ,button4.getHeight() - offset1));

        //Button 5
        ImageIcon img5 = loadIMG("images/5");
        button5 = new JButton();
        button5.setBounds(80,100,62 ,63);
        button5.setIcon(resizeIcon(img5,button5.getWidth() - offset1 ,button5.getHeight() - offset1));

        //Button 6
        ImageIcon img6 = loadIMG("images/6");
        button6 = new JButton();
        button6.setBounds(150,100,62 ,63);
        button6.setIcon(resizeIcon(img6,button6.getWidth() - offset1 ,button6.getHeight() - offset1));

        //Button 7
        ImageIcon img7 = loadIMG("images/7");
        button7 = new JButton();
        button7.setBounds(10,170,62 ,63);
        button7.setIcon(resizeIcon(img7,button7.getWidth() - offset1 ,button7.getHeight() - offset1));

        //Button 8
        ImageIcon img8 = loadIMG("images/8");
        button8 = new JButton();
        button8.setBounds(80,170,62 ,63);
        button8.setIcon(resizeIcon(img8,button8.getWidth() - offset1 ,button8.getHeight() - offset1));

        //Button EmptySpace
        ImageIcon img9 = loadIMG("images/Empty");
        EmptySpace = new JButton();
        EmptySpace.setBounds(150,170,62 ,63);
        EmptySpace.setIcon(resizeIcon(img9,EmptySpace.getWidth() - offset1 ,EmptySpace.getHeight() - offset1));


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
        EmptySpace.addActionListener(this);


        frameWindow.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1)
        {
            System.out.println("Distigign");
            int x = button1.getBounds().x;
            int y = button1.getBounds().y;
            int width = button1.getBounds().width;
            int height = button1.getBounds().height;

            button1.setBounds(x+20,y+20,width,height);

        }

        if(e.getSource() == button8)
        {
            int emptyX = EmptySpace.getBounds().x;
            int emptyY = EmptySpace.getBounds().y;
            int thisX = button8.getBounds().x;
            int thisY = button8.getBounds().y;

            //Check weather the EmptySpace is in the same row
            if(emptyY == thisY)
            {
                System.out.println("Empty Space Y = " + emptyY + " Button8 Y = " + thisY);
                //Check weather Empty space is in left or right
                if(thisX < emptyX)
                {
                    //Empty space is in Right side
                    //Move this to EmptySpace Location and vice versa

                    button8.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
                else if(thisX > emptyX)
                {
                    //Empty Space in Left side
                    //Move this to EmptySpace location and vice versa
                    button8.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
            }
            //Check weather EmptySpace and button is in the same adjacent column
            else if(emptyX == thisX)
            {
                System.out.println("Empty Space X = " + emptyY + " Button8 X = " + thisY);

            }
        }

        if(e.getSource() == button6)
        {
            int emptyX = EmptySpace.getBounds().x;
            int emptyY = EmptySpace.getBounds().y;
            int thisX = button6.getBounds().x;
            int thisY = button6.getBounds().y;

            //Check weather the EmptySpace is in the same row
            if(emptyY == thisY)
            {
                System.out.println("Empty Space Y = " + emptyY + " button6 Y = " + thisY);
                //Check weather Empty space is in left or right
                if(thisX < emptyX)
                {
                    //Empty space is in Right side
                    //Move this to EmptySpace Location and vice versa

                    button6.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
                else if(thisX > emptyX)
                {
                    //Empty Space in Left side
                    //Move this to EmptySpace location and vice versa
                    button6.setBounds(emptyX,emptyY,62,63);
                    EmptySpace.setBounds(thisX,thisY,62,63);
                }
            }
            //Check weather EmptySpace and button is in the same adjacent column
            else if(emptyX == thisX)
            {
                System.out.println("Empty Space X = " + emptyX + " button6 X = " + thisX);

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
