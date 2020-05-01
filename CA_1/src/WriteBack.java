
public class WriteBack {

	public static void writeBack() {
		if(InstructionDecode.MemWrite.equals("1")) {
			
			//store word
			
		}
		
		if(InstructionDecode.RegWrite.equals("1")) {
			
			Datapath.rf.setDATAReg(Execute.ALUResult, Execute.writeReg);

			
		}
		
		
	}
	
	
}
