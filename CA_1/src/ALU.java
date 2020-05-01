public class ALU {
	static String zeroFlag = "0";

	public static String ALUEvaluator(String Op, int Operand1, int Operand2) {
		int res = 0;

		// needs to be changed
		switch (Op) {
		case "0000":
			// System.out.println("Operation Name: and");
			res = Operand1 & Operand2;

			break;

		case "0001":
			// System.out.println("Operation: or");
			res = Operand1 | Operand2;

			break;

		case "0010":
			// System.out.println("Operation: add");

			res = Operand1 + Operand2;
			break;

		case "0110":
			// System.out.println("Operation: sub");
			res = Operand1 - Operand2;

			break;

		case "0111":
			// System.out.println("Operation: slt");
			res = Operand1 < Operand2 ? 1 : 0;

			break;

		case "1100":
			// System.out.println("Operation: nor");
			res = ~(Operand1 | Operand2);

			break;

		}

		if (res == 0)
			zeroFlag = "1";

		String resString = Integer.toBinaryString(res);
		while (resString.length() < 32) {
			resString = "0" + resString;
		}
		return resString;

	}

}
