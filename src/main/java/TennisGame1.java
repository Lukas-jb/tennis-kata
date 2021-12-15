
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
        String score = "";
        int tempScore = 0;
        if (scorePlayer1 == scorePlayer2) {
            score = equalScoreString();

        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = scoreGreaterThan4();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayer1;
                else {
                    score += "-";
                    tempScore = scorePlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String scoreGreaterThan4() {
        int minusResult = scorePlayer1 - scorePlayer2;
        switch (minusResult) {
            case 1:
            case -1:
                return; //retornar puntaje de ventaja
        }

        String score;

        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String advantageScore(int minusResult) {
        switch (minusResult) {
            case 1:
                return "Advantage Player 1";
            default:
                return "Advantage Player 2";
        }
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

