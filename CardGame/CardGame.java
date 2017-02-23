public class CardGame {
    public static final int END_SCORE = 50;
    public Hand playerHand;
    public Hand enemyHand;
    public Deck mainDeck;
    public int playerScore = 0;
    public int enemyScore = 0;
    public int currentRound = 0;

    public CardGame() {
        this.mainDeck = new Deck();
        this.playerHand = new Hand();
        this.enemyHand = new Hand();
        this.mainDeck.shuffle();
    }

    public CardGame( int handSize, int copiesPerDeck ) {
        this.mainDeck = new Deck(copiesPerDeck);
        this.playerHand = new Hand(handSize);
        this.enemyHand = new Hand(handSize);
        this.mainDeck.shuffle();
    }

    public void playRound() {
    /*    this.playerHand.drawNewHandFrom(mainDeck);
        this.enemyHand.drawNewHandFrom(mainDeck);
        this.playerHand.toString();
        this.enemyHand.toString(); */
        this.playerHand.drawNewHandFrom(mainDeck);
        this.enemyHand.drawNewHandFrom(mainDeck);
        int playerRoundScore = 0;
        int enemyRoundScore = 0 ;





    /*    if (playerHand.countOfFaceCards() > 0) {
            if (countInHand(currentSuit) > 2) {
                this.playerScore = this.playerScore + 10 * playerHand.countOfFaceCards();
            }
        }
        if (enemyHand.countOfFaceCards() > 0) {
            if (countInHand(currentSuit) > 2) {
                this.enemyScore = this.enemyScore + 10 * enemyHand.countOfFaceCards();
            }
        } */

        //change this and all the other "or"s
    /*    if ((playerHand.countInHand(5) > 0) || (playerHand.countInHand(4) > 0) || (playerHand.countInHand(3) > 0)
            || (playerHand.countInHand(2) > 0)) {
                if(enemyHand.countOfFaceCards() > 0) {
                    playerRoundScore = playerRoundScore + 7;
                }
            }

        if ((enemyHand.countInHand(5) > 0) || (enemyHand.countInHand(4) > 0) || (enemyHand.countInHand(3) > 0)
            || (enemyHand.countInHand(2) > 0)) {
                if(playerHand.countOfFaceCards() > 0) {
                    enemyRoundScore = enemyRoundScore + 7;
                }
            }

        if (playerHand.countInHand(1) > 0) {
            playerRoundScore = playerRoundScore + 15;
        }

        if (enemyHand.countInHand(1) > 0) {
            enemyRoundScore = enemyRoundScore + 15;
        } */

        this.currentRound++;
        System.out.println("--ROUND " + currentRound + "--");
        System.out.println("Your Hand: ");
        System.out.println(playerHand.toString());
        System.out.println("Score: " + playerRoundScore + "\n");



        System.out.println("Enemy Hand: ");
        System.out.println(enemyHand.toString());
        System.out.println("Score: " + enemyRoundScore + "\n");

        int earnedPoints;
        if (playerRoundScore > enemyRoundScore) {
            earnedPoints = playerRoundScore - enemyRoundScore;
            this.playerScore = this.playerScore + earnedPoints;
            System.out.println("You score  "  + earnedPoints + " points!");
        } else if (enemyRoundScore > playerRoundScore) {
            earnedPoints = enemyRoundScore - playerRoundScore;
            this.enemyScore = this.enemyScore + earnedPoints;
            System.out.println("Your enemy scores " + earnedPoints + " points!");
        } else {``
            System.out.println("It's a draw!");
        }





        System.out.println("You: " + this.playerScore);
        System.out.println("Enemy: " + this.enemyScore +  "\n");

    }

    public static int scoreHand ( Hand scoredHand, Hand otherHand ) {

        int roundScore = 0;


        for (int k = 0; k < scoredHand.getHandSize(); k++) {
            Card compCard = getCardAt(k);
            if (getCardAt(k).getRank() == 1) {
                aplayerRoundScore = aplayerRoundScore ++;

            }

        }
        return roundScore;
    }
    /*    int earnedPoints;
        if (playerRoundScore > enemyRoundScore) {
            earnedPoints = playerRoundScore - enemyRoundScore;
            this.playerScore = this.playerScore + earnedPoints;
            System.out.println("You score  "  + earnedPoints + " points!");
        } else if (enemyRoundScore > playerRoundScore) {
            earnedPoints = enemyRoundScore - playerRoundScore;
            this.enemyScore = this.enemyScore + earnedPoints;
            System.out.println("Your opponent scores " + earnedPoints + " points!");
        } else {
            System.out.println("It's a draw!");
        }
        return 0; */


    public int getPlayerScore() {
        return this.playerScore;
    }
    public int getOpponentScore() {
        return this.enemyScore;
    }

    public boolean amIWinning() {
        if (getPlayerScore() > getOpponentScore()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        if (getPlayerScore() >= 50) {
            return true;
        } else if (getOpponentScore() >= 50) {
            return true;
        } else if (mainDeck.remainingCards() < (playerHand.getHandSize() * 2)){
            return true;
        } else {
            return false;
        }
    }
    public void playGame() {


        while (!this.isGameOver()) {
            this.playRound();
        }
        System.out.println("--GAME OVER--");
        if (amIWinning()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
        System.out.println("Final score:");
        System.out.println("You:" + getPlayerScore());
        System.out.println("Enemy: " + getOpponentScore());

    }
    public static void main (String args[]) {
        CardGame newGame = new CardGame();
        newGame.playGame();
    }


}
