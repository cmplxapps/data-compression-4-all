
package api.openseed.json;

import java.io.File;

public class OpenSeedJSONValidator {
	public String PathToFile = "."+File.separatorChar+"openseed.json" ;
	
	public static boolean quickValiate(String fpath) {
		return false ;
	}
	
	public OpenSeedJSONValidator(String fpath) { this.PathToFile = fpath ; }
	public OpenSeedJSONValidator() {}
	
	public String getRawJSONText() {
		return (String) null ;
	}
	
	public static boolean isValid(String fpath) {
		return false ;
	}
	public boolean isValid() { return isValid(this.PathToFile) ; }
}
