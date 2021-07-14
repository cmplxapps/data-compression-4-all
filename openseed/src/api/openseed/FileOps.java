
package api.openseed;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileOps {
	public static void CleanWriteToFile(String path, String txt) throws Exception {
		File f = new File(path);
		
		f.mkdirs();
		if (!f.exists()) {
			f.createNewFile(); }
		f.setWritable(true);
		
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(txt);
		
		bw.close();
		fw.close();
	}
	
	public static String GetFileText(String path) throws Exception {
		File f = new File(path);
		if (!f.exists()) {
			return (String) null ; }
		
		Scanner s = new Scanner(f);
		String txt = "";
		
		while (s.hasNextLine()) {
			txt += s.nextLine(); }
		
		s.close();
		return txt ;
	}
}
