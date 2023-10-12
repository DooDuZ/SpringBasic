package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * 10 / 100;
        }
        return 0;
    }
}
