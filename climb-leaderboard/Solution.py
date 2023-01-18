#!/bin/python3

import math
import os
import random
import re
import sys

def climbingLeaderboard(ranked, player):
    player.sort(reverse=True)
    print(ranked)
    print(player)
    newRank = []
    for score in player:
        for n in ranked:
            if(score >= n):
                ranked.insert(ranked.index(n), score)
                break

    if player[len(player) - 1] not in ranked:
        ranked.append(player[len(player) - 1])
    
    noDuplRank = [*set(ranked)]
    noDuplRank.sort(reverse=True)
    
    for x in player:
        if x in noDuplRank:
            newRank.append(noDuplRank.index(x) + 1)
    newRank.sort(reverse=True)
    return newRank


if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')
    ranked_count = int(input().strip())
    ranked = list(map(int, input().rstrip().split()))
    player_count = int(input().strip())
    player = list(map(int, input().rstrip().split()))
    result = climbingLeaderboard(ranked, player)
    print('\n'.join(map(str, result)))
    #fptr.write('\n'.join(map(str, result)))
    #fptr.write('\n')
    #fptr.close()
