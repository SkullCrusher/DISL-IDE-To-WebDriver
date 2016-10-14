
public class HandleType {

	public static String ProcessType(String input, String Desiredtype){
		
			// If it should be a int just drop it in place.		
		if(Desiredtype == "Int"){
			return input;
		}
		
		// Clean up for strings.
		input.replace("&quot;", "\"");
		
			// Handle strings.
		if(Desiredtype == "Text"){
			return "\"" + input + "\""; 
		}
		
			// One of three cases can occur.
		if(Desiredtype == "Target"){
			//#1 xpath - they lead with a "//" so find that.
			
			if(input.contains("//")){
				return "By.xpath(\"" + input + "\")";
			}
					
			//#2 byid? (check this later)
			if(input.contains("id=")){
				input = input.replace("id=", "");
				
				return "By.id(\"" + input + "\")"; 				
			}
		
			//#3 target? (check this later)
			if(input.contains("css=")){
				input = input.replace("css=", "");
				
				return "By.css(\"" + input + "\")"; 				
			}
		}
			
		return input;
	}
	
}
