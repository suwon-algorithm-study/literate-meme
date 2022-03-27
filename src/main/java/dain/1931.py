n = int(input())
lst = []
for _ in range(n):
    s,e = map(int,input().split())
    lst.append((s,e))

lst.sort(key=lambda x:(x[1],x[0]))

end = lst[0][1]
ans = 1

for i in range(1,len(lst)):
    if end <= lst[i][0]:
        ans += 1
        end = lst[i][1]
        
print(ans)


# n = int(input())
# lst = []
# for _ in range(n):
#     s,e = map(int,input().split())
#     lst.append((s,e))

# lst.sort(key=lambda x : x[1])
# print(lst)
# start = lst[0][0]
# end = lst[0][1]
# ans = 1
# print((start,end),end=' ')
# for i in range(1,len(lst)):
#     if start == lst[i][0]:
#         pass

#     elif end > lst[i][1]:
#         start = lst[i][0]
#         end = lst[i][1]
#         print((start,end),end=' ')
    
#     elif end <= lst[i][1]:
#         if end <= lst[i][0]:
#             ans += 1
#             start = lst[i][0]
#             end = lst[i][1]
#             print((start,end),end=' ')