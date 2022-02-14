import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl; //top
    JPanel displayPnl; //mid
    JPanel controlPnl; //bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    Random rnd = new Random();
    int fortunePicked;
    int oldVal;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortuneCookieImg.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titleLbl.setFont(new Font("Georgia", Font.PLAIN, 36));
        iconPnl.add(titleLbl);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(15,45);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));


        //Array with 12 fortunes
        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("Run");
        fortunes.add("To truly find yourself you should play hide and seek alone");
        fortunes.add("It could be better, but it's good enough");
        fortunes.add("It would be best to maintain a low profile for now");
        fortunes.add("Catch on fire with enthusiasm and people will come for miles to watch you burn");
        fortunes.add("Error 404 Fortune not found");
        fortunes.add("I see money in your future...it is not yours though");
        fortunes.add("Ignore previous cookie");
        fortunes.add("Enjoy yourself while you can");
        fortunes.add("Only listen to fortune cookies. Disregard all other fortune telling units.");
        fortunes.add("If you think we're going to sum up your whole life on this program you're crazy.");
        fortunes.add("If you think nobody cares if you are alive, trying missing a couple bill payments.");


        fortuneBtn = new JButton("Read My Fortune!");
        displayTA.setFont(new Font("Arial", Font.PLAIN, 12));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            fortunePicked = rnd.nextInt(12);
            while(fortunePicked == oldVal)
            {
                if (fortunePicked == 11)
                {
                    fortunePicked = 0;
                }
                else
                {
                    fortunePicked += 1;
                }
            }
            oldVal = fortunePicked;

            displayTA.append(fortunePicked + " " + fortunes.get(fortunePicked) + "\n");
        });

        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
        quitBtn.addActionListener(ActiveEvent_ae -> System.exit(0));
    }
}
