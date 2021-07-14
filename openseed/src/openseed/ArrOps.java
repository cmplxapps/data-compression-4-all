
package openseed;

import java.util.ArrayList;
import java.util.List;

public class ArrOps {
	public static <T> List<T> GetListFromArray(T[] arr) {
		List<T> l = new ArrayList<T>();
		for ( int i = 0 ; i < arr.length ; i++ ) { l.add(arr[i]); }
		return l ; }
	public static List<Integer> GetListFromArray(int[] arr) {
		List<Integer> l = new ArrayList<Integer>();
		for ( int i = 0 ; i < arr.length ; i++ ) { l.add(arr[i]); }
		return l ; }
	//                                                      heh
	public static String JoinStrArray(String[] arr, String joint) {
		String ret = arr[0];
		for ( int i = 1 ; i < arr.length ; i++ ) {
			ret += joint + arr[i]; }
		return ret ; }
	public static String JoinStrArray(String[] arr) {
		return JoinStrArray(arr, "") ; }
	
	@SuppressWarnings("unchecked")
	public static <A> A[] Subarray(A[] arr, int beg, int end) {
		List<A> l = new ArrayList<A>();
		for ( int i = beg ; i < end ; i++ ) {
			l.add(arr[i]); }
		return (A[]) l.toArray() ; }
	public static <A> A[] Subarray(A[] arr, int beg) { return Subarray(arr, beg, arr.length) ; }
}
