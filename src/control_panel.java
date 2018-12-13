import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.json.Json;
import javax.json.JsonObject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class control_panel extends EquipeAbstaite {
	
	EquipeFoot ef1,ef2;
	EquipeRugby er1,er2;
	EquipeBaskett eb1,eb2;
	
	private boolean check_pause = true;
	
	private int iscore = 0;
	private int tscore = 0;

	private JFrame frame;
	private JComboBox comboBox_domicile;
	private JComboBox comboBox_invite;
	private JComboBox comboBox_sport;
	private JButton btn_newMatch;
	private JButton btn_pause;
	private JButton button_plusInTeamHome_addA;
	private JButton button_plusInTeamHome_addB;
	private JButton button_plusInTeamHome_addC;
	private JButton button_plusInTeamGuess_addA;
	private JButton button_plusInTeamGuess_addB;
	private JButton button_plusInTeamGuess_addC;
	private JLabel lbl_ShowJson;
	private JLabel lb_eq1_score_Label;
	private JLabel lb_eq2_score_Label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					control_panel window = new control_panel();
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
	public control_panel() {
		super("sport", "teamName");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btn_newMatch = new JButton("Nouvelle partie");
		btn_newMatch.setBounds(140, 132, 120, 23);
		frame.getContentPane().add(btn_newMatch);
		
		comboBox_domicile = new JComboBox();
		comboBox_domicile.setBounds(10, 36, 150, 22);
		frame.getContentPane().add(comboBox_domicile);
		comboBox_domicile.addItem("Equipe 1");/*
		comboBox_domicile.addItem("France");
		comboBox_domicile.addItem("Espagne");
		comboBox_domicile.addItem("Italy");
		comboBox_domicile.addItem("Allemagne");
		*/
		
		JLabel lblDomicile = new JLabel("Domicile");
		lblDomicile.setBounds(10, 11, 63, 14);
		frame.getContentPane().add(lblDomicile);
		
		JLabel lblInvite = new JLabel("Invite");
		lblInvite.setBounds(338, 11, 46, 14);
		frame.getContentPane().add(lblInvite);
		
		comboBox_invite = new JComboBox();
		comboBox_invite.setBounds(234, 36, 150, 22);
		frame.getContentPane().add(comboBox_invite);
		comboBox_invite.addItem("Equipe 2");/*
		comboBox_invite.addItem("France");
		comboBox_invite.addItem("Espagne");
		comboBox_invite.addItem("Italy");
		comboBox_invite.addItem("Allemagne");
		*/
		
		comboBox_sport = new JComboBox();
		comboBox_sport.setBounds(140, 99, 120, 22);
		frame.getContentPane().add(comboBox_sport);
		comboBox_sport.addItem("Sport");/*
		comboBox_sport.addItem("FootBall");
		comboBox_sport.addItem("Rugby");
		comboBox_sport.addItem("Baskett");
		*/
		
		btn_pause = new JButton("Pause");
		btn_pause.setBounds(140, 166, 120, 23);
		frame.getContentPane().add(btn_pause);
		btn_pause.setEnabled(false);
		
		button_plusInTeamHome_addA = new JButton("+1");
		button_plusInTeamHome_addA.setBounds(140, 200, 50, 23);
		frame.getContentPane().add(button_plusInTeamHome_addA);
		button_plusInTeamHome_addA.setEnabled(false);
		
		button_plusInTeamHome_addB = new JButton("+1");
		button_plusInTeamHome_addB.setEnabled(false);
		button_plusInTeamHome_addB.setBounds(140, 234, 50, 23);
		frame.getContentPane().add(button_plusInTeamHome_addB);
		
		button_plusInTeamHome_addC = new JButton("+1");
		button_plusInTeamHome_addC.setEnabled(false);
		button_plusInTeamHome_addC.setBounds(140, 268, 50, 23);
		frame.getContentPane().add(button_plusInTeamHome_addC);
		
		button_plusInTeamGuess_addA = new JButton("+1");
		button_plusInTeamGuess_addA.setBounds(210, 200, 50, 23);
		frame.getContentPane().add(button_plusInTeamGuess_addA);
		button_plusInTeamGuess_addA.setEnabled(false);
		
		button_plusInTeamGuess_addB = new JButton("+1");
		button_plusInTeamGuess_addB.setEnabled(false);
		button_plusInTeamGuess_addB.setBounds(210, 234, 50, 23);
		frame.getContentPane().add(button_plusInTeamGuess_addB);
		
		button_plusInTeamGuess_addC = new JButton("+1");
		button_plusInTeamGuess_addC.setEnabled(false);
		button_plusInTeamGuess_addC.setBounds(210, 268, 50, 23);
		frame.getContentPane().add(button_plusInTeamGuess_addC);
		
		lbl_ShowJson = new JLabel("Show JSon");
		lbl_ShowJson.setBounds(75, 300, 300, 115);
		frame.getContentPane().add(lbl_ShowJson);
		
		lb_eq1_score_Label = new JLabel("Equipe 1 score: 0");
		lb_eq1_score_Label.setBounds(30, 204, 110, 14);
		frame.getContentPane().add(lb_eq1_score_Label);
		
		lb_eq2_score_Label = new JLabel("Equipe 2 score: 0");
		lb_eq2_score_Label.setBounds(270, 204, 110, 14);
		frame.getContentPane().add(lb_eq2_score_Label);
		
		//fill the combo box
		fillComboBox();
		
		//button
		btn_newMatch.addActionListener(new ActionListener() {
			private boolean check = true;
			public void actionPerformed(ActionEvent e) {
				if(comboBox_domicile.getSelectedItem() != "Equipe 1" && comboBox_invite.getSelectedItem() != "Equipe 2" && comboBox_sport.getSelectedItem() != "Sport") {
					if (check) {
						comboBox_domicile.setEnabled(false);
						comboBox_invite.setEnabled(false);
						comboBox_sport.setEnabled(false);
						
						checkSport(comboBox_sport.getSelectedItem().toString());
											
						
						btn_pause.setEnabled(true);
						
						if(comboBox_sport.getSelectedItem().toString().equals("FootBall")) {
							button_plusInTeamHome_addA.setText("+1");
							button_plusInTeamGuess_addA.setText("+1");
							
							button_plusInTeamHome_addA.setEnabled(true);
							button_plusInTeamGuess_addA.setEnabled(true);
							
							button_plusInTeamHome_addB.setEnabled(false);
							button_plusInTeamGuess_addB.setEnabled(false);
							
							button_plusInTeamHome_addC.setEnabled(false);
							button_plusInTeamGuess_addC.setEnabled(false);
						}
						
						if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
							button_plusInTeamHome_addA.setText("+5");
							button_plusInTeamGuess_addA.setText("+5");
							button_plusInTeamHome_addB.setText("+2");
							button_plusInTeamGuess_addB.setText("+2");
							button_plusInTeamHome_addC.setText("+3");
							button_plusInTeamGuess_addC.setText("+3");
							
							button_plusInTeamHome_addA.setEnabled(true);
							button_plusInTeamGuess_addA.setEnabled(true);
							
							button_plusInTeamHome_addB.setEnabled(true);
							button_plusInTeamGuess_addB.setEnabled(true);
							
							button_plusInTeamHome_addC.setEnabled(true);
							button_plusInTeamGuess_addC.setEnabled(true);
						}
						
						if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
							button_plusInTeamHome_addA.setText("+1");
							button_plusInTeamGuess_addA.setText("+1");
							button_plusInTeamHome_addB.setText("+2");
							button_plusInTeamGuess_addB.setText("+2");
							button_plusInTeamHome_addC.setText("+3");
							button_plusInTeamGuess_addC.setText("+3");
							
							button_plusInTeamHome_addA.setEnabled(true);
							button_plusInTeamGuess_addA.setEnabled(true);
							
							button_plusInTeamHome_addB.setEnabled(true);
							button_plusInTeamGuess_addB.setEnabled(true);
							
							button_plusInTeamHome_addC.setEnabled(true);
							button_plusInTeamGuess_addC.setEnabled(true);
						}
						
						btn_newMatch.setText("Fin partie");
						check = false;
						System.out.println("The match is Started");
					} else {
						lb_eq1_score_Label.setText("Equipe 1 score: 0");
						lb_eq2_score_Label.setText("Equipe 2 score: 0");
						
						comboBox_domicile.setEnabled(true);
						comboBox_invite.setEnabled(true);
						comboBox_sport.setEnabled(true);
						
						btn_pause.setEnabled(false);
						button_plusInTeamHome_addA.setEnabled(false);
						button_plusInTeamGuess_addA.setEnabled(false);
						
						button_plusInTeamHome_addB.setEnabled(false);
						button_plusInTeamGuess_addB.setEnabled(false);
						
						button_plusInTeamHome_addC.setEnabled(false);
						button_plusInTeamGuess_addC.setEnabled(false);
						check = true;
						
						//write json file with all the sport and team info
						writeJSON();
						
						btn_newMatch.setText("Nouvelle partie");
						System.out.println("The match is finished");
					}
				}else {
					System.out.println("Please select a valid item in all drop down list");
				}
				
			}
		});
		
		btn_pause.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					button_plusInTeamHome_addA.setEnabled(false);
					button_plusInTeamGuess_addA.setEnabled(false);
					
					button_plusInTeamHome_addB.setEnabled(false);
					button_plusInTeamGuess_addB.setEnabled(false);
					
					button_plusInTeamHome_addC.setEnabled(false);
					button_plusInTeamGuess_addC.setEnabled(false);
					check_pause = false;
					btn_pause.setText("Resume");
				} else {
					if(comboBox_sport.getSelectedItem().toString().equals("FootBall")) {
						button_plusInTeamHome_addA.setEnabled(true);
						button_plusInTeamGuess_addA.setEnabled(true);
					}else {
						button_plusInTeamHome_addA.setEnabled(true);
						button_plusInTeamGuess_addA.setEnabled(true);
						
						button_plusInTeamHome_addB.setEnabled(true);
						button_plusInTeamGuess_addB.setEnabled(true);
						
						button_plusInTeamHome_addC.setEnabled(true);
						button_plusInTeamGuess_addC.setEnabled(true);
					}
					
					check_pause = true;
					btn_pause.setText("Pause");
				}
				System.out.println(btn_pause.getText()+" is clicked"); 
			}
		});
		
		button_plusInTeamHome_addA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("FootBall")) {
						ef1.addA();
						lb_eq1_score_Label.setText("Equipe 1 score: "+ef1.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er1.addA();
						lb_eq1_score_Label.setText("Equipe 1 score: "+er1.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb1.addA();
						lb_eq1_score_Label.setText("Equipe 1 score: "+eb1.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
		button_plusInTeamHome_addB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er1.addB();
						lb_eq1_score_Label.setText("Equipe 1 score: "+er1.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb1.addB();
						lb_eq1_score_Label.setText("Equipe 1 score: "+eb1.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
		button_plusInTeamHome_addC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er1.addC();
						lb_eq1_score_Label.setText("Equipe 1 score: "+er1.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb1.addC();
						lb_eq1_score_Label.setText("Equipe 1 score: "+eb1.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
		button_plusInTeamGuess_addA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("FootBall")) {
						ef2.addA();
						lb_eq2_score_Label.setText("Equipe 2 score: "+ef2.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er2.addA();
						lb_eq2_score_Label.setText("Equipe 2 score: "+er2.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb2.addA();
						lb_eq2_score_Label.setText("Equipe 2 score: "+eb2.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
		button_plusInTeamGuess_addB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er2.addB();
						lb_eq2_score_Label.setText("Equipe 2 score: "+er2.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb2.addB();
						lb_eq2_score_Label.setText("Equipe 2 score: "+eb2.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
		button_plusInTeamGuess_addC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_pause) {
					if(comboBox_sport.getSelectedItem().toString().equals("Rugby")) {
						er2.addC();
						lb_eq2_score_Label.setText("Equipe 2 score: "+er2.Score);
					}
					
					if(comboBox_sport.getSelectedItem().toString().equals("Baskett")) {
						eb2.addC();
						lb_eq2_score_Label.setText("Equipe 2 score: "+eb2.Score);
					}
					
				} else {
					System.out.println("The match is on pause !!");
				}
			}
		});
		
	}
	
	private void fillComboBox() {
		String txtFile = "comboBox-info.txt";
		
		try {
			
			List<String> lines = Files.readAllLines(Paths.get(txtFile));
			
			for(String line : lines) {
            	String[] verticalLine = line.split(",");
            	String[] horizontalLine = line.split(";");
            	System.out.println("horizontalLine : "+horizontalLine[0]+" \nverticalLine : "+verticalLine[0]);
            	
            	for (int i = (verticalLine.length)-1; i < verticalLine.length; i++) {
            		if(verticalLine[0].equals("Teams")) {
            			for (int j = 1; j < verticalLine.length; j++) {
            				System.out.println("value: "+verticalLine.length+" ; value txt: "+verticalLine[j]);
            				comboBox_domicile.addItem(verticalLine[j]);
                            comboBox_invite.addItem(verticalLine[j]);
						}
            		}
					
            		if(verticalLine[0].equals("Sport")) {
            			for (int j = 1; j < verticalLine.length; j++) {
            				System.out.println("value: "+verticalLine.length+" ; value txt: "+verticalLine[j]);
            				comboBox_sport.addItem(verticalLine[j]);
						}
            		}
				}
            }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void checkSport(String sportType){
		switch(sportType) {
		case "FootBall": 
			ef1 = new EquipeFoot(sportType, comboBox_domicile.getSelectedItem().toString());
			ef2 = new EquipeFoot(sportType, comboBox_invite.getSelectedItem().toString());
			
			System.out.println("footBall teams were created");
			break;
		
		case "Rugby":
			er1 = new EquipeRugby(sportType, comboBox_domicile.getSelectedItem().toString());
			er2 = new EquipeRugby(sportType, comboBox_invite.getSelectedItem().toString());

			System.out.println("rugby teams were created");
			break;
		
		case "Baskett":
			eb1 = new EquipeBaskett(sportType, comboBox_domicile.getSelectedItem().toString());
			eb2 = new EquipeBaskett(sportType, comboBox_invite.getSelectedItem().toString());
			
			System.out.println("baskett teams were created");
			break;
		}
	}
	
	private void writeJSON() {
		//write my json
		JsonObject personObject = null;
		
		if(comboBox_sport.getSelectedItem().equals("FootBall")) {
			personObject = Json.createObjectBuilder()
	                .add("Sport", comboBox_sport.getSelectedItem().toString())
	                .add("Home team", Json.createObjectBuilder().add("Name", ef1.TeamName)
	                                               				.add("Score", ef1.Score)
	                                               				.build()
	                    )
	                .add("Guess team", Json.createObjectBuilder().add("Name", ef2.TeamName)
	           													.add("Score", ef2.Score)
	           													.build()
	                ).build();
		}
		
		if(comboBox_sport.getSelectedItem().equals("Rugby")) {
			personObject = Json.createObjectBuilder()
	                .add("Sport", comboBox_sport.getSelectedItem().toString())
	                .add("Home team", Json.createObjectBuilder().add("Name", er1.TeamName)
	                                               				.add("Score", er1.Score)
	                                               				.build()
	                    )
	                .add("Guess team", Json.createObjectBuilder().add("Name", er2.TeamName)
	           													.add("Score", er2.Score)
	           													.build()
	                ).build();
		}
		
		if(comboBox_sport.getSelectedItem().equals("Baskett")) {
			personObject = Json.createObjectBuilder()
	                .add("Sport", comboBox_sport.getSelectedItem().toString())
	                .add("Home team", Json.createObjectBuilder().add("Name", eb1.TeamName)
	                                               				.add("Score", eb1.Score)
	                                               				.build()
	                    )
	                .add("Guess team", Json.createObjectBuilder().add("Name", eb2.TeamName)
	           													.add("Score", eb2.Score)
	           													.build()
	                ).build();
		}
		
		//create the json file
		try {
			PrintWriter pw = new PrintWriter(new File("rencontre-results.json"));
			
			pw.println(personObject);
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        System.out.println("Object: " + personObject);
      lbl_ShowJson.setText("Inside my JSon file: \n"+personObject);
	}
	

	@Override
	protected void addA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void totalScore() {
		// TODO Auto-generated method stub
		
	}
}
