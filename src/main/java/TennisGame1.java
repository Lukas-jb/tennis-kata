
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String PLAYER1NAME; //variables final en mayusculas mejoran su reconocimiento
    private final String PLAYER2NAME;

    public TennisGame1(String player1Name, String player2Name) {
        this.PLAYER1NAME = player1Name;
        this.PLAYER2NAME = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.scorePlayer1)) scorePlayer1 += 1;
        else scorePlayer2 += 1;
    }

    public String getScore() {
        String score;

        if (scorePlayer1 == scorePlayer2) score = equalScoreString();
        else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) score = scoreGreaterThan4();
        else score = differentScore(scorePlayer1) + "-" + differentScore(scorePlayer2);
        differentScore(scorePlayer2);
        return score;
    }
   

    private String differentScore(int scorePlayer) {
        switch (scorePlayer) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
            default:
                return "Forty";
        }
    }

    private String scoreGreaterThan4() {
        int minusResult = scorePlayer1 - scorePlayer2;
        switch (minusResult) {
            case 1:
            case -1:
                return advantageScore(minusResult);
            default:
                return winScore(minusResult);
        }
    }

    private String advantageScore(int minusResult) {
        return minusResult == 1 ? "Advantage Player 1" : "Advantage Player 2";
    }

    private String winScore(int minusResult) {
        return minusResult >= 2 ? "Win for Player 1" : "Win for Player 2";
    }


    private String equalScoreString() {
        String score;
        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";


        }
    }
}

