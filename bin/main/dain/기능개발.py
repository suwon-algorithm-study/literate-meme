def solution(progresses, speeds):
    answer = []
    while progresses:
        cnt = 0
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        for i in range(len(progresses)):
            if progresses[i] < 100:
                if cnt != 0:
                    answer.append(cnt)
                break
            else:
                cnt += 1
        progresses = progresses[cnt:]
        speeds = speeds[cnt:]
        if not progresses:
            answer.append(cnt)
    return answer