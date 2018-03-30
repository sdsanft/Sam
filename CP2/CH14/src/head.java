
public class head {
	public static void main (String[] args) {
		System.out.println("Decimal\tBinary\t\tOctal\tHex\tCharacter");
		for (int i = 65; i <= 90; i++) {
			System.out.println(i + "\t" + Integer.toBinaryString(i) + "\t\t" + Integer.toOctalString(i) + "\t" +  Integer.toHexString(i) + "\t" + (char) i);
		}
	}
}
