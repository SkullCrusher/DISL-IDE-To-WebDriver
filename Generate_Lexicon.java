import java.util.ArrayList;

public class Generate_Lexicon {
	ArrayList<Lexicon> List = new ArrayList<Lexicon>();
	
	public Generate_Lexicon(){
		
	//	List.add(new Lexicon(FromName, ToName, String Target, String Extra))
		
		/*
		<td>pause</td>
		<td>2000</td>
		<td></td>
		 */
		List.add(new Lexicon("pause", "", "Int", ""));
		
		
		/*
		<td>setSpeed</td>
		<td>2000</td>
		<td></td>
		*/
		
		List.add(new Lexicon("setSpeed", "", "Int", ""));
		
		/*
		<td>verifyText</td>
		<td>//div[@id=&quot;target&quot;]</td>
		<td>some text</td>
		*/
		
		List.add(new Lexicon("veryText", "", "Target", "Text"));
		
		/*
		<td>waitForElementPresent</td>
		<td>//div[@id='target']</td>
		<td></td>
		*/
		
		List.add(new Lexicon("waitForElementPresent", "", "Target", ""));	
		
		List.add(new Lexicon("waitForPageToLoad", "", "", ""));
		
		List.add(new Lexicon("verifyText", "", "Target", "Text"));
		
		List.add(new Lexicon("clickAndWait", "", "Target", ""));
		List.add(new Lexicon("click", "", "Target", ""));
		List.add(new Lexicon("type", "", "Target", "Text"));
		
		
		
	}
	
	public Lexicon GetLexicon(String Name){
		
		for(int i = 0; i < List.size(); i++){
			if(List.get(i).From_Name.equals(Name)){
				return List.get(i);
			}
		}
		
		return null;
	}
	
}
