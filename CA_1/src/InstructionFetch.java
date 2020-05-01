
public class InstructionFetch {
	
	 public static String instFetch(String address) {
		 //increment pc
		 int x =Integer.parseInt(address, 2);
		 memory.missOrhit(x);
		 int ad = Integer.parseInt(address);
		 int pc= ad+1;
		 PC.programCount= toBinary(pc);
		 
		 
		 //return instruction
		 return memory.Memory[ad];
		 
		 
	 }
	 
	 public String ProgCount() {
		 
		 return PC.programCount;
	 }
	 
	public static String toBinary(int x) {
			return String.format("%32s", Integer.toBinaryString(x)).replaceAll(" ", "0");
		}

}
