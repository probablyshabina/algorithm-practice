class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #print(s)
        substrings = []

        for n1 in range(len(s)):
            string = ""
            for n2 in range(n1, len(s)):
                #print(n2, s[n2], end=" ")
                if(n2 + 1 < len(s)):
                    if(s[n2] != s[n2 + 1]):
                        if s[n2] not in string:
                            string += s[n2]
                    else:
                        break
            substrings.append(len(string))
            #print(" - ", string , len(string))

        substrings.sort(reverse=True)
        #print(substrings)
        #print(substrings[0])
        return substrings[0]

if __name__ == "__main__":
    string = input().replace('"','')
    Sol = Solution()
    print(Sol.lengthOfLongestSubstring(string))
        
