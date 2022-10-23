T = int(input())
for tc in range(T):
    n = int(input())
    lst = [0] * n
    for _ in range(n):
        a,b = map(int,input().split())
        lst[a-1] = b
    cnt = 1
    high_rank = lst[0]
    for i in range(1,n):
        if high_rank > lst[i]:
            cnt += 1
            high_rank = lst[i]
    print(cnt)
