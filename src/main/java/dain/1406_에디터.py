stack1 = list(input())
# stack2는 반대로 뒤집어서 생각해야 함
stack2 = []
n = int(input())
for _ in range(n):
    move = input().split()
    if move[0] == 'L' and stack1:
        stack2.append(stack1.pop())
    elif move[0] == 'D' and stack2:
        stack1.append(stack2.pop())
    elif move[0] == 'B' and stack1:
        stack1.pop()
    elif move[0] == 'P':
        stack1.append(move[1])
answer_list = stack1 + stack2[::-1]
print("".join(answer_list))

# 시간초과
# x = input()
# n = int(input())
# cursor = len(x)
# for _ in range(n):
#     move = input().split()
#     if move[0] == 'L' and cursor != 0:
#         cursor -= 1
#     elif move[0] == 'D' and cursor != len(x):
#         cursor += 1
#     elif move[0] == 'B' and cursor != 0:
#         x = x[:cursor-1] + x[cursor:]
#         cursor -= 1
#     elif move[0] == 'P':
#         x = x[:cursor] + move[1] + x[cursor:]
#         cursor += 1

# print(x)