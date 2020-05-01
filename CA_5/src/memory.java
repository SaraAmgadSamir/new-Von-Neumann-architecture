
public class memory {
	static String[] Memory = new String[2048];
	static int instPosition = 0;
	static boolean instFull = false;
	static int dataPosition = 1024;
	static boolean dataFull = false;

	public static void addInstruction(String instruction) {
		// when loading instructions to memory

		if (instruction.length() < 32) {
			System.out.println("Instruction should be 32 bits");
		} else {

			if (instFull == false)

			{
				Memory[instPosition] = instruction;
				instPosition++;

				if (instPosition == 1024) {
					instFull = true;
				}
			} else {
				System.out.println("Memory is full cannot insert in it");
			}
		}
	}

	public static void addData(String data) {
		// when loading data to memory
		String first = data.substring(0, 1);
		// if(data.length()<32)?
		while (data.length() < 32) {
			// if data is less than 32 I will add the first bit to the string?
			data = first + data;
		}
		if (instFull == false) {
			Memory[dataPosition] = data;
			dataPosition++;

			if (dataPosition == 1024) {
				dataFull = true;
			}
		} else {
			System.out.println("Memory is full cannot insert in it");
		}

	}

	public static String get(int address) {
		return Memory[address];
	}

	public static void set(int address, String x) {
		Memory[address] = x;
	}
}
