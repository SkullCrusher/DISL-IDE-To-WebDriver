import java.util.ArrayList;

public class ConvertedScript {
	
	private String Name;
	private ArrayList<Command> Commands;
	
	private String Converted = "";

	public ConvertedScript(String TestName, ArrayList<Command> commands){
		Name = TestName;
		Commands = commands;
	}
	
	public void Process(Generate_Lexicon Lexicons){
		
		for(int i = 0; i < Commands.size(); i++){
			Converted += HandleCommand.Process(Commands.get(i), Lexicons);
		}		
	}
	
	public String GetConverted(){
		return Converted;
	}
	
	public String GetName(){
		return Name;
	}
	
}
