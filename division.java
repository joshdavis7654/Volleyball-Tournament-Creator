import java.util.ArrayList;
import java.util.Collection;


class division {
	private int numDiv; //How many divisions. 
	private int divSize;//Ideally how many teams in each division
	private int numGames;
	private int gameNum;
	
	private ArrayList<team> t;  //list that holds the teams
	private ArrayList<team> temp;
	private ArrayList<game> games; 
	
	private ArrayList<ArrayList<team>> divsouter;
	private ArrayList<team> divsinner;
	private ArrayList<team> divs;
	
	private ArrayList<team> top;
	
	
	/* README
	 * 
	 * Should take a full list of teams t. You can call the methods to complete the process
	 * createDivs - sorts the list into divisions
	 * divPlayMatches(ArrayList) - makes each division play eachother once
	 * getDivWinner(ArrayList) -gets the division winner
	 * makeTop() - creates a list of the winning teams
	 * getWinner() - inserts top into single elim
	 * 
	 * divisions will be in an array list so methods that take a division should be divsouter.get(i)
	 * 
	 */
	public division(ArrayList<team> t, int d){  //division constructor. d is # of divisions

		this.numDiv = d;
		this.t = t;   
		
		divSize = t.size() / numDiv; //How many teams in a division
		
		if(divSize < 2 || divSize == 1){
		System.out.println("Invalid number of divisions");//Invalid division format
		
		
		
		//createDivs(t);
		
		}
		
		
	}
		
		
		
		public void createDivs(ArrayList<team> t){ //places teams into divisions    
			
			divsouter = new ArrayList<ArrayList<team>>();
			divsinner = new ArrayList<team>();            //ArrayLists within ArrayLists
			divs = new ArrayList<team>();
			
			
			int asize = t.size();
			int dsize = divSize;   //various helper ints
			int num = numDiv;
			int i = 0;
			int j = 0;
			int count = 0;
			int rem = asize % dsize;
			int divNumber = 1;
			
			for (i=0;i <num ;i++){  //for i less than number of divisions
				
				for(j=0;j<dsize;j++){ //places the min amount of teams in the division
				divsinner.add((team) t.get(count));
				count++;
				}
				
				if(rem !=0){
					divsinner.add((team) t.get(count)); //if remaineder inserts team into the division before moving on
					rem = rem - 1;
					count++;
				}
				
				j=0;
				divsouter.add((ArrayList<team>) divsinner); //adds the inner arraylist to the outer arraylist
				
				System.out.println("Division " + divNumber + "  "+ divsouter.get(i)); //helper for tracing
				divsinner.clear(); //clears to create divs
				divNumber++;
				}
			
		}
			
			
			
		
		
		
		public void divPlayMatches(ArrayList<team> d){ 
			
			games = new ArrayList<game>();  //creates the new games bracket
			System.out.println("Division ");
			for(int i = 0; i<d.size()-1; i++){
				
				for (int j= i+1; j<d.size(); j++){
	            
					game a = new game((team) d.get(i),(team) d.get(j));
					games.add(a);
					System.out.println("test: team " + d.get(i)+ " plays team " + d.get(j)); //helper info for tracing
					
					}
				
				}
			
			
	    	}
		
		
		
		public Object getDivWinner(ArrayList<team> d){ //gets division winner
			
			int i=0;
			int j=0;        //various counters
			int count =-1;
			temp = new ArrayList<team>();
			
			for(i=0;i<d.size();i++){
				
				if(((team) d.get(i)).getLosses() <= ((team) d.get(j)).getLosses()){ //if a has less losses than b
					
					count++;
					temp.add((team) d.get(count)); //add that team to a temp list
					}
				
			}
				
			
			System.out.println("Division winner is " + temp.get(count));
			
			return temp.get(count);
		}
		
		
		


	public void makeTop(){  //creates Arraylist of div winners
		top = new ArrayList<team>();
		int i;
		for(i=0;i<numDiv;i++){
			
			top.add((team) getDivWinner(divsouter.get(i))); //passes the arraylist from outer to get divwinner and adds that team to array list
			
		}
		
		System.out.println();
		
		}
		
		
			
	
		
	
	
	public Object getWinner(){ //gets winner from arraylist of division winners by placing in single elim tourny
		
		
		single a = new single(top);
		a.createBracket(); //create bracket should add the games to the games list
		a.advanceSchedule();
		a.printBracket();
		
		System.out.println(" ");
		
		
		return 0;
	}
	
}

