from collections import defaultdict

def solution(id_list, report, k):
    answer = [0] * len(id_list)
    # 신고리스트 / 신고한유저 - {신고당한유저들}
    report_set = defaultdict(set)
    # 유저별 신고당한 횟수
    reported_count = defaultdict(int)
    # k번 이상 신고당한 사람들
    reported_set = set()
    
    for r in report:
        reporter, reported = r.split(' ')
        report_set[reporter].add(reported)
    # print(report_set)
    
    for key, value in report_set.items():
        for v in value:
            reported_count[v] += 1
    
    for key, value in reported_count.items():
        if value >= k:
            reported_set.add(key)
    
    for i in range(len(id_list)):
        for reported in reported_set:
            if reported in report_set[id_list[i]]:
                answer[i] += 1
                
    return answer