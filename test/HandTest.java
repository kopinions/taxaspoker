import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    @Test
    public void should_identify_full_house() {
        Hand hand = new Hand(new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.CLUB, 3),
                new Poker(Poker.Kind.SPADE, 3)
        );
        assertEquals(Hand.Rank.FULL_HOUSE, hand.getRank());
    }

    @Test
    public void should_identify_four_of_a_kind() {
        Hand hand = new Hand(new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.CLUB, 2),
                new Poker(Poker.Kind.SPADE, 3)
        );
        assertEquals(Hand.Rank.FOUR_OF_A_KIND, hand.getRank());
    }

    @Test
    public void should_identify_three_of_a_kind() {
        Hand hand = new Hand(new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.CLUB, 5),
                new Poker(Poker.Kind.SPADE, 3)
        );
        assertEquals(Hand.Rank.THREE_OF_A_KIND, hand.getRank());
    }

    @Test
    public void should_identify_two_pair() {
        Hand hand = new Hand(new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.CLUB, 5),
                new Poker(Poker.Kind.SPADE, 3)
        );
        assertEquals(Hand.Rank.TWO_PAIR, hand.getRank());
    }

    @Test
    public void should_identify_one_pair() {
        Hand hand = new Hand(new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 6),
                new Poker(Poker.Kind.CLUB, 5),
                new Poker(Poker.Kind.SPADE, 3)
        );
        assertEquals(Hand.Rank.ONE_PAIR, hand.getRank());
    }

    @Test
    public void should_identify_roy_flush() {
        Hand hand = new Hand(new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 11),
                new Poker(Poker.Kind.HEART, 10)
        );
        assertEquals(Hand.Rank.ROYAL_FLUSH, hand.getRank());
    }

    @Test
    public void should_identify_straight_flush() {
        Hand hand = new Hand(
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 11),
                new Poker(Poker.Kind.HEART, 10),
                new Poker(Poker.Kind.HEART, 9)
        );
        assertEquals(Hand.Rank.STRAIGHT_FLUSH, hand.getRank());
    }


    @Test
    public void should_identify_straight() {
        Hand hand = new Hand(
                new Poker(Poker.Kind.SPADE, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.CLUB, 11),
                new Poker(Poker.Kind.HEART, 10),
                new Poker(Poker.Kind.DIAMOND, 9)
        );
        assertEquals(Hand.Rank.STRAIGHT, hand.getRank());
    }

    @Test
    public void should_identify_flush() {
        Hand hand = new Hand(
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 12),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 10),
                new Poker(Poker.Kind.SPADE, 9)
        );
        assertEquals(Hand.Rank.FLUSH, hand.getRank());
    }

    @Test
    public void should_identify_high_card() {
        Hand hand = new Hand(
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.CLUB, 12),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 10),
                new Poker(Poker.Kind.SPADE, 9)
        );
        assertEquals(Hand.Rank.HIGH_CARD, hand.getRank());
    }



}
