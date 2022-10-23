'''
시간초과
w,h = map(int,input().split())
p,q = map(int,input().split())
t = int(input())
# 방향
d1 = 1
d2 = 1

while t > 0:
    p = p + d1
    if p == 0 or p == w:
        d1 *= -1
    q = q + d2
    if q == 0 or q == h:
        d2 *= -1
    t -= 1

print(p,q)
'''

w,h = map(int,input().split())
p,q = map(int,input().split())
t = int(input())

if ((p+t)//w)%2:
    p = w-(p+t)%w
elif ((p+t)//w)%2 == 0:
    p = (p+t)%w

if ((q+t)//h)%2:
    q = h-(q+t)%h
elif ((q+t)//h)%2 == 0:
    q = (q+t)%h

print(p,q)