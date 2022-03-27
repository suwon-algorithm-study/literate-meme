from collections import deque

def solution(s):
    ans = ''
    set_word = {'z','o','t','f','s','e','n'}
    
    q = deque(s)
    while q:
        x = q.popleft()
        if x in set_word:
            if x == 'z':
                ans += '0'
                q.popleft()
                q.popleft()
                q.popleft()
            elif x == 'o':
                ans += '1'
                q.popleft()
                q.popleft()
            elif x == 't':
                y = q.popleft()
                if y == 'w':
                    ans += '2'
                    q.popleft()
                else:
                    ans += '3'
                    q.popleft()
                    q.popleft()
                    q.popleft()
            elif x == 'f':
                y = q.popleft()
                if y == 'o':
                    ans += '4'
                    q.popleft()
                    q.popleft()
                else:
                    ans += '5'
                    q.popleft()
                    q.popleft()
            elif x == 's':
                y = q.popleft()
                if y == 'i':
                    ans += '6'
                    q.popleft()
                else:
                    ans += '7'
                    q.popleft()
                    q.popleft()
                    q.popleft()
            elif x == 'e':
                ans += '8'
                q.popleft()
                q.popleft()
                q.popleft()
                q.popleft()
            elif x =='n':
                ans += '9'
                q.popleft()
                q.popleft()
                q.popleft()
        else:
            ans += x
    
    return int(ans)