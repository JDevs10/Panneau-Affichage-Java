
public class EquipeRugby extends EquipeAbstaite {

	public EquipeRugby(String sport, String teamName) {
		super(sport, teamName);
		// TODO Auto-generated constructor stub
	}
	
	public void fabriqueEquipeR() {
		
	}

	@Override
	protected void addA() {
		// TODO Auto-generated method stub
		add(5);
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
