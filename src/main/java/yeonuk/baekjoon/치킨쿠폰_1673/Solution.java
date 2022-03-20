package yeonuk.baekjoon.치킨쿠폰_1673;

public class Solution {

    public int solve(int n, int k) {
        int chicken = n;
        int coupon = chicken;
        int extra;

        while (k <= coupon) {
            extra = coupon % k;
            coupon /= k;
            chicken += coupon;
            coupon += extra;
        }

        return chicken;
    }
}
