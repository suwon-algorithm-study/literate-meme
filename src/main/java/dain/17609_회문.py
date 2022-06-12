# 회문
def check1(w):
    global ans
    left = 0
    right = len(w) - 1
    while left < right:
        if w[left] == w[right]:
            left += 1
            right -= 1
            continue
        else:
            check2(w,left+1,right)
            check2(w,left,right-1)
        return
    ans = 0
    return

# 유사회문
def check2(w, start, end):
    global ans
    left = start
    right = end
    while left < right:
        if w[left] == w[right]:
            left += 1
            right -= 1
            continue
        return
    ans = 1
    return
    
T = int(input())
for _ in range(T):
    word = input()
    ans = 2
    check1(word)
    print(ans)
