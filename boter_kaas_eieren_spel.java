package boter_kaas_eieren_spel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class boter_kaas_eieren_spel implements ActionListener {

	private JFrame frame;
	String[][] huidigspel = new String[3][3];
	String button0 = " ";
	String button1 = " ";
	String button2 = " ";
	String button3 = " ";
	String button4 = " ";
	String button5 = " ";
	String button6 = " ";
	String button7 = " ";
	String button8 = " ";
	String x = "X";
	// wie is er aan de beurt? player1 ("X") = 0, player2 ("0") = 1
	int beurt = 0;
	// Bijhouden van scores
	int scoreplayer1 = 0;
	int scoreplayer2 = 0;
	
	//De winnaar is: 0 = nog niemand (draw), 1 = player 1, 2 = player 3
	int winnaar = 0;
	// check of de winaar er al is
	boolean check;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					boter_kaas_eieren_spel window = new boter_kaas_eieren_spel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public boter_kaas_eieren_spel() {
		
		reset(huidigspel);
		initialize();
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private String[][] reset(String[][] huidigspel) {
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				huidigspel[x][y] = " ";
			}
		}
		
		return huidigspel;
		
	}
	
	public boolean checkwinnaar(String[][] huidigspel) {
		// van boven naar beneden
		if (	(huidigspel[0][0] == "X" && huidigspel[0][1] == "X" && huidigspel[0][2] == "X") || 
				(huidigspel[1][0] == "X" && huidigspel[1][1] == "X" && huidigspel[1][2] == "X") ||
				(huidigspel[2][0] == "X" && huidigspel[2][1] == "X" && huidigspel[2][2] == "X")) {
			winnaar = 1;
			return true;
			
		} else if (		(huidigspel[0][0] == "0" && huidigspel[0][1] == "0" && huidigspel[0][2] == "0") || 
						(huidigspel[1][0] == "0" && huidigspel[1][1] == "0" && huidigspel[1][2] == "0") ||
						(huidigspel[2][0] == "0" && huidigspel[2][1] == "0" && huidigspel[2][2] == "0")) {
			winnaar = 2;
			return true;
			
		}
		// van links naar rechts
		if ((	 huidigspel[0][0] == "X" && huidigspel[1][0] == "X" && huidigspel[2][0] == "X") || 
				(huidigspel[0][1] == "X" && huidigspel[1][1] == "X" && huidigspel[2][1] == "X") ||
				(huidigspel[0][2] == "X" && huidigspel[1][2] == "X" && huidigspel[2][2] == "X")) {
			winnaar = 1;
			return true;
			
		} else if (		(huidigspel[0][0] == "0" && huidigspel[1][0] == "0" && huidigspel[2][0] == "0") || 
						(huidigspel[0][1] == "0" && huidigspel[1][1] == "0" && huidigspel[2][1] == "0") ||
						(huidigspel[0][2] == "0" && huidigspel[1][2] == "0" && huidigspel[2][2] == "0")) {
			winnaar = 2;
			return true;
		}
		
		// schuin links en rechts
		if(				(huidigspel[0][0] == "X" && huidigspel[1][1] == "X" && huidigspel[2][2] == "X") || 
						(huidigspel[0][2] == "X" && huidigspel[1][1] == "X" && huidigspel[2][0] == "X")) {
				winnaar = 1;
				return true;
			} 
		else if (		(huidigspel[0][0] == "0" && huidigspel[1][1] == "0" && huidigspel[2][2] == "0") || 
						(huidigspel[0][2] == "0" && huidigspel[1][1] == "0" && huidigspel[2][0] == "0")){
				winnaar = 2;
				return true;
		}
		
		return false;
		
	}
	//deze methode start de JFrame waarmee de GUI wordt gebouwd
	private void initialize() {
		frame = new JFrame();
		JLabel playerscore1 = new JLabel("Aantal zetten Speler 1: " + scoreplayer1);
		JLabel playerscore2 = new JLabel("Aantal zetten Speler 2: " + scoreplayer2);
		
		//veld_00 wordt hier gemaakt. 
		JButton veld_00 = new JButton(button0);
		veld_00.setFont(new Font("Tahoma", Font.BOLD, 40));
		//als er op deze button wordt geklikt dan.......
		veld_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (beurt == 0 && veld_00.getText() != "0" && veld_00.getText() != "X") {
					veld_00.setText("X");
					huidigspel[0][0] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
					
				} else if (beurt == 1 && veld_00.getText() != "0" && veld_00.getText() != "X") {
					veld_00.setText("0");
					huidigspel[0][0] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
	
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel); 
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		frame.getContentPane().add(veld_00);
		//Andere buttons zijn nagenoeg hetzelfde. Er zal verbetering moeten plaatsvinden 
		//Wdoor het gebruik van meerdere methodes. Ben daar echter niet aan toe gekomen. 
		JButton veld_01 = new JButton(button1);
		veld_01.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beurt == 0 && veld_01.getText() != "0" && veld_01.getText() != "X") {
					veld_01.setText("X");
					huidigspel[0][1] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
					}
				 else if (beurt == 1 && veld_01.getText() != "0" && veld_01.getText() != "X") {
					veld_01.setText("0");
					huidigspel[0][1] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_01);
		
		JButton veld_02 = new JButton(button2);
		veld_02.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (beurt == 0 && veld_02.getText() != "0" && veld_02.getText() != "X") {
					veld_02.setText("X");
					huidigspel[0][2] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
					}
				 else if (beurt == 1 && veld_02.getText() != "0" && veld_02.getText() != "X") {
					veld_02.setText("0");
					huidigspel[0][2] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
					} 
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_02);
		
		JButton veld_10 = new JButton(button3);
		veld_10.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (beurt == 0 && veld_10.getText() != "0" && veld_10.getText() != "X") {
					veld_10.setText("X");
					huidigspel[1][0] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
				} else if (beurt == 1 && veld_10.getText() != "0" && veld_10.getText() != "X") {
					veld_10.setText("0");
					huidigspel[1][0] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_10);
		
		JButton veld_11 = new JButton(button4);
		veld_11.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beurt == 0 && veld_11.getText() != "0" && veld_11.getText() != "X") {
					veld_11.setText("X");
					huidigspel[1][1] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
				} else if (beurt == 1 && veld_11.getText() != "0" && veld_11.getText() != "X") {
					veld_11.setText("0");
					huidigspel[1][1] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel!", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_11);
		
		JButton veld_12 = new JButton(button5);
		veld_12.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beurt == 0 && veld_12.getText() != "0" && veld_12.getText() != "X") {
					veld_12.setText("X");
					huidigspel[1][2] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
				} else if (beurt == 1 && veld_12.getText() != "0" && veld_12.getText() != "X") {
					veld_12.setText("0");
					huidigspel[1][2] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_12);
		
		JButton veld_20 = new JButton(button6);
		veld_20.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (beurt == 0 && veld_20.getText() != "0" && veld_20.getText() != "X") {
					veld_20.setText("X");
					huidigspel[2][0] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
				} else if (beurt == 1 && veld_20.getText() != "0" && veld_20.getText() != "X") {
					veld_20.setText("0");
					huidigspel[2][0] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel.", 1);
				}
			}
		});
		frame.getContentPane().add(veld_20);
		
		JButton veld_21 = new JButton(button7);
		veld_21.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beurt == 0 && veld_21.getText() != "0" && veld_21.getText() != "X") {
					veld_21.setText("X");
					huidigspel[2][1] = "X";
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);	
				} else if (beurt == 1 && veld_21.getText() != "0" && veld_21.getText() != "X") {
					veld_21.setText("0");
					huidigspel[2][1] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
					}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		frame.getContentPane().add(veld_21);
		
		JButton veld_22 = new JButton(button8);
		veld_22.setFont(new Font("Tahoma", Font.BOLD, 40));
		veld_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (beurt == 0 && veld_22.getText() != "0" && veld_22.getText() != "X") {
					huidigspel[2][2] = "X";
					veld_22.setText(huidigspel[2][2]);
					beurt = 1;
					scoreplayer1++;
					playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
					
				} else if (beurt == 1 && veld_22.getText() != "0" && veld_22.getText() != "X") {
					veld_22.setText("0");
					huidigspel[2][2] = "0";
					beurt = 0;
					scoreplayer2++;
					playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				}
				check = checkwinnaar(huidigspel);
				if (check == true) {
					JOptionPane.showMessageDialog(frame, 
							"Speler " + winnaar + " heeft gewonnen gefeliciteerd! Door op reset te klikken kunt u opnieuw beginnen.", 
							"EN DE WINNAAR is: ", 1);
					check = false;
				}
				check = checkwinnaar(huidigspel);
				if ((scoreplayer1 + scoreplayer2) >= 9 && check == false) {
					JOptionPane.showMessageDialog(frame, "Het is gelijkspel! Door op reset te klikken kunt u opnieuw beginnen.", "Gelijkspel", 1);
				}
			}
		});
		
		
		frame.getContentPane().add(veld_22);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.setFont(new Font("Tahoma", Font.BOLD, 40));
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				veld_00.setText(" ");
				veld_01.setText(" ");
				veld_02.setText(" ");
				veld_10.setText(" ");
				veld_11.setText(" ");
				veld_12.setText(" ");
				veld_20.setText(" ");
				veld_21.setText(" ");
				veld_22.setText(" ");
				
				reset(huidigspel);
				beurt = 0;
				scoreplayer1 = 0;
				scoreplayer2 = 0;
				playerscore1.setText("Aantal zetten Speler 1: " + scoreplayer1);
				playerscore2.setText("Aantal zetten Speler 2: " + scoreplayer2);
				winnaar = 0;
				}
		});
		
		
		frame.getContentPane().add(resetbtn);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		playerscore1.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(playerscore1);
		playerscore2.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(playerscore2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
