
package api.openseed;

import java.util.Map;
import java.util.HashMap;

public class ExitCodes {
	protected static Map<String, Integer> getMapFromArrays(String[] arr0, int[] arr1) {
		if ( arr0.length != arr1.length ) { throw new Error("Arrays must be the same length"); }
		
		Map<String, Integer> themap = new HashMap<String, Integer>();
		
		for ( int i = 0 ; i < arr0.length ; i++ ) {
			themap.put(arr0[i], arr1[i]);
		}
		
		return themap ;
	}
	
	public static final Map<String, Integer> codes = ExitCodes.getMapFromArrays(
		new String[] { // exit keys
			"misuse",
			"missing-arg",
			"invalid-path"
		},
		new int[] { // exit codes
			1,
			2,
			3
		}
	);
	
	public ExitCodes() {}
	
	public int get(String key) { return codes.get(key) ; }
	
	public void issue(String key) { System.exit(codes.get(key)); }
}
