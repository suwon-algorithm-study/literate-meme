# from collections import deque
# n, k = map(int,input().split())

# # 나눴을 때 몫이 0이 될 때까지
# q = deque()
# for i in range(1,n+1):
#     q.append(i)

# while q:
#     x = q.popleft()
#     if x % k == 0:
#         q.append(q[-1] + 1)

# print(x)

# n, k = map(int,input().split())
# tmp = 0
# tmp += n//k
# n += tmp
# tmp = n - tmp*k
# while tmp//k > 0:
#     n += tmp//k
#     tmp = n - tmp*k
# print(n)

while 1:
    try:
        n, k = map(int,input().split())
        tmp = n # 안 쓴 도장 수

        while tmp//k > 0:
            n += tmp // k
            tmp = tmp // k + tmp % k

        print(n)
    except:
        break
