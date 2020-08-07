package UI;

public class Messages {

    public final static String logo =" _____  _   _   ___   _____  _____      ___   _   _ ______     _____ ______ ______  _____ ______ \n" +
            "/  __ \\| | | | / _ \\ |  _  |/  ___|    / _ \\ | \\ | ||  _  \\   |  _  || ___ \\|  _  \\|  ___|| ___ \\\n"+
            "| /  \\/| |_| |/ /_\\ \\| | | |\\ `--.    / /_\\ \\|  \\| || | | |   | | | || |_/ /| | | || |__  | |_/ /\n"+
            "| |    |  _  ||  _  || | | | `--. \\   |  _  || . ` || | | |   | | | ||    / | | | ||  __| |    /\n"+
            "| \\__/\\| | | || | | |\\ \\_/ //\\__/ /   | | | || |\\  || |/ /    \\ \\_/ /| |\\ \\ | |/ / | |___ | |\\\n"+
            " \\____/\\_| |_/\\_| |_/ \\___/ \\____/    \\_| |_/\\_| \\_/|___/      \\___/ \\_| \\_||___/  \\____/ \\_| \\_|\n";

    public final static String instructions ="\t\t\t\tWelcome to Chaos and Order Board game!\n\n"+
            "\t\tIt's a tic-tac-toe variant with a 6x6 board. Both players can use Xs and Os\n"+
            "\t\tOrder has to make a strike of 5 either vertically, horizontally, or diagonally.\n"+
            "\t\tChaos aims to fill the board while preventing Order to win. Order starts first!\n\n";

    public final static String greetings =logo+"\n\n\n"+instructions;

    public final static String chaosWin =
            " _____  _   _   ___  _____ _____            _             _\n"+
            "/  __ \\| | | | / _ \\|  _  /  ___|          (_)           | |\n"+
            "| /  \\/| |_| |/ /_\\ \\ | | \\ `--.  __      ___ _ __  ___  | |\n"+
            "| |    |  _  ||  _  | | | |`--. \\ \\ \\ /\\ / / | '_ \\/ __| | |\n"+
            "| \\__/\\| | | || | | \\ \\_/ /\\__/ /  \\ V  V /| | | | \\__ \\ |_|\n"+
            " \\____/\\_| |_/\\_| |_/\\___/\\____/    \\_/\\_/ |_|_| |_|___/ (_)\n";

    public final static String orderWin =
            " _________________ ___________            _             _ \n"+
            "|  _  | ___ \\  _  \\  ___| ___ \\          (_)           | |\n"+
            "| | | | |_/ / | | | |__ | |_/ / __      ___ _ __  ___  | |\n"+
            "| | | |    /| | | |  __||    /  \\ \\ /\\ / / | '_ \\/ __| | |\n"+
            "\\ \\_/ / |\\ \\| |/ /| |___| |\\ \\   \\ V  V /| | | | \\__ \\ |_|\n"+
            " \\___/\\_| \\_|___/ \\____/\\_| \\_|   \\_/\\_/ |_|_| |_|___/ (_)\n";

    public final static String wrongPoint ="Illegal point. Coordinates should be between 0 and 5. You cannot overwrite points. Try again";

    public final static String wrongPiece ="Illegal piece. Only 'x' or 'o' are valid.Try again";

    public final static String wrongInt ="Not a integer. Try again";

    public final static String pointX = "Select X coordinate for new point:";

    public final static String pointY = "Select Y coordinate for new point:";

    public final static String selectPiece = "Select your piece:";

    private Messages() {}

}
