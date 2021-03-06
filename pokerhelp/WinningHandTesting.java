package pokerhelp;

import junit.framework.TestCase;
import pokerParts.PokerCard;
import pokerParts.PokerHand;
import pokerParts.PokerTable;

public class WinningHandTesting extends TestCase {
	PokerTable table1 = new PokerTable(new PokerCard('Q', 'S'), 
			new PokerCard('K', 'H'), 
			new PokerCard('3', 'C'), 
			new PokerCard('5', 'D'), 
			new PokerCard('7', 'H'));
	PokerTable table2 = new PokerTable(new PokerCard('Q', 'S'), 
			new PokerCard('K', 'H'), 
			new PokerCard('J', 'C'), 
			new PokerCard('0', 'D'), 
			new PokerCard('7', 'H'));
	PokerTable table3 = new PokerTable(new PokerCard('Q', 'H'), 
			new PokerCard('K', 'H'), 
			new PokerCard('J', 'H'), 
			new PokerCard('0', 'D'), 
			new PokerCard('7', 'H'));
	PokerTable flushTable = new PokerTable(new PokerCard('Q', 'H'), 
			new PokerCard('K', 'H'), 
			new PokerCard('J', 'H'), 
			new PokerCard('0', 'H'), 
			new PokerCard('7', 'H'));
	PokerTable fullHouseTable = new PokerTable(new PokerCard('K', 'C'), 
			new PokerCard('K', 'H'), 
			new PokerCard('J', 'H'), 
			new PokerCard('0', 'H'), 
			new PokerCard('7', 'H'));
	PokerTable twoPairTable = new PokerTable(new PokerCard('K', 'C'), 
			new PokerCard('K', 'H'), 
			new PokerCard('J', 'H'), 
			new PokerCard('J', 'C'), 
			new PokerCard('7', 'H'));
	PokerTable tripleTable = new PokerTable(new PokerCard('K', 'C'), 
			new PokerCard('K', 'H'), 
			new PokerCard('K', 'D'), 
			new PokerCard('J', 'C'), 
			new PokerCard('7', 'H'));
	PokerTable straightFlushTable = new PokerTable(new PokerCard('K', 'C'), 
			new PokerCard('Q', 'C'), 
			new PokerCard('J', 'C'), 
			new PokerCard('0', 'C'), 
			new PokerCard('5', 'H'));

	 
	public void testStraightFlush() {
		PokerHand hand1 = new PokerHand(new PokerCard('A', 'C'), new PokerCard('K', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('9', 'C'), new PokerCard('J', 'D'));
		
		assertEquals(1, CompareTwoHands.determineWinner(twoPairTable, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(twoPairTable, hand2, hand1));
	}
	 
	public void testFourOfaKind() {
		PokerHand hand1 = new PokerHand(new PokerCard('K', 'D'), new PokerCard('K', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('J', 'S'), new PokerCard('J', 'D'));
		
		assertEquals(1, CompareTwoHands.determineWinner(twoPairTable, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(twoPairTable, hand2, hand1));
	}
	 
	public void testFullHouse() {
		PokerHand hand1 = new PokerHand(new PokerCard('K', 'D'), new PokerCard('J', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('K', 'S'), new PokerCard('0', 'D'));
		PokerHand hand3 = new PokerHand(new PokerCard('J', 'C'), new PokerCard('J', 'D'));
		
		assertEquals(1, CompareTwoHands.determineWinner(fullHouseTable, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(fullHouseTable, hand2, hand1));
		assertEquals(1, CompareTwoHands.determineWinner(fullHouseTable, hand1, hand3));
	}
	 
	public void testFlush() {
		PokerHand hand1 = new PokerHand(new PokerCard('6', 'H'), new PokerCard('9', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('2', 'D'), new PokerCard('A', 'H'));
		PokerHand hand3 = new PokerHand(new PokerCard('2', 'C'), new PokerCard('5', 'C'));
		
		assertEquals(2, CompareTwoHands.determineWinner(table3, hand1, hand2));
		assertEquals(1, CompareTwoHands.determineWinner(table3, hand2, hand1));
		assertEquals(0, CompareTwoHands.determineWinner(flushTable, hand1, hand3));
	}
	 
	public void testStraight() {
		PokerHand hand1 = new PokerHand(new PokerCard('7', 'D'), new PokerCard('9', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('2', 'D'), new PokerCard('A', 'D'));
		PokerHand hand3 = new PokerHand(new PokerCard('2', 'C'), new PokerCard('A', 'C'));
		
		assertEquals(2, CompareTwoHands.determineWinner(table2, hand1, hand2));
		assertEquals(1, CompareTwoHands.determineWinner(table2, hand2, hand1));
		assertEquals(0, CompareTwoHands.determineWinner(table2, hand2, hand3));
	}
	 
	public void testHighCard() {
		PokerHand hand1 = new PokerHand(new PokerCard('2', 'H'), new PokerCard('9', 'S'));
		PokerHand hand2 = new PokerHand(new PokerCard('2', 'D'), new PokerCard('J', 'D'));
		PokerHand hand3 = new PokerHand(new PokerCard('2', 'C'), new PokerCard('A', 'C'));
		
		assertEquals(0, CompareTwoHands.determineWinner(table1, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(table1, hand1, hand3));
		assertEquals(1, CompareTwoHands.determineWinner(table1, hand3, hand1));
	}
	 
	public void testOnePair() {
		PokerHand hand1 = new PokerHand(new PokerCard('K', 'S'), new PokerCard('4', 'H'));
		PokerHand hand2 = new PokerHand(new PokerCard('Q' ,'H'), new PokerCard('2', 'C'));
		PokerHand hand3 = new PokerHand(new PokerCard('K' ,'C'), new PokerCard('2', 'C'));
		
		assertEquals(1, CompareTwoHands.determineWinner(table1, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(table1, hand2, hand1));
		assertEquals(0, CompareTwoHands.determineWinner(table1, hand1, hand3));
	}
	  
	public void testTwoPair() {
		PokerHand hand1 = new PokerHand(new PokerCard('K', 'S'), new PokerCard('Q', 'H'));
		PokerHand hand2 = new PokerHand(new PokerCard('K' ,'C'), new PokerCard('Q', 'C'));
		
		assertEquals(0, CompareTwoHands.determineWinner(table1, hand1, hand2));
		
	}
	
	 
	public void testThreeOfaKind() {
		PokerHand hand1 = new PokerHand(new PokerCard('K', 'S'), new PokerCard('K', 'C'));
		PokerHand hand2 = new PokerHand(new PokerCard('Q', 'C'), new PokerCard('Q', 'D'));
		AnalyzeHand analyze1 = new AnalyzeHand(hand1, table1);
		AnalyzeHand analyze2 = new AnalyzeHand(hand2, table1);
		assertEquals(1, CompareTwoHands.determineWinner(table1, hand1, hand2));
		assertEquals(2, CompareTwoHands.determineWinner(table1, hand2, hand1));
	}
}
