
public class TennisGame3 implements TennisGame {

    private int socrePlayer2;
    private int scorePlayer1;
    private final String PLAYER1NAME;
    private final String PLAYER2NAME;

    public TennisGame3(String p1N, String p2N) {
        this.PLAYER1NAME = p1N;
        this.PLAYER2NAME = p2N;
    }

    public String getScore() {
        if (scoreIsLowerThan4()) {
            return lowerThan4();
        } else if (scorePlayer1 == socrePlayer2) return "Deuce";
        else return greaterThan4();
    }

    private boolean scoreIsLowerThan4() {
        return bothScoreLowerThan4() && additionDifferentTo6();
    }

    private boolean additionDifferentTo6() {
        return scorePlayer1 + socrePlayer2 != 6;
    }

    private boolean bothScoreLowerThan4() {
        return scorePlayer1 < 4 && socrePlayer2 < 4;
    }

    private String greaterThan4() {
        String playerName =getPlayerName() ;
        return scoreAdvantageOrWin() ? "Advantage "+playerName:"Win for "+playerName;
    }

    private boolean scoreAdvantageOrWin() {
        return (scorePlayer1 - socrePlayer2) * (scorePlayer1 - socrePlayer2) == 1;
    }

    private String getPlayerName(){
        String playerName;
        playerName = scorePlayer1> socrePlayer2 ? PLAYER1NAME: PLAYER2NAME;
        return playerName;
    }


    private String lowerThan4() {
        String score;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        score = p[scorePlayer1];
        return (scorePlayer1 == socrePlayer2) ? score + "-All" : score + "-" + p[socrePlayer2];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.PLAYER1NAME))
            this.scorePlayer1 ++;
        else
            this.socrePlayer2 ++;
    }
}
