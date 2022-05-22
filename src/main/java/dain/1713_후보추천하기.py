n = int(input())
r = int(input())
lst = list(map(int,input().split()))

recommend = []
frame = set()

for i in lst:
    # 프레임 안에 없다면
    if i not in frame:
        if len(frame) == n:
            min_val = 1000
            for idx in range(len(recommend)):
                min_val = min(min_val,recommend[idx][1])
            for idx in range(len(recommend)):
                if min_val == recommend[idx][1]:
                    frame.remove(recommend[idx][0])
                    recommend.pop(idx)
                    break
        recommend.append([i,1])
        frame.add(i)
    # 프레임 안에 그 값이 있다면
    else:
        for idx in range(len(recommend)):
            if recommend[idx][0] == i:
                recommend[idx][1] += 1
                break

answer = []
for x,y in recommend:
    answer.append(x)
answer.sort()
print(*answer)