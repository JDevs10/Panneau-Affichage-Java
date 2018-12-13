
public class EquipeFoot extends EquipeAbstaite {

	public EquipeFoot(String sport, String teamName) {
		super(sport, teamName);
		// TODO Auto-generated constructor stub
	}
	
	public void fabriqueEquipeF() {
		
	}

	@Override
	public void addA() {
		// TODO Auto-generated method stub
		add(1);
		System.out.println("hello from team name: "+TeamName+", pacticing: "+Sport+" and we are at "+Score+" score");
	}

	@Override
	public void addB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void totalScore() {
		// TODO Auto-generated method stub
		System.out.println("Total score is "+Score);
	}

}
