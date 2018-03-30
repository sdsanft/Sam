
import java.io.File;

public class Console extends StoreObject {
	String manufacturer;
	String type;
	
	public Console (String argName, String argPub, String argType, double argSto, double argRet, double argSale, int argStock, File argFile) {
		super(argName, argSto, argRet, argSale, argStock, argFile);
		manufacturer = argPub;
		type = argType;
	}
	
}