n,m = map(int,input().split())
lst = list(map(int,input().split()))
plus = []
minus = []
# 가장 먼 것을 편도로(책 개수만큼)
# -39 -37 -29 -28 -6 0 2 11
for i in lst:
    if i > 0:
        plus.append(i)
    else:
        minus.append(-i)
plus.sort(reverse=True)
minus.sort(reverse=True)
# plus = [11,2]
# minus = [39,37,29,28,6]
ans = 0
if plus and minus:
    if plus[0] < minus[0]:
        for i in range(0,len(plus),m):
            ans += plus[i] * 2
        ans += minus[0]
        for i in range(m,len(minus),m):
            ans += minus[i] * 2
    else:
        for i in range(0,len(minus),m):
            ans += minus[i] * 2
        ans += plus[0]
        for i in range(m,len(plus),m):
            ans += plus[i] * 2

elif plus:
    ans += plus[0]
    for i in range(m,len(plus),m):
        ans += plus[i] * 2

else:
    ans += minus[0]
    for i in range(m,len(minus),m):
        ans += minus[i] * 2

print(ans)