from collections import defaultdict

n = int(input())
lst_n = list(map(int,input().split()))
dic_n = defaultdict(int)
for i in lst_n:
    dic_n[i] += 1
m = int(input())
lst_m = list(map(int,input().split()))
ans = [0] * m
for i in range(m):
    ans[i] = dic_n[lst_m[i]]

print(*ans)


# 시간초과
# n = int(input())
# lst_n = list(map(int,input().split()))
# m = int(input())
# lst_m = list(map(int,input().split()))
# ans = [0] * m
# for i in range(m):
#     ans[i] += lst_n.count(lst_m[i])

# print(*ans)