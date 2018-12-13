
public class EquipeBaskett extends EquipeAbstaite {

	public EquipeBaskett(String sport, String teamName) {
		super(sport, teamName);
		// TODO Auto-generated constructor stub
	}
	
	public void fabriqueEquipeB() {
		
	}

	@Override
	protected void addA() {
		// TODO Auto-generated method stub
		add(1);
		System.out.println("hello from team name: "+TeamName+", pacticing: "+Sport+" and we are at "+Score+" score");
	}

	@Override
	protected void addB() {
		// TODO Auto-generated method stub
		add(2);
		System.out.println("hello from team name: "+TeamName+", pacticing: "+Sport+" and we are at "+Score+" score");
	}

	@Override
	protected void addC() {
		// TODO Auto-generated method stub
		add(3);
		System.out.println("hello from team name: "+TeamName+", pacticing: "+Sport+" and we are at "+Score+" score");
	}
	
	@Override
	protected void totalScore() {
		// TODO Auto-generated method stub
		System.out.println("Total score is "+Score);
	}

}
