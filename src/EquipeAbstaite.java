
public abstract class EquipeAbstaite {
	String Sport;
	String TeamName;
	int Score;
	
	public EquipeAbstaite(String sport, String teamName) {
		Sport = sport;
		TeamName = teamName;
		this.Score = 0;
	}
	
	protected void add(int score) {
		Score += score;
	}
	
	protected abstract void addA();
	
	protected abstract void addB();
	
	protected abstract void addC();
	
	protected abstract void totalScore();
}
