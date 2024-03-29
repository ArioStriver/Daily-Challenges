/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

METHOD:

TIME: O(NlogN).

SPACE: O(1).
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int n = people.length;
        
        // to get the heaviest person at the end
        Arrays.sort(people);
        
        // at first we assume that ecah person have their own individual boat
        int minBoatsNeeded = n;
        int i = 0, j = n - 1;
        
        // here we are checking if a heaviest person can share a boat with a lightest person or not
        // if so then decrement the boat count otherwise the heaviest person sits in their own boat
        while(i < j){
            
            if(people[i] + people[j] <= limit){
                minBoatsNeeded--;
                i++;
            }
            j--;
        }
        
        return minBoatsNeeded;
    }
}