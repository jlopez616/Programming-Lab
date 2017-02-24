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
        this.playerHand.drawNewHandFrom(mainDeck);
        this.enemyHand.drawNewHandFrom(mainDeck);

        int playerRoundScore = 0;
        int enemyRoundScore = 0 ;

        this.currentRound++;

        System.out.println("--ROUND " + currentRound + "--");
        System.out.println("Your Hand: " + "\n" + "{");
        System.out.println(playerHand.toString());
        playerRoundScore = scoreHand( this.playerHand, this.enemyHand );
        System.out.println( "}" + "\n" + "Score: " + playerRoundScore + "\n" );

        System.out.println("Enemy Hand: " + "\n" + "{");
        System.out.println(enemyHand.toString());
        enemyRoundScore = scoreHand(this.enemyHand, this.playerHand);
        System.out.println("}" + "\n" + "Score: " + enemyRoundScore + "\n" );

        int earnedPoints;
        if ( playerRoundScore > enemyRoundScore ) {
            earnedPoints = playerRoundScore - enemyRoundScore;
            this.playerScore = this.playerScore + earnedPoints;
            if ( earnedPoints == 1 ) {
                System.out.println("You scored a point!");
            } else {
                System.out.println("You score  "  + earnedPoints + " points!");
            }
        } else if ( enemyRoundScore > playerRoundScore ) {
            earnedPoints = enemyRoundScore - playerRoundScore;
            this.enemyScore = this.enemyScore + earnedPoints;
            if ( earnedPoints == 1 ) {
                System.out.println("Your enemy scored a point!");
            } else {
                System.out.println("Your enemy scores " + earnedPoints + " points!");
            }
        } else {
            System.out.println("It's a draw!");
        }

        System.out.println("You: " + this.playerScore);
        System.out.println("Enemy: " + this.enemyScore +  "\n");

    }

    public static int scoreHand ( Hand scoredHand, Hand otherHand ) {
        int roundScore = 0;

        for ( int k = 0; k < scoredHand.getHandSize(); k++ ) {
            Card compCard = scoredHand.getCardAt(k);
            if ( compCard.getRank() == 1 ) {
                roundScore = roundScore + 15;
            }
            if ( (compCard.getRank() >= 2) && (compCard.getRank() <= 5) ) {
                if ( otherHand.countOfFaceCards() > 0 ) {
                    roundScore = roundScore + 7;
                }
            }
            if ( (compCard.getRank() >= 6) && (compCard.getRank() <= 10) ) {
                if( ( scoredHand.countInHand(compCard.getRank() + 1) > 0  ) || (scoredHand.countInHand(compCard.getRank() - 1) > 0) ) {
                    roundScore = roundScore + 8;
                }
            }
            if (compCard.getRank() > 10) {
                if( (scoredHand.countInHand(compCard.getSuit()) >= 2) ) {
                    roundScore = roundScore + 10;
                }
            }
        }
        return roundScore;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }
    public int getOpponentScore() {
        return this.enemyScore;
    }

    public boolean amIWinning() {
        if ( getPlayerScore() > getOpponentScore() ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        if (getPlayerScore() >= 50) {
            return true;
        } else if ( getOpponentScore() >= 50 ) {
            return true;
        } else if ( mainDeck.remainingCards() < (playerHand.getHandSize() * 2) ){
            return true;
        } else {
            return false;
        }
    }
    public void playGame() {


        while ( !this.isGameOver() ) {
            this.playRound();
        }

        System.out.println("--GAME OVER--");
        if ( getOpponentScore() < getPlayerScore() ) {
            System.out.println("You win!");
        } else if ( getOpponentScore() == getPlayerScore() ) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("You lose!");
        }

        System.out.println("Final score:");
        System.out.println("You:" + getPlayerScore());
        System.out.println("Enemy: " + getOpponentScore());

    }
    public static void main (String args[]) {

        if ( args.length == 2 ) {
            int sizeHand = Integer.parseInt(args[0]);
            int deckCopies = Integer.parseInt(args[1]);
            CardGame newGame = new CardGame(sizeHand, deckCopies);
            newGame.playGame();
        } else if ( args.length == 0 ) {
            CardGame newGame = new CardGame();
            newGame.playGame();
        } else {
            System.out.println("Usage instructions: java CardGame [<hand size> <copies of each card in deck>]");
        }
    }
}
