n = int(input())

# 5 를 뺐을 때 5 로 나눈 나머지가 3이 나온다면 빼도됨
cnt = 0

while n > 0:

    if n == 3:
        cnt += 1
        break

    if ((n - 5) % 5) % 3 == 0:
        n = n - 5
        cnt += 1
        
    else:
        n = n - 3
        cnt += 1

if n < 0:
    ans = -1
else:
    ans = cnt

print(ans)