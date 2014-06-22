import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RankTest {
    @Test
    public void should_royal_flush_equal() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 11),
                new Poker(Poker.Kind.HEART, 10)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 11),
                new Poker(Poker.Kind.HEART, 10)
        );
        assertEquals(0, hand1.compareTo(hand2));
    }


    @Test
    public void should_royal_bigger_straight_flush() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 11),
                new Poker(Poker.Kind.HEART, 10)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 13),
                new Poker(Poker.Kind.SPADE, 12),
                new Poker(Poker.Kind.SPADE, 11),
                new Poker(Poker.Kind.SPADE, 10),
                new Poker(Poker.Kind.SPADE, 9)
        );
        assertEquals(1, hand1.compareTo(hand2));
    }
    @Test
    public void should_straight_flush_bigger_than_four_of_a_hand() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 13),
                new Poker(Poker.Kind.SPADE, 12),
                new Poker(Poker.Kind.SPADE, 11),
                new Poker(Poker.Kind.SPADE, 10),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 9)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_four_of_a_hand_bigger_full_house() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 2),
                new Poker(Poker.Kind.DIAMOND, 9),
                new Poker(Poker.Kind.SPADE, 9)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }
    @Test
    public void should_full_house_bigger_flush() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 2),
                new Poker(Poker.Kind.DIAMOND, 9),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_flush_bigger_straight() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 3),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_straight_bigger_three_of_kind() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 3),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }
    @Test
    public void should_three_of_one_bigger_two_pair() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.DIAMOND, 4),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_two_pair_bigger_one_pair() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }
    @Test
    public void should_one_pair_bigger_high_card() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.DIAMOND, 3),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 9)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.DIAMOND, 5),
                new Poker(Poker.Kind.SPADE, 6),
                new Poker(Poker.Kind.SPADE, 8)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_straight_flush() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 6),
                new Poker(Poker.Kind.SPADE, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_high_card() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.HEART, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.CLUB, 9),
                new Poker(Poker.Kind.SPADE, 6),
                new Poker(Poker.Kind.SPADE, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.CLUB, 8),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_flush() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.HEART, 3),
                new Poker(Poker.Kind.HEART, 4),
                new Poker(Poker.Kind.HEART, 9),
                new Poker(Poker.Kind.HEART, 6),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 8),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }
    @Test
    public void should_compare_full_house() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.CLUB, 14),
                new Poker(Poker.Kind.HEART, 7),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 6),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_four_of_a_kind() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.CLUB, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }


    @Test
    public void should_compare_three_of_a_kind() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.CLUB, 14),
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.DIAMOND, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_two_pair() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.CLUB, 13),
                new Poker(Poker.Kind.HEART, 13),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.DIAMOND, 3),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_one_pair() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.SPADE, 14),
                new Poker(Poker.Kind.HEART, 14),
                new Poker(Poker.Kind.CLUB, 13),
                new Poker(Poker.Kind.HEART, 12),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 2),
                new Poker(Poker.Kind.DIAMOND, 3),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.SPADE, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void should_compare_staright() {
        Hand hand1 = new Hand(
                new Poker(Poker.Kind.HEART, 3),
                new Poker(Poker.Kind.SPADE, 4),
                new Poker(Poker.Kind.HEART, 5),
                new Poker(Poker.Kind.CLUB, 6),
                new Poker(Poker.Kind.HEART, 7)
        );
        Hand hand2 = new Hand(
                new Poker(Poker.Kind.HEART, 2),
                new Poker(Poker.Kind.SPADE, 3),
                new Poker(Poker.Kind.CLUB, 4),
                new Poker(Poker.Kind.SPADE, 5),
                new Poker(Poker.Kind.DIAMOND, 6)
        );

        assertEquals(1, hand1.compareTo(hand2));
    }


}
