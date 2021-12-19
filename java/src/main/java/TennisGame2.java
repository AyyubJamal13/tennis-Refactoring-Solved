import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    public static final String PLAYER1_NAME = "player1";
    public static final int DEUCE = 4;
    public static final int FORTY = 3;

    private static final List<String> SCORE_MAP = Arrays.asList("Love","Fifteen","Thirty","Forty","DEUCE");


    private int player1Score = 0;
    private int player2Score = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (player1Score == player2Score) {
            score = calcTieScore(score);
        }
        else if (player1Score < 4  && player2Score < 4) {
            score = calcDiffScoreUnderDeuce();
        }
        else if(player1Score >= 4 || player2Score >= 4) {
            score = calcWinScore(score);
        }
        return score;
    }

    private String calcWinScore(String score) {
        int absDeltaScore = Math.abs(player1Score - player2Score);
        String playerName = player1Score > player2Score ? player1Name : player2Name;
        if(absDeltaScore == 1)
        {
            score = "Advantage " + playerName;
        }else {
            score = "Win for " + playerName;
        }
        return score;
    }

    private String calcDiffScoreUnderDeuce() {
        return  SCORE_MAP.get(player1Score) + "-" + SCORE_MAP.get(player2Score);
    }

    private String calcTieScore(String score) {
        if (player1Score < DEUCE)
        {
            score = SCORE_MAP.get(player1Score) + "-All";
        }
        if (player1Score >= FORTY)
            score = "Deuce";
        return score;
    }

    public void player1Score(){
        player1Score++;
    }
    
    public void Player2Score(){
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER1_NAME))
            player1Score();
        else
            Player2Score();
    }
}