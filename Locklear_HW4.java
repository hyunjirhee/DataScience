package nyu;

public class Locklear_HW4 {
	public static String[][] Players_Phase1 = { { "Alpha-1", "100", "48", "2", "10" },
			{ "Beta-1", "60", "87", "3", "8" }, { "Gamma-1", "70", "76", "4", "6" },
			{ "Tau-1", "30", "100", "20", "10" }, { "AI-1", "145", "4", "1", "12" } };

	public static String[][] Players_Phase2 = { { "Alpha-2", "42", "50", "5", "10" },
			{ "Beta-2", "39", "51", "7", "9" }, { "Gamma-2", "48", "40", "9", "5" },
			{ "Tau-2", "26", "61", "10", "10" }, { "AI-2", "96", "1", "0", "1" } };

	public static double convertToDouble(String v) {
		double newV = Double.parseDouble(v);
		return newV;
	}

	public static int convertToInteger(String v) {
		int newV = Integer.parseInt(v);
		return newV;
	}

	public double getAverage(String v1, String v2) {
		double sum = convertToDouble(v1) + convertToDouble(v2);
		return sum / 2;
	}

	public static String getWin(String[] p) {
		return p[1];
	}

	public static String getLose(String[] p) {
		return p[2];
	}

	public static String getTie(String[] p) {
		return p[3];
	}

	public static String winPercentage(String[] player) {
		double avg = convertToDouble(getWin(player)) / (convertToDouble(getWin(player))
				+ convertToDouble(getLose(player)) + convertToDouble(getTie(player)));
		return String.valueOf(Math.round(avg * 10000.0)/100.0);
	}

	public static String lostPercentage(String[] player) {
		double avg = 100.0 - convertToDouble(winPercentage(player));
		return String.valueOf(Math.round(avg * 100.0)/100.0);
	}

	public static String tieLossPercentage(String[] player) {
		double avg = convertToDouble(getTie(player)) / convertToDouble(getLose(player));
		return String.valueOf(Math.round(avg * 10000.0)/100.0);
	}

	public static void displayAllPlayerStatistics() {
		int win1 = 0, loss1 = 0, ties1 = 0;
		int win2 = 0, loss2 = 0, ties2 = 0;
		System.out.println("\t\tALL PLAYER STATISTICS");
		System.out.println("Player \t\t Wins \tLosses \tTies \tWin% \tLoss% \tTieLoss% \tCurrentLevel");
		System.out.println();
		System.out.println("\tPHASE I");

		for (int i = 0; i < 5; i++) {
			System.out.println(Players_Phase1[i][0] + "\t\t" + getWin(Players_Phase1[i]) + "\t"
					+ getLose(Players_Phase1[i]) + "\t" + getTie(Players_Phase1[i]) + "\t"
					+ winPercentage(Players_Phase1[i]) + "\t" + lostPercentage(Players_Phase1[i]) + "\t"
					+ tieLossPercentage(Players_Phase1[i]) + "\t\t" + Players_Phase1[i][4]);
		}
		
		//getting Aggregated Wins, Losses, Ties
		for(int i = 0; i < 5; i++) {
			win1 += convertToInteger(Players_Phase1[i][1]);
			loss1 += convertToInteger(Players_Phase1[i][2]);
			ties1 += convertToInteger(Players_Phase1[i][3]);
		}
		System.out.println("\t\tAggregated Wins: " + win1 + "\t Aggregated Losses: " + loss1 + "\t Aggregated Ties: " + ties1);
		System.out.println("\tPHASE II");
		for (int i = 0; i < 5; i++) {
			System.out.println(Players_Phase2[i][0] + "\t\t" + getWin(Players_Phase2[i]) + "\t"
					+ getLose(Players_Phase2[i]) + "\t" + getTie(Players_Phase2[i]) + "\t"
					+ winPercentage(Players_Phase2[i]) + "\t" + lostPercentage(Players_Phase2[i]) + "\t"
					+ tieLossPercentage(Players_Phase2[i]) + "\t\t" + Players_Phase2[i][4]);
		}
		for(int i = 0; i < 5; i++) {
			win2 += convertToInteger(Players_Phase2[i][1]);
			loss2 += convertToInteger(Players_Phase2[i][2]);
			ties2 += convertToInteger(Players_Phase2[i][3]);
		}
		System.out.println("\t\tAggregated Wins: " + win2 + "\t Aggregated Losses: " + loss2 + "\t Aggregated Ties: " + ties2);

	}

	public static void main(String[] args) {
		displayAllPlayerStatistics();
	}
}
