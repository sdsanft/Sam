/**
 * 
 */

/**
 * @author ss016231
 *
 */
public class Head {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");
		System.out.println(ch2str(new char[]{'a', 'b', 'c', 'd'}));
		System.out.println(str2ch("Samuel"));
	}
	
	public static String ch2str(char[] ch) {
		String str = "";
		
		for (int i = 0; i < ch.length; i++) {
			str += ch[i];
		}
		
		return(str);
	}
	
	public static char[] str2ch(String str) {
		char[] ch = new char[str.length()];
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		}
		
		return(ch);
	}
}
