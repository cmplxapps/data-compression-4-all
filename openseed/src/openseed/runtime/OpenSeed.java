
package openseed.runtime;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.openseed.ExitCodes;
import api.openseed.WritingLambda;
import openseed.ArrOps;
import openseed.lib.json.JSONEntry;

@SuppressWarnings("static-access")
public class OpenSeed {
	public static final ExitCodes ext = new ExitCodes();

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println(" dc4a: openseed: No target JSON specified.");
			System.err.println(" err: ERROR-CODE: " + ext.get("misuse"));
			ext.issue("misuse"); }

		List<String> argv = ArrOps.GetListFromArray(args);
		WritingLambda w = (WritingLambda) null;

		// -o or --output
		if ( argv.contains("-o") || argv.contains("--output") ) {
			String output = "";
			int i = 0;
			for ( String str : argv ) {
				i++ ; if (str == "-o" || str == "--output") { break ; }}
			if (args.length <= i) {
				System.err.println(" dc4a: openseed: Missing argument: Output path");
				System.err.println(" err: ERROR-CODE: " + ext.get("missing-arg"));
				ext.issue("missing-arg"); }
			try {
				File f = new File(argv.get(i));
				output = f.getPath();
			if (!f.isFile() || f.isHidden()) {
				System.err.println(" dc4a: openseed: Specified output path"
					+ "\nis either not a file or is inaccessable.");
				System.err.println("err: ERROR-CODE: " + ext.get("invalid-path"));
				ext.issue("invalid-path"); }
			} catch (Exception e) {
				System.err.println(" dc4a: openseed: Invalid output path.");
				System.err.println(" err:ERROR-CODE: " + ext.get("invalid-path"));
				ext.issue("invalid-path"); }
			w = new WritingLambda (output,
				(String path, String msg) -> {
					try {
						api.openseed.FileOps.CleanWriteToFile(path, msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			);
		} else { w = new WritingLambda(); }

		Map<String, JSONEntry<?>> jsondict = new HashMap<String, JSONEntry<?>>();
	}
}
