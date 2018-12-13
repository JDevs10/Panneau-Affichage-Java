import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.oracle.tools.packager.IOUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInitJson("C:\\Users\\J-LDS\\eclipse-workspace\\panneauD-Affichage\\src\\getSportEquipe.json");
		
		EquipeFoot ef = new EquipeFoot("foot", "foot name");
		EquipeRugby er = new EquipeRugby("rugby", "rugby name");
		EquipeBaskett eb = new EquipeBaskett("Baskett", "Baskett name");
		
		ef.addA();
		ef.totalScore();
		
		er.addA();
		er.totalScore();
		
		eb.addA();
		eb.addB();
		eb.addC();
		eb.totalScore();
	}
	
	public static void getInitJson(String file) {

	}

}
