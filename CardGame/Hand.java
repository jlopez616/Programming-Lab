/**
 * Hand represents a hand of playing cards using French suits containing a set
 * number of cards.
 */
 
public class Hand {
    private Card[] cardsInHand;
    public static final int STANDARD_HAND_SIZE = 5;

    /**
     * Constructs an empty hand of the standard hand size.
     */
     
    public Hand() {
        this.cardsInHand = new Card[STANDARD_HAND_SIZE];
    }

    /**
     * Constructs an empty hand of the provided size.
     * @param handSize     the number of cards the hand can hold
     * @throws IllegalArgumentException    if an non-positive hand size is provided
     */
     
    public Hand( int handSize ) {
        if (handSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.cardsInHand = new Card[handSize];
    }

    /**
     * Draws a new hand from the provided deck, replacing the cards in the hand
     * with the top cards from the deck. The new top card of the deck is the
     * card after the last drawn card.
     *
     * @param deck     the number of cards the hand can hold
     */
     
    public void drawNewHandFrom( Deck deck ) {
        for ( int cardsAmount = 0; cardsAmount < getHandSize(); cardsAmount++ ) {
            cardsInHand[cardsAmount] = deck.drawCardFromTop();
        }
    }

    /**
     * Returns the maximum hand size of this hand.
     *
     * @return          the number of card this hand can hold
     */
     
    public int getHandSize() {
        int handLength = cardsInHand.length;
        if (handLength <= 0) {
            throw new IllegalArgumentException();
        }
        return handLength;
    }

    /**
     * Returns the card at the given index in this hand.
     *
     * @param index     the index of the card in the hand
     * @return          the card at the provided index in the hand
     */
     
    public Card getCardAt( int index ) {
        return cardsInHand[index];
    }

    /**
     * Returns a string representation of this hand, including all cards in the
     * hand.
     *
     * @return         a string representation of the hand
     */
     
    @Override
    public String toString() {
       String basicString = "";
        for (int k = 0; k < this.cardsInHand.length; k++ ) {
            basicString = basicString + "\t"+ getCardAt(k).toString() + "\n";

        }
        return basicString;
    }

    /**
     * Returns whether this hand contains a card of the same rank suit as the
     * provided card.
     *
     * @param card     the card being searched for
     * @return         <code>true</code> if this hand conta  ins an equivalent
     *                 card; <code>false</code> otherwise.
     */
     
    public boolean contains( Card card ) {

        Card tempCard = new Card();
        boolean hasCard = false;
        for ( int k = 0; k < this.cardsInHand.length; k++ ) {
            tempCard =  getCardAt(k);
            if ( tempCard.equals(card) ) {
                hasCard = true;
            }
        }
        return hasCard;
    }

    /**
     * Returns the number of cards in this hand with the provided rank.
     *
     * @param rank     the rank being searched for
     * @return         the number of cards in the hand with the provided rank
     * @throws IllegalArgumentException    if an invalid rank is provided
     */
     
    public int countInHand( int rank ) {
        int rankCount = 0;
        int cardRank = 0;
        for ( int k = 0; k < getHandSize(); k++ ) {
            if  ( getCardAt(k).getRank() == rank ) {
                rankCount++;
            }
        }
        return rankCount;
    }

    /**
     * Returns the number of cards in this hand with the provided suit.
     *
     * @param suit     the suit being searched for
     * @return         the number of cards in the hand with the provided suit
     */
     
    public int countInHand( Card.Suit suit ) {
        int suitCount = 0;
        for ( int k = 0; k < getHandSize(); k++ ) {
            if ( getCardAt(k).getSuit().equals(suit) ) {
                suitCount++;
            }
        }
        return suitCount;
    }

    /**
     * Returns the number of cards in this hand with the "face" ranks of King,
     * Queen, and Jack.
     *
     * @return         the number of cards in the hand with face ranks
     */
     
    public int countOfFaceCards() {
        int faceCount = 0;
        for ( int k = 0; k < this.cardsInHand.length; k++ ) {
            if ( getCardAt(k).getRank() == 11 ) {
                faceCount++;
            } else if ( getCardAt(k).getRank() == 12 ) {
                faceCount++;
            } else if ( getCardAt(k).getRank() == 13 ) {
                faceCount++;
            }
        }
        return faceCount;
    }
}
