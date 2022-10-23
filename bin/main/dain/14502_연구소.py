from itertools import combinations
from collections import deque
from copy import deepcopy

n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

# 0에서 1이라는 벽 세 개 세우기 위함.
lst = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            lst.append((i,j))

dx = [0,1,0,-1]
dy = [1,0,-1,0]

def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    while queue:
        x,y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < n and 0 <= ny < m and arr_tmp[nx][ny] == 0:
                queue.append((nx,ny))
                arr_tmp[nx][ny] = 2

ans = 0
for idx in list(combinations(lst,3)):
    arr_tmp = deepcopy(arr)
    for a in idx:
        arr_tmp[a[0]][a[1]] = 1
    
    lst_2 = []
    for i in range(n):
        for  j in range(m):
            if arr_tmp[i][j] == 2:
                lst_2.append((i,j))
    
    for i in lst_2:
        bfs(i[0],i[1])
    
    cnt = 0
    for i in arr_tmp:
        cnt += i.count(0)

    ans = max(ans,cnt)

print(ans)