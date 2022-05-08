# 효율성 실패 코드1
def solution(info, query):
    applicants = []
    wanted = []
    answer = []
    for i in info:
        applicants.append(i.split())
    for j in query:
        wanted.append(j.replace('and','').split())
    # 1차 숫자로 거르기 위해 정렬
    applicants.sort(key=lambda x: -int(x[4]))
    
    for w in wanted:
        cnt = 0
        for a in applicants:
            if int(a[-1]) < int(w[-1]):
                answer.append(cnt)
                break
            if w[0] == '-':
                pass
            elif w[0] != a[0]:
                continue
            if w[1] == '-':
                pass
            elif w[1] != a[1]:
                continue
            if w[2] == '-':
                pass
            elif w[2] != a[2]:
                continue
            if w[3] == '-':
                pass
            elif w[3] != a[3]:
                continue
            cnt += 1
        else:
            answer.append(cnt)
                    
    return answer


# 효율성 실패 코드2
from bisect import bisect_left

def solution(info, query):
    applicants = []
    wanted = []
    answer = []
    score_lst = []
    for i in info:
        applicants.append(i.split())
        score_lst.append(int(applicants[-1][-1]))
    for j in query:
        wanted.append(j.replace('and','').split())
    
    # 1차 숫자로 거르기 위해 정렬
    applicants.sort(key=lambda x: int(x[4]))
    score_lst.sort()
    
    # 이진탐색으로 wanted의 점수에 부합하는 지원자들의 index찾기
    idx_lst = []
    for w in wanted:
        key = int(w[-1])
        idx = bisect_left(score_lst, key)
        idx_lst.append(idx)
    
    for w in range(len(wanted)):
        cnt = 0
        for a in range(idx_lst[w],len(applicants)):
            if wanted[w][0] == '-':
                pass
            elif wanted[w][0] != applicants[a][0]:
                continue
            if wanted[w][1] == '-':
                pass
            elif wanted[w][1] != applicants[a][1]:
                continue
            if wanted[w][2] == '-':
                pass
            elif wanted[w][2] != applicants[a][2]:
                continue
            if wanted[w][3] == '-':
                pass
            elif wanted[w][3] != applicants[a][3]:
                continue
            cnt += 1
        answer.append(cnt)
    
    
    for w in wanted:
        cnt = 0
        for a in applicants:
            if int(a[-1]) < int(w[-1]):
                answer.append(cnt)
                break
            if w[0] == '-':
                pass
            elif w[0] != a[0]:
                continue
            if w[1] == '-':
                pass
            elif w[1] != a[1]:
                continue
            if w[2] == '-':
                pass
            elif w[2] != a[2]:
                continue
            if w[3] == '-':
                pass
            elif w[3] != a[3]:
                continue
            cnt += 1
        else:
            answer.append(cnt)
                        
    return answer