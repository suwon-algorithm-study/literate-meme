import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville:
        tmp1 = heapq.heappop(scoville)
        if tmp1 >= K:
            return answer
        if not scoville:
            return -1
        tmp2 = heapq.heappop(scoville)
        heapq.heappush(scoville,tmp1+(tmp2*2))
        answer += 1
        