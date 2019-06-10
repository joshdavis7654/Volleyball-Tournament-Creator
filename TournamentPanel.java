import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TournamentPanel extends Panel{
	//Initialize Variables/ Components
	private ArrayList<Tournament> tournaments = new ArrayList();
	private Tournament activeTournament = new Tournament("Default");
	private JFrame ntour;
	private JFrame nteam;
	private JLabel tList;
	private JLabel chooseBracket;
	private JLabel enterName;
	private JButton start; 
	private JComboBox tournamentList;
	private JButton newTournament;
	private JComboBox teamList;
	private JButton newTeam;
	private JRadioButton singleElim;
	private JRadioButton doubleElim;
	private JRadioButton divisions;
	private JTextField newTournamentName;
	private JButton confirmTournament;
	private JRadioButton good;
	private JTextArea players;
	private JTextField newTeamName;
	private JTextField coachName;
	private JButton confirmTeam;
	private JButton scoreMatch;
	private JTextField teamAScore;
	private JTextField teamBScore;
	private JComboBox matchList;
	final DefaultComboBoxModel model = new DefaultComboBoxModel(tournaments.toArray());
	final DefaultComboBoxModel model2 = new DefaultComboBoxModel((activeTournament.getList()).toArray());
	final DefaultComboBoxModel model3 = new DefaultComboBoxModel((activeTournament.getBracket().getGames()).toArray());
    
	//Constructor for main panel
	public TournamentPanel(){
		
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.setBounds(226, 177, 89, 23);
		//Create sub panels
		JTabbedPane tabs = new JTabbedPane();
		JPanel tPanel = new JPanel();
		JPanel teamPanel = new JPanel();
		JPanel schedulePanel = new JPanel();
		JPanel scorePanel = new JPanel();
		JPanel grid1 = new JPanel();
		JPanel grid2 = new JPanel();
		
		//add tabs to tabbed pane
		tabs.addTab("Tournament Select", tPanel );
		tabs.addTab("Team Management", teamPanel );
		//tabs.addTab("Login", accountPanel );
		tabs.addTab("View Schedule", schedulePanel );
		tabs.addTab("Match Scoring", scorePanel);
		
		//Create components
		tList = new JLabel("Select a Tournament from the list to make it active");
		newTournament = new JButton("Create New");
	    tournamentList = new JComboBox(model);
		newTeam = new JButton("Create New");
		teamList = new JComboBox(model2);
		scoreMatch = new JButton("Submit Scores");
		teamAScore = new JTextField(5);
		teamBScore = new JTextField(5);
		matchList = new JComboBox(model3);
		start = new JButton("Create bracket with current teams");
		
		//Create and add action listener
		startListener sl = new startListener();
		start.addActionListener(sl);
		submitScoreListener ssl = new submitScoreListener();
		scoreMatch.addActionListener(ssl);
		newTournamentListener ntl = new newTournamentListener();
		newTournament.addActionListener(ntl);
		tournamentListListener tll = new tournamentListListener();
		tournamentList.addActionListener(tll);
		newTeamListener ntel = new newTeamListener();
		newTeam.addActionListener(ntel);
		
		//set layouts
		grid1.setLayout(new BorderLayout());
		grid2.setLayout(new GridLayout(0,2));
		
		//And components to Panels
		tPanel.setPreferredSize(new Dimension(640, 480));
		grid1.add(tList,BorderLayout.CENTER);
		grid1.add(grid2,BorderLayout.SOUTH);
		grid2.add(tournamentList);
		grid2.add(newTournament);
		grid2.add(start);
		tPanel.add(grid1);
		teamPanel.add(newTeam);
		teamPanel.add(teamList);
		scorePanel.add(scoreMatch);
		scorePanel.add(teamAScore);
		scorePanel.add(teamBScore);
		scorePanel.add(matchList);
		add(tabs);
	
	}
	
	//Action Listeners
	class newTeamListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JPanel newTeamPanel = new JPanel();
			good = new JRadioButton("Is this team a designated top team?");
			confirmTeam = new JButton("Confirm");
			newTeamName = new JTextField(10);
			coachName = new JTextField(10);
			players = new JTextArea(10,8);
			confirmTeamListener ctl = new confirmTeamListener();
			confirmTeam.addActionListener(ctl);
			newTeamPanel.add(good);
			newTeamPanel.add(confirmTeam);
			newTeamPanel.add(newTeamName);
			newTeamPanel.add(coachName);
			newTeamPanel.add(players);
			nteam = new JFrame ("Create New Team");
			nteam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			nteam.getContentPane().add(newTeamPanel);
			nteam.pack();
			nteam.setVisible (true);
		}
	}
	class newTournamentListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JPanel newTournamentPanel = new JPanel();
			chooseBracket = new JLabel("Select a type of bracket");
			enterName = new JLabel("Enter a name for the tournament");
			confirmTournament = new JButton("Confirm");
			newTournamentName = new JTextField(10);
			singleElim = new JRadioButton("Single Elimination");
			doubleElim = new JRadioButton("Double Elimination");
			divisions = new JRadioButton("Divisions");
			ButtonGroup bracketType = new ButtonGroup();
			bracketType.add(singleElim);
			bracketType.add(doubleElim);
			bracketType.add(divisions);
			confirmTournamentListener ctl = new confirmTournamentListener();
			confirmTournament.addActionListener(ctl);
			newTournamentPanel.add(chooseBracket);
			newTournamentPanel.add(enterName);
			newTournamentPanel.add(singleElim);
			newTournamentPanel.add(doubleElim);
			newTournamentPanel.add(divisions);
			newTournamentPanel.add(confirmTournament);
			newTournamentPanel.add(newTournamentName);
			ntour = new JFrame ("Create New Tournament");
			ntour.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ntour.getContentPane().add(newTournamentPanel);
			ntour.pack();
			ntour.setVisible (true);
		}

	}
	class confirmTeamListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			team temp = new team(newTeamName.getText(),good.isSelected());
			activeTournament.addTeam(temp);
			model2.addElement(temp);
			//coachName.getText();
			nteam.dispatchEvent(new WindowEvent(nteam, WindowEvent.WINDOW_CLOSING));
		}
	}
	class confirmTournamentListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Tournament temp = new Tournament(newTournamentName.getText());
			if(singleElim.isSelected()){
				temp.setbracketCode(0);
			}
			if(doubleElim.isSelected()){
				temp.setbracketCode(1);
			}
			if(divisions.isSelected()){
				temp.setbracketCode(2);
			}
			tournaments.add(temp);
			model.addElement(temp);
			ntour.dispatchEvent(new WindowEvent(ntour, WindowEvent.WINDOW_CLOSING));
		}
	}
	class submitScoreListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			new inputScore((game)matchList.getSelectedItem(),Integer.parseInt(teamAScore.getText()),Integer.parseInt(teamBScore.getText()));
			model3.removeAllElements();
			boolean allComplete = true;
			for(int i = 0; i < activeTournament.getBracket().getGames().size();i++){
				if(activeTournament.getBracket().getGames().get(i).getComplete() == false){
					allComplete = false;
				}
			}
			if(allComplete){
				activeTournament.getBracket().advanceSchedule();
				//activeTournament.getBracket().advanceSchedule();
			}
			
			Object[] templist = activeTournament.getBracket().getGames().toArray();
			for(int i = 0; i < templist.length; i++){
				if(((game)templist[i]).getComplete() == false){
				model3.addElement((game)templist[i]);
				}
			}
		}
	}
	class tournamentListListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			activeTournament = (Tournament)tournamentList.getSelectedItem();
			model2.removeAllElements();
			Object[] templist = activeTournament.getList().toArray();
			for(int i = 0; i < templist.length; i++){
				model2.addElement((team)templist[i]);
			}
		}
	}
	class startListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			activeTournament.createBracket(activeTournament.getList());
			model3.removeAllElements();
			if(activeTournament.getBracket().getGames().toArray().length == 0){
				activeTournament.getBracket().advanceSchedule();
			}
			Object[] templist = activeTournament.getBracket().getGames().toArray();
			for(int i = 0; i < templist.length; i++){
				if(((game)templist[i]).getComplete() == false){
				model3.addElement((game)templist[i]);
				}
			}
		}
	}
}