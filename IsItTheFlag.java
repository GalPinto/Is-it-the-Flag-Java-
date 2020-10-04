import BruteForce;

public class IsItTheFlag {

	public static boolean isFlag(String str) {
		return str.hashCode() == 1471587914 && str.toLowerCase().hashCode() == 1472541258;
	}

	public static void main(String[] args) {
		BruteForce bf = new BruteForce('0','z',6);
		bf.run();
		if(bf.found==false)
        	System.out.println("Not found flag");
	}
}