s = input()
s = sorted(s)
ans = ''
if len(s) % 2:
    i = 0
    m = ''
    while i < len(s):
        if i == len(s) -1:
            m += s[i]
            i += 1

        elif s[i] == s[i+1]:
            ans += s[i]
            i += 2
        
        else:
            m += s[i]
            i += 1
        
        if len(m) == 2:
            ans = "I'm Sorry Hansoo"
            break
    else:
        ans = ans + m + ans[::-1]


else:
    for i in range(0,len(s),2):
        if s[i] == s[i+1]:
            ans += s[i]
        else:
            ans = "I'm Sorry Hansoo"
            break
    else:
        ans += ans[::-1]

print(ans)