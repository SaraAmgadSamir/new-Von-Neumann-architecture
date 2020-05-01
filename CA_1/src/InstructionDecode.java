
public class InstructionDecode {
	static String RegDst;
	static String RegWrite;
	static String ALUSrc;
	static String PCSrc;
	static String MemRead;
	static String MemWrite;
	static String MemToReg;
	static String ALUOp;
	static String branch = "0";
	static String rt;
	static String rd;
	static String directALU;
	static String immediate;
	static String shamt;

	public static void InstDecode(String instruction, String pc) {
		String Type = instruction.substring(0, 2);
		String opCode = instruction.substring(2, 6);
		String rs = instruction.substring(6, 11);
		String readData1 = registerFile.getValue(rs);
		rt = instruction.substring(11, 15);
		String readData2 = registerFile.getValue(rt);
		if (Type.equals("00")) {
			directALU = instruction.substring(30, 32);
			shamt = instruction.substring(20, 25);
		} 
		
		if(RegDst.equals("1")) {
			
			rd = instruction.substring(15, 20);

		}
		else {
			rd = "don't care";

		}
		
		String offset = instruction.substring(16, 32);
		immediate = SignExtend(offset);
		// Print Statements
		System.out.println("read data 1: " + readData1);
		System.out.println("read data 2: " + readData2);
		System.out.println("sign-extend: " + immediate);
		System.out.println("Next Pc: " + pc);
		System.out.println("rt: " + rt);
		System.out.println("rd: " + rd);
		ContUnit(opCode);
		Execute.exec(readData1, readData2, ALUOp, ALUSrc, immediate, pc);
	}

	public static String SignExtend(String immediate) {
		String first = immediate.substring(0, 1);
		while (immediate.length() < 32)
			immediate = first + immediate;
		return immediate;
	}

	public static void ContUnit(String opCode) {
		switch (opCode) {
		case "0000":// add rs+rt
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "010";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0001":// add immediate rs+ imm
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "010";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0010":// subtract rs-rt
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "110";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0011":// multiply rs*rt
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "010";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0100":// and
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "000";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0101":// or immediate
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "001";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0110":// shift left logic
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "001";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "0111":// shift right logic
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "001";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1000":// load word
			RegDst = "0";
			RegWrite = "1";
			ALUSrc = "1";
			ALUOp = "010";
			MemWrite = "0";
			MemRead = "1";
			MemToReg = "1";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1001":// store word
			RegDst = "don't care";
			RegWrite = "0";
			ALUSrc = "1";
			ALUOp = "010";
			MemWrite = "1";
			MemRead = "0";
			MemToReg = "don't care";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1010":// Branch on not equal.
			RegDst = "don't care";
			RegWrite = "0";
			ALUSrc = "0";
			ALUOp = "110";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "don't care";
			branch = "1";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1011":// Branch on greater than.
			RegDst = "don't care";
			RegWrite = "0";
			ALUSrc = "0";
			ALUOp = "110";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "don't care";
			branch = "1";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1100":// Set on less than.
			RegDst = "1";
			RegWrite = "1";
			ALUSrc = "0";
			ALUOp = "111";
			MemWrite = "0";
			MemRead = "0";
			MemToReg = "0";
			System.out.println("WB controls: " + "MemToReg: " + MemToReg + ", " + "MemWrite: " + MemWrite + "RegWrite: "
					+ RegWrite);
			System.out.println(
					"MEM controls: " + "MemRead: " + MemRead + ", MemWrite: " + MemWrite + "Branch: " + branch);
			System.out.println("EX controls: RegDest: " + RegDst + ", ALUOp: " + ALUOp + ", ALUSrc: " + ALUSrc);
			break;
		case "1101":// jump
			break;
		default:
			System.out.println("Not a legal opcode");

		}

	}

}
