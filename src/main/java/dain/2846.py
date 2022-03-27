n = int(input())
lst = list(map(int,input().split()))
ans = 0
l_min = lst[0]
for i in range(1,len(lst)):
    # 오르막길이 되는 기본 설정
    if lst[i-1] < lst[i]:
        tmp = lst[i] - l_min
        if ans < tmp:
            ans = tmp
    else:
        l_min = lst[i]
print(ans)