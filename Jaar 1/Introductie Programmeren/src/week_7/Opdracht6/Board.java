package week_7.Opdracht6;

public class Board {
    public static void print(int turnsIncorrect) {
        switch (turnsIncorrect) {
            case 13:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                \\|/");
                System.out.println("   |                 |");
                System.out.println("   |                / \\");
                System.out.print("___|___");
                break;
            case 12:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                \\|/");
                System.out.println("   |                 |");
                System.out.println("   |                / ");
                System.out.print("___|___");
                break;
            case 11:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                \\|/");
                System.out.println("   |                 |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 10:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                \\|/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 9:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                \\|");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 8:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |                 |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 7:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              / o o \\");
                System.out.println("   |              \\_ = _/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 6:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |               __|__");
                System.out.println("   |              /     \\");
                System.out.println("   |              \\_____/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 5:
                System.out.println("    __________________");
                System.out.println("   |/                |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 4:
                System.out.println("    __________________");
                System.out.println("   |/                ");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 3:
                System.out.println("    __________________");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 2:
                System.out.println("    ");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.print("___|___");
                break;
            case 1:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.print("_______");
                break;
            default:
                System.out.println("                NO ERRORS");
        }
    }
}
