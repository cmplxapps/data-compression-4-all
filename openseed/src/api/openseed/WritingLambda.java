
package api.openseed;

import java.io.File;
import java.util.function.BiConsumer;

public class WritingLambda {
	private BiConsumer<String, String> wl = (String path, String msg) ->
		System.out.print(msg);
	private String path = "."+File.separatorChar+"openseed-output";
	
	public WritingLambda(String path, BiConsumer<String, String> wl) {
		this.path = path;
		try { this.wl = wl; }
		catch(Exception e){} }
	public WritingLambda(BiConsumer<String, String> wl) {
		try { this.wl = wl; }
		catch(Exception e){} }
	public WritingLambda(String path) {
		this.path = path ; }
	public WritingLambda() {}

	public void write(String msg) { this.wl.accept(this.path, msg); }
	public void writeln(String msg) { this.write(msg + "\n"); }
	
	public BiConsumer<String, String> getLambda() { return this.wl ; }
	public void setLambda(BiConsumer<String, String> wl) { this.wl = wl ; }
}
