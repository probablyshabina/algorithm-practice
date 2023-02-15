#!/bin/python3

import math
import os
import random
import re
import sys


def highestValuePalindrome(s, n, k):
    isEvenStr = len(s) % 2 == 0
    left = []
    right = []
    midVal = []
    mid = 0

    if (isEvenStr):
        mid = int(len(s) / 2)
        right = list(s[mid:])
    else:
        mid = int(len(s) / 2)
        right = list(s[mid + 1:])
        if(s[mid] != "9"):
            midVal.append("9")
        else:
            midVal.append(s[mid])
    
    right.reverse()
    left = list(s[:mid])

    for i in range(0, mid, 1):
        if (left[i] != right[i]):
            if (k == 1):
                if (left[i] > right[i]):
                    right[i] = left[i]
                else:
                    left[i] = right[i]
            elif (k >= 2):
                left[i] = "9"
                right[i] = "9"
                k -= 1
            else:
                break
            k -= 1
        else:
            if (k >= 2):
                if (left[i] != "9"):
                    left[i] = "9"
                    right[i] = "9"
                    k -= 2
            else:
                break

    if (left == right):
        right.reverse()
        if (isEvenStr):
            print("".join(left + right))
        else:
            print("".join(left + midVal + right))
    else:
        print("-1")


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    s = input()

    result = highestValuePalindrome(s, n, k)

    fptr.write(result + '\n')

    fptr.close()
