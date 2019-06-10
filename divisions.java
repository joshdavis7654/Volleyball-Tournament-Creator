
import java.util.ArrayList;
import java.util.Collections;

class divisions{
	
	private int divNum;
	private ArrayList<team> t;
	private ArrayList<team> temp;
	private ArrayList<ArrayList<team>> div;
	private ArrayList<game> games;
	private ArrayList<team> finals;
	private int count;
	private ArrayList<ArrayList<game>> divGames;
	
	public divisions(ArrayList<team> t,int divNum){
		this.t = t;  //initializes the team list
		count = 0;
		games = new ArrayList<game>();
		divGames = new ArrayList<ArrayList<game>>();  //starts a new array games list
		div = new ArrayList<ArrayList<team>>();
		this.divNum = divNum;
		int teamsInDiv = t.size()/divNum;
		for(int i = 0; i<divNum; i++){
			count = 0;
			temp = new ArrayList<team>();
			
			for(int j = 0; j<teamsInDiv;j++){
				temp.add(t.get(j));
			}
			
				
			
			div.add(temp);
			divGames.add(games);
		}
			for(int i = 0; i<div.size();i++){
				System.out.println("Team:" + div.get(0).get(i).getName());
			}
		for(int i = 0; i<div.size();i++){
			 
		
			for(int j = 0;j<div.get(i).size();j++){
				for(int k =1; k<div.get(i).size();k++){
					team a = div.get(i).get(0);
					team b = div.get(i).get(1);
					if(a==b){
						System.out.println("Same team");
						
					}
					else{
					game c= new game(a,b);
					divGames.get(i).add(c);
					}
					
				
				}
			}
		}
	}
	
		
		
		
		public void createBracket(){  //creates the starting single elimination bracket
			boolean com = true;
			for(int i = 0; i<div.size();i++){
				for(int j = 0;j<div.get(i).size();i++){
					
				}
			}
		
		}
	
	public ArrayList<team> getT(){
		return t;
	} 
	
	public ArrayList<ArrayList<team>> getDiv(){
		return div;
	}
	
	public ArrayList<game> getGames(){
		return games;
	}
	
	public ArrayList<ArrayList<game>> getL(){
		return divGames;
	}
}
	
	
	
	
	
