import java.util.Arrays;
import java.util.List;

public class TennisGame1 implements TennisGame {

    public static final String PLAYER1_NAME = "player1";
    public static final String PLAYER2_NAME = "player2";
    public static final int FORTY = 3;
    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    private static List<String> SCORE_MAP = Arrays.asList("Love","Fifteen","Thirty","Forty");
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1_NAME))
            player1score++;
        else
            player2score++;
    }
    public String getScore() {

        if (player1score == player2score)
        {
            return calcTieScore();
        }
        else if (IsOneOfPlayerOverForty())
        {
            return calcWinScore();
        }
            return calcDiffScoreUnderDeuce();
    }

    private boolean IsOneOfPlayerOverForty() {
        return player1score >=4 || player2score >=4;
    }

    private String calcDiffScoreUnderDeuce() {
        return SCORE_MAP.get(player1score) + "-" + SCORE_MAP.get(player2score);
    }

    private String calcWinScore() {
        String playerName = player1score > player2score ? PLAYER1_NAME : PLAYER2_NAME;
        return Math.abs(player1score - player2score) == 1 ? "Advantage " + playerName : "Win for " + playerName;
    }

    private String calcTieScore() {
        if(player1score >= FORTY){
            return "Deuce";
        }
        return SCORE_MAP.get(player1score) + "-All";
    }
}
