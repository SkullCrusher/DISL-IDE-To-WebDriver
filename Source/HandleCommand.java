
public class HandleCommand {

	public static String Process(Command arg, Generate_Lexicon lexicons) {
		
		// Find the command and generate the string for it.
		Lexicon Rule = lexicons.GetLexicon(arg.Name);
		
		//Handle comments.
		if(arg.Comment.length() > 0){
			return "\n/* " + arg.Comment + " */\n";
		}
		
			// No rule so dump it into the file as a comment.
		if(Rule == null){
						
			return "/* Error, unable to process this.\n"
					+ "Name: '" + arg.Name + "'\n"
					+ "Target: '" + arg.Target + "'\n"
					+ "Extra: '" + arg.Extra + "'*/ \n";
		}
		
		
		
		String FunctionName = arg.Name;
		
		// Replace the function name with it's replace if it has one.
		if(Rule.To_Name.length() > 0){
			FunctionName = Rule.To_Name;
		}
		
		// What is being created is 
		// Function(Target, extra);
		
			// Name of the function.
		String Results = FunctionName + "(";
	
		// Is there a target?
		if(arg.Target.length() > 0){
			Results += HandleType.ProcessType(arg.Target, Rule.Type_Target);
		}
		
		// Is there a target?
		if(arg.Extra.length() > 0){
			Results += ", " + HandleType.ProcessType(arg.Extra, Rule.Type_Extra);
		}
		
		Results += ");\n";	
		
		
		return Results;
	}
	
	
	
}
