package base.util.generator;

import java.util.UUID;

public class UIDGenerator {

	public static String generatUID(){
		return UUID.randomUUID().toString();
	}
}
