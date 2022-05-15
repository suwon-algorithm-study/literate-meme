from collections import deque

def solution(board, moves):
    answer = 0
    q = deque()
    for j in moves:
        for i in range(len(board)):
            if board[i][j-1] != 0:
                if q and (q[-1] == board[i][j-1]):
                    answer += 1
                    q.pop()
                else:
                    q.append(board[i][j-1])
                board[i][j-1] = 0
                break
                
    return answer*2