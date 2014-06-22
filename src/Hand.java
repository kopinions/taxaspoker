import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private List<Poker> pokers;

    public Hand(Poker poker, Poker poker1, Poker poker2, Poker poker3, Poker poker4) {
        pokers = Arrays.asList(poker, poker1, poker2, poker3, poker4);
    }

    public Rank getRank() {
        long pockerNumberKinds = pokers.stream().map(p -> p.getNumber()).distinct().count();
        boolean isSameKind = pokers.stream().map(p -> p.getKind()).distinct().count() == 1;
        Map<Integer,List<Integer>> collect = pokers.stream().map(p -> p.getNumber()).collect(Collectors.groupingBy(s -> s));
        long maxPairNumber = collect.entrySet().stream().map(c -> c.getValue().size()).max((c1, c2) -> c1 - c2).get() ;
        if (pockerNumberKinds == 2) {
            if (maxPairNumber == 3) {
                return Rank.FULL_HOUSE;
            }
        }
        if (pockerNumberKinds == 3) {
            if (maxPairNumber == 2) {
                return Rank.TWO_PAIR;
            }
            return Rank.THREE_OF_A_KIND;
        }

        if (pockerNumberKinds == 4) {
            return Rank.ONE_PAIR;
        }

        if (pockerNumberKinds == 5) {
            List<Integer> collect1 = pokers.stream().map(p -> p.getNumber()).collect(Collectors.toList());
            int maxCard = collect1.stream().max((c1, c2) -> c1 - c2).get();
            int minCard = collect1.stream().min((c1, c2) -> c1 - c2).get();
            if (maxCard - minCard == 4) {
                if(isSameKind && maxCard == 14) {
                    return Rank.ROYAL_FLUSH;
                } else if(isSameKind){
                    return Rank.STRAIGHT_FLUSH;
                } else {
                    return Rank.STRAIGHT;
                }
            }else {
                if (isSameKind) {
                    return Rank.FLUSH;
                }
                return Rank.HIGH_CARD;
            }
        }

        return Rank.FOUR_OF_A_KIND;
    }

    @Override
    public int compareTo(Hand o) {
        Rank thisRank = getRank();
        Rank thatRank = o.getRank();
        if (thisRank != thatRank) {
            return thisRank.compareTo(thatRank);
        }
        Integer thisMaxCard = pokers.stream().map(p -> p.getNumber()).max((c1, c2) -> c1 - c2).get();
        Integer thatMaxCard = o.getPokers().stream().map(p -> p.getNumber()).max((c1, c2) -> c1 - c2).get();
        if(thisRank==Rank.STRAIGHT_FLUSH||
                thisRank== Rank.HIGH_CARD ||
                thisRank==Rank.STRAIGHT ||
                thisRank == Rank.FLUSH) {
            if (thisMaxCard % 13 - thatMaxCard % 13 == 0) {
                return 0;
            } else if (thisMaxCard % 13 - thatMaxCard % 13 > 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if(thisRank==Rank.FULL_HOUSE || thisRank==Rank.FOUR_OF_A_KIND || thisRank == Rank.THREE_OF_A_KIND || thisRank == Rank.TWO_PAIR || thisRank==Rank.ONE_PAIR) {
            List<Integer> pairs = getWeightList();
            List<Integer> pairs2 = o.getWeightList();

            for (int i=0; i<pairs.size(); i++) {
                if (pairs.get(i) != pairs2.get(i)) {
                    return pairs.get(i).compareTo(pairs2.get(i));
                }
            }
            return 0;
        }
        return 0;
    }

    private List<Integer> getWeightList() {
        Map<Integer, List<Integer>> collect = pokers.stream().map(p -> p.getNumber()).collect(Collectors.groupingBy(s -> s));
        return collect.keySet().stream()
                .sorted((p1, p2) -> -(collect.get(p1).size() - collect.get(p2).size()))
                .collect(Collectors.toList());
    }

    public List<Poker> getPokers() {
        return pokers;
    }


    public enum Rank {HIGH_CARD,ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE,  FOUR_OF_A_KIND, STRAIGHT_FLUSH ,ROYAL_FLUSH}
}
