a, b = map(int,input().split())
c = int(input())

if b+c < 60:
    print(a,b+c)

elif (b+c) % 60 == 0:
    if a + (b+c)//60 < 24:
        print(a + (b+c)//60,0)
    else:
        print((a + (b+c)//60)-24,0)

elif b+c > 60:
    a += (b+c)//60
    if a >= 24:
        a -= 24
    print(a,(b+c)%60)
