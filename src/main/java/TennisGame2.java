
public class TennisGame2 implements TennisGame {
    private int p1Point = 0;
    private  int p2Point = 0;
    private final String PLAYER1NAME;
    private final String PLAYER2NAME;

    public TennisGame2(String player1Name, String player2Name) {
        this.PLAYER1NAME = player1Name;
        this.PLAYER2NAME = player2Name;
    }

    public String getScore() {
        String score;
        if (p1Point == p2Point) score = equalScore();
        else if (p1Point >= 4 || p2Point >= 4) score = scoreGreaterThan4();
        else score = differentScore(p1Point)+" - "+ differentScore(p2Point);

        return score;
    }
    private String differentScore(int scorePlayer){
        switch (scorePlayer){
                case 0: return "Love";
                case 1: return "Fifteen";
                case 2: return "Thirty";
                default: return "Forty";
            }
        }

// no se usa, evaluar antes de eliminar
    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }
    // no se usa, evaluar antes de eliminar
    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() { // evaluar si borrar
        p1Point++;
    }

    public void P2Score() { // evaluar si borrar
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals(this.PLAYER1NAME))p1Point++;
        else
            p2Point++;
    }
    private String equalScore(){
        switch (p1Point){
            case 0: return "Love";
            case 1:return "Fifteen-All";
            case 2:return "Thirty-All";
            default:return "Deuce";
        }
    }
    private  String scoreGreaterThan4(){
        int minusResult = p1Point-p2Point;
        switch (minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
            }
        }
    private String advantageScore(int minusResult){
        return minusResult == 1 ? "Advantage player1" : "Advantage player2";
    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for player1": "Win for player2";
        }
   }