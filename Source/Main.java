
public class Main {

	public static void main(String[] args) {

		String Before = Parser.Raw_Load("C:\\Users\\Sheldon\\workspace\\DavidIsSuperLazy\\Example_IDE.html");
		
		String After = Parser.Raw_Load("C:\\Users\\Sheldon\\workspace\\DavidIsSuperLazy\\Example_IDE.html");
		
		String Spacer = "\n\n/*DISL: Converter : ---------------------------*/\n\n";
		
		
			// The list of lexicons
		Generate_Lexicon Lexicons = new Generate_Lexicon();
				
			// Load the script.
		ConvertedScript Test = Parser.Load_File("C:\\Users\\Sheldon\\workspace\\DavidIsSuperLazy\\Example_IDE.html");
		
			// Process the script.
		Test.Process(Lexicons);
		
		//Parser.Dump_File("C:\\Users\\Sheldon\\workspace\\DavidIsSuperLazy\\" + Test.GetName() + ".java", Test.GetConverted());	
	
	
		// Example how to dump it.
		Parser.Dump_File("C:\\Users\\Sheldon\\workspace\\DavidIsSuperLazy\\" + Test.GetName() + ".java", Before + Spacer + Test.GetConverted() + Spacer + After);	
		
	}
}
