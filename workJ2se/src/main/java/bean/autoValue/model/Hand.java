package bean.autoValue.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

/**
 * 包含陣列的應用
 * 
 * @author ai
 *
 */
@AutoValue
public abstract class Hand {
//    public static void main(String args[]) {
//        Hand fullHouseHand = Hand.builder().name("Full House").addCard("King").addCard("King").addCard("King")
//                .addCard("10").addCard("10").build();
//        System.out.print(fullHouseHand);
//    }
//
//    public static Builder builder() {
//        return new AutoValue_Hand.Builder();
//    }
//
//    public abstract Builder toBuilder();
//
//    public abstract String name();
//
//    public abstract ImmutableList<String> cards();
//
//    @AutoValue.Builder
//    public static abstract class Builder {
//
//        public abstract Builder name(String name);
//
//        protected abstract ImmutableList.Builder<String> cardsBuilder();
//
//        public Builder addCard(String card) {
//            cardsBuilder().add(card);
//            return this;
//        }
//
//        public abstract Hand build();
//    }
}