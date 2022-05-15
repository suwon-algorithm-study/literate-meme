n = int(input())
lst = [int(input()) for _ in range(n)]
lst.sort()
max_val = 0
for i in range(len(lst)):
    n = lst[i] * (len(lst) - i)
    if max_val < n:
        max_val = n

print(max_val)