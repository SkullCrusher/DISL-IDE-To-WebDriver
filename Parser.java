import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Parser {
	
	public static String Raw_Load(String FilePath){
		String Result = "";
	
	    ArrayList<String> Lines = new ArrayList<String>();
		
	    try {
			File file = new File(FilePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
				
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Lines.add(line);
				Result += line + "\n";
			}
			fileReader.close();
		} catch (IOException e) {
			return null;
		}
	    
	    for(int i = 0; i < Lines.size(); i++){
	    	//Result += Lines + "\n";
	    }
		
		
		return Result;
	}

	public static ConvertedScript Load_File(String FilePath){
		
		// String current = System.getProperty("user.dir");
	    // System.out.println("Current working directory in Java : " + current);

		  ArrayList<Command> Command_List = new ArrayList<Command>();

	      ArrayList<String> Lines = new ArrayList<String>();
		
	      try {
				File file = new File(FilePath);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					Lines.add(line);
				}
				fileReader.close();
			} catch (IOException e) {
				return null;
			}
	      
	      String TestName = "";

	      int CurrentPoint = 0;
	      
	      // Find the <title>Name</title>
	      for(;CurrentPoint < Lines.size();CurrentPoint++){
	    	  String Temp = Lines.get(CurrentPoint);
	    	  
	    	  if(Temp.contains("<title>")){
	    		  for(int i = 7; i < Temp.length(); i++){
	    			  if(Temp.charAt(i) == '<'){
	    				  break;
	    			  }
	    			  
	    			  TestName += Temp.charAt(i);
	    		  }
	    		  break;
	    	  }	    	  
	      }
	      
	      	// Find the "</thead><tbody>"
	      for(;CurrentPoint < Lines.size();CurrentPoint++){
	    	  String Temp = Lines.get(CurrentPoint);
	    	  
	    	  if(Temp.contains("</thead><tbody>")){
	    		  break;
	    	  }
	      }
	      
	      System.out.println("Converting: " + TestName + ".");
	     
	      int spot = 0;
	      
	      Command New = new Command();
	      
	      	// Parse the commands.
	      for(int i = CurrentPoint + 1; i < Lines.size() - 1; i++){	
	    	  System.out.println(Lines.get(i));
	    	  
	    	  String Temp = Lines.get(i);
	    	  
	    	  String InLine_Data = ""; 	  
	    	  	    	  
	    	  if(Temp.contains("</tr>")){
	    		  System.out.println("/TR");
	    		  
	    		  Command_List.add(New);
	    		  
	    		  New = new Command(); 
	    		  
	    		  spot = 0;
	    		  continue;
	    	  }
	    	  
	    	  if(Temp.contains("<!--")){
	    		  
	    		  String Cut = "";
	    		  
	    		  for(int y = 4; y < Temp.length() - 3; y++){
	    			  if(Temp.charAt(y) == '-' && Temp.charAt(y + 1) == '-' && Temp.charAt(y + 2) == '>'){
	    				  break;
	    			  }
	    			  Cut += Temp.charAt(y);
	    		  }
	    		  
	    		  Command New_comment = new Command();	    		  
	    		  New_comment.Comment = Cut;	    		  
	    		  Command_List.add(New_comment);
	    		  
	    		  continue;
	    	  }
	    	  
	    	  if(Temp.contains("<td>")){
	    		  
	    		 // boolean Started = false;
	    		  
	    		  for(int y = 5; y < Temp.length(); y++){
	    			  if(Temp.charAt(y) == '<'){
	    				  break;
	    			  }
	    			  /*
	    			  if(Temp.charAt(y) == '>'){
	    				  Started = true;
	    			  }
	    			  */
	    			  
	    			  //if(Started){
	    				  InLine_Data += Temp.charAt(y);
	    			  //}
	    		  }  
	    		  
	    		  System.out.println(InLine_Data);
	    		  
	    		  if(spot == 0){
	    			  New.Name = InLine_Data;
	    			  InLine_Data = "";
	    			  spot = 1;
	    		  }else if(spot == 1){
	    			  New.Target = InLine_Data;
	    			  InLine_Data = "";
	    			  spot = 2;
	    		  }else if(spot == 2){
	    			  New.Extra = InLine_Data;
	    			  InLine_Data = "";
	    			  spot = 3;
	    		  }  		  
	    		  
	    	  }
	      }	  
	      
	      System.out.println(Command_List.size());
	      
	      for(int i = 0; i < Command_List.size(); i++){
	    	  System.out.println(Command_List.get(i).Name);
	    	  System.out.println(Command_List.get(i).Target);
	    	  System.out.println(Command_List.get(i).Extra);
	    	  System.out.println(Command_List.get(i).Comment);
	    	  System.out.println(" : ");
	      }
	      
		return new ConvertedScript(TestName, Command_List);
	}
	
	public static void Dump_File(String Path, String Towrite){
			
		//String current = System.getProperty("user.dir");
		
		

	    PrintWriter writer = null;
	    
		try {
			writer = new PrintWriter(Path, "UTF-8");
		} catch (FileNotFoundException e) {
			return;
		} catch (UnsupportedEncodingException e) {
			return;
		}
		
		writer.print(Towrite);
		/*
		for(int i = 0; i < arg.GetRSSSize();i++){			
	     	writer.println(arg.GetString(i));
	     	writer.println(Integer.toString(arg.GetDelay(i)));	      
		}
		*/
		
		writer.close();
	}
	
}
