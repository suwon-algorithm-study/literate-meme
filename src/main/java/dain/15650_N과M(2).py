n,m = map(int,input().split())
s = []
def dfs(start):
    if len(s) == m:
        print(' '.join(map(str,s)))
        return
    
    for i in range(start,n+1):
        if i not in s:
            s.append(i)
            dfs(i+1)
            s.pop()

dfs(1)


'''
itertools

from itertools import combinations

n,m = map(int,input().split())
lst = [i for i in range(1,n+1)]
res = list(combinations(lst,m))

for i in res:
    for j in i:
        print(j,end=' ')
    print()
'''