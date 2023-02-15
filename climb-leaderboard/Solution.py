#!/bin/python3

import math
import os
import random
import re
import sys

def climbingLeaderboard(ranked, player):
    player.sort(reverse=True)
    newRank = []
    noDuplRank = [*set(ranked)]
    noDuplRank.sort(reverse=True)

    for score in player:
        for scoreAlready in noDuplRank:
            if(score >= scoreAlready):
                newRank.append(noDuplRank.index(scoreAlready)+1)
                break

    if player[len(player) - 1] < noDuplRank[len(noDuplRank) - 1]:
        newRank.append(len(noDuplRank) + 1)
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
