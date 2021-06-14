import javax.swing.*;
import java.awt.*;


public class PasswordMangr {

    JFrame mainFrame;                           //Declare everything here

    

    public void SignUp()
    {
        //Sign up code comes here
    }

    public void SignIn()
    {
        //Sign in code comes here
    }

    public void Menu()
    {

    }

    public void CTable()
    {

    }

    public void Addinfo()
    {

    }


    public void MainFrameDisplay()
    {
        mainFrame = new JFrame("SecurePass");
        mainFrame.setSize(800,650);
        mainFrame.setLayout(null);
        mainFrame.setBackground(Color.LIGHT_GRAY);

        //All the functions Comes here

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String args[])
    {
        PasswordMangr frameObj = new PasswordMangr();
        frameObj.MainFrameDisplay();
    }
    
}
