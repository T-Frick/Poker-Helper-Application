package pokerParts;

import java.util.Random;

public class PokerHand {
	
	private PokerCard card1;
	private PokerCard card2;
	
	public PokerHand(PokerCard card1, PokerCard card2) {
		this.card1 = card1;
		this.card2 = card2;
	}
	
	public PokerHand() {
		card1 = null;
		card2 = null;
	}
	
	public void addCard(PokerCard card) {
		if(card1 == null)
			card1 = card;
		else if(card2 == null)
			card2 = card;
		else
			System.out.println("Can't add card. Hand is already full.");
	}

	
	public PokerCard getCard1() {
		return card1;
	}
	public PokerCard getCard2() {
		return card2;
	}
	public void printHand() {
		System.out.println(card1.getCard() + card2.getCard());
	}
	
	public static PokerHand randomHand() {
		Random r = new Random();
		int card1Value = r.nextInt(13) + 1;
		int card1Suit = r.nextInt(4) + 1;
		int card2Value = r.nextInt(13) + 1;
		int card2Suit = r.nextInt(4) + 1;
		return new PokerHand(PokerTable.convertToCard(card1Value, card1Suit), PokerTable.convertToCard(card2Value, card2Suit));
	}
}
