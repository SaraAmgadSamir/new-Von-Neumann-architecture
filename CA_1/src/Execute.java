
public class Execute {
	
	static String writeReg;
	static String ALUResult;

	public static void exec(String readData1, String readData2, String ALUOp, String ALUSrc, String signExtend,
			String pc) {
		// calculate branchaddress
		String subs = signExtend.substring(2, 32);
		String shift = subs + "00";
		int shiftInt = Integer.parseInt(shift, 2);
		int pcInt = Integer.parseInt(pc, 2);
		String branchAddress = ALU.ALUEvaluator("0010", shiftInt, pcInt);
		while (branchAddress.length() < 32) {
			branchAddress = "0" + branchAddress;
		}
		// call alu evaluator method
		String ALUInput = "";
		switch (ALUOp) {
		case "000":// and
			ALUInput = "0000";
			break;
		case "001":// or
			ALUInput = "0001";
			break;
		case "010":// add
			ALUInput = "0010";
			break;
		case "110":// sub
			ALUInput = "0110";
			break;
		case "111":// slt
			ALUInput = "0111";
			break;
		default:
			System.out.println("Cannot be evaluated");
			break;
		}
		int op1 = Integer.parseInt(readData1, 2);
		int op2 = Integer.parseInt(readData2, 2);
		int immediate = Integer.parseInt(signExtend, 2);
		switch (ALUSrc) {
		case "0":
			// second input is readdata2
			if (InstructionDecode.directALU.equals("1")) {
				// directly
				ALUResult = ALU.ALUEvaluator(ALUInput, op1, op2);
				writeReg = InstructionDecode.rd;
			} else {
				// multiplication
				writeReg = InstructionDecode.rd;
			}
			break;
		case "1":
			int value1 = Integer.parseInt(ALU.ALUEvaluator(ALUInput, op1, op2), 2);
			ALUResult = ALU.ALUEvaluator("0010", 1024, value1);
			writeReg = InstructionDecode.rt;
			break;
		}
		String zeroFlag = ALU.zeroFlag;
//		.zero flag: 1
//		branch address: 0000 0000 0000 0001 1110 0000 1010 0100
//		ALU result/address: 0000 0000 0000 0000 0000 0000 0000 0000
//		register value to write to memory: 0000 0000 0000 0000 0000 0000 0000 0000
//		rt/rd register: 01111
//		WB controls: MemToReg: 1, RegWrite: 1
//		MEM controls: MemRead: 0, MemWrite: 0, Branch: 0
		System.out.println("zero flag: " + zeroFlag);
		System.out.println("branch address: " + branchAddress);
		System.out.println("ALU result/address: " + ALUResult);
		System.out.println("register value to write to memory: ");// ?
		System.out.println("rt/rd register: " + writeReg);
		System.out.println("WB controls: " + "MemToReg: " + InstructionDecode.MemToReg + ", " + "MemWrite: "
				+ InstructionDecode.MemWrite + "RegWrite: " + InstructionDecode.RegWrite);
		System.out.println("MEM controls: " + "MemRead: " + InstructionDecode.MemRead + ", MemWrite: "
				+ InstructionDecode.MemWrite + "Branch: " + InstructionDecode.branch);

		
		
		
	}

}
