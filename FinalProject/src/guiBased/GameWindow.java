package guiBased;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class GameWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel startingPane;
	private JPanel gamePane;
	
	private JMenuBar menuBar;
	
	private JMenuItem mntmStart;
	private JMenuItem mntmHowToPlay;
	private JMenuItem mntmQuit;
	private JMenuItem mntmPlayer;
	
	private StartMenu startMenu;
	private Game game;
	private LineBorder mntmBorder = new LineBorder(Color.BLACK);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		startingPane = new JPanel();
		startingPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		startingPane.setLayout(new BorderLayout(0, 0));
		
		buildMenu();
		
		startMenu = new StartMenu();
		startingPane.add(menuBar, BorderLayout.NORTH);
		startingPane.add(startMenu);
		
		contentPane = new JPanel(new BorderLayout());
		contentPane.add(startingPane, BorderLayout.CENTER);
		setContentPane(contentPane);
		
		gamePane = new JPanel();
		gamePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		gamePane.setLayout(new BorderLayout(0, 0));
		
		game = new Game();
	}
	
	private void buildMenu() {
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(5,5,470,20);
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(64, 64, 64), new Color(192, 192, 192)));
		menuBar.setBackground(Color.BLACK);
		
		mntmStart = new JMenuItem("Start Game");
		mntmStart.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		mntmStart.setBackground(Color.WHITE);
		mntmStart.setBorder(mntmBorder);
		mntmStart.addActionListener(this);
		menuBar.add(mntmStart);
		
		mntmHowToPlay = new JMenuItem("How To Play");
		mntmHowToPlay.setBackground(Color.WHITE);
		mntmHowToPlay.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		mntmHowToPlay.setBorder(mntmBorder);
		mntmHowToPlay.addActionListener(this);
		menuBar.add(mntmHowToPlay);
		
		mntmQuit = new JMenuItem("Quit");
		mntmQuit.setBackground(Color.WHITE);
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		mntmQuit.setBorder(mntmBorder);
		mntmQuit.addActionListener(this);
		menuBar.add(mntmQuit);
	}
	
	private void updateMenu() {
		menuBar.remove(mntmStart);
		menuBar.remove(mntmHowToPlay);
		
		mntmPlayer = new JMenuItem("Player ");
		mntmPlayer.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		mntmPlayer.setBackground(Color.WHITE);
		mntmPlayer.setBorder(mntmBorder);
		menuBar.add(mntmPlayer, 0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Start Game") {
			if (game.getNumOfPlayers() != 0) {
				contentPane.remove(startMenu);
			
				updateMenu();
				gamePane.add(menuBar);
			
				gamePane.add(game);
			
				contentPane.add(gamePane, BorderLayout.CENTER);
				contentPane.revalidate();
			} else {
				JLabel specifyNumber = new JLabel("Please Specify the Number of Players");
				specifyNumber.setBounds(20, 20, 50, 10);
				
				startMenu.add(specifyNumber);
				contentPane = new JPanel(new BorderLayout());
				contentPane.add(startingPane);
				setContentPane(contentPane);
				contentPane.revalidate();
			}
		} else if (e.getActionCommand() == "How To Play") {
			game.setNumOfPlayers(0);
			startMenu.howToPlay();
		} else if (e.getActionCommand() == "Quit") {
			this.dispose();
		}
	}

}
