lst = []
for i in range(4):
    x, y = map(int,input().split())
    if i == 0:
        lst.append(y)
    else:
        lst.append(lst[i-1]-x+y)
print(max(lst))
