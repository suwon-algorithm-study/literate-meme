m,n = map(int,input().split())
arr = [[0]*n for _ in range(m)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
x,y = 0,0
d = 0
cnt = 0
arr[0][0] = 1
flag = 0
while 1:
    nx = x + dx[d]
    ny = y + dy[d]
    if flag == 1 and arr[nx][ny] == 1:
        break
    if nx < 0 or nx >= m or ny < 0 or ny >= n or arr[nx][ny] == 1:
        d = (d+1) % 4
        cnt += 1
        flag = 1
        continue
    arr[nx][ny] = 1
    x,y = nx,ny
    flag = 0
print(cnt-1)