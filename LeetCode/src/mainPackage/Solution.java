package mainPackage;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	 
	public int[] twoSum(int[] nums, int target) {
		int[] answer=new int[2]; 
		Map<Integer,Integer> sawNumbers = new HashMap<Integer, Integer>();
		int mashlemNumber;
		for(int i = 0 ; i<nums.length ; i++) {
			mashlemNumber=target-nums[i];
			if( sawNumbers.containsKey(mashlemNumber)) {
				answer[0]=i;
				answer[1]=sawNumbers.get(mashlemNumber);
				return answer;
			}
			else {
				sawNumbers.put(nums[i],i);
			}
		}
		 
		return answer;
		 
	    }
	public int reverse(int x) {
		//This result will gives us reverse string.
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10; // Dividing the value by % gives us remainder back so. We can get the last value
            int newResult = result * 10 + tail; // in the newresult adding the tail value which we got because let say we have something like 
			//this 123, and from tail we got 3. Now what will happen when we add 2 after 3 when we come back we have something like 
			//30 + 2 = 32 and again we come back with carrying 1 we have 320 + 1 = 321, Integer is reversed.
            if ((newResult - tail) / 10 != result) // checking if it's not valid. Return 0.
            { 
                return 0; 
            }
            result = newResult; // dumping the newResult value in result
            x = x / 10; // updating our x integer/
        }

        return result;
    }
	
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
	}

	
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
        int currentSum = maxSum;
        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {	       
		//inspired from popular solution on discussion page
        
        //counter index values from behind
        int ctr = m + n -1;
        //decrementing m and n to match array indexing.
        m--;
        n--;
        
        while(m>=0 && n>=0){
        
            //adding values from right side and decrementing ctr, m and n respectively
            if(nums1[m] >= nums2[n]){
                nums1[ctr--] = nums1[m--];
            }else if(nums2[n] > nums1[m]){
                 nums1[ctr--] = nums2[n--];
            }
        }
        //adding the elements from nums2 if remaining.
        while (n>=0){
            nums1[ctr--] = nums2[n--];
        }
	}
       

	public boolean isPalindrome(int x) {
		 	int temp = x;
	        int sum = 0;
	        while (x>0) {
	            int rem = x%10;
	            sum = (sum*10) + rem;
	            x = x/10;
	        }
	        if (temp == sum) {
	            return true;
	        }
	        else{
	            return false;
	        }
    }
	
	 public int romanToInt(String s) 
	    {
	        int sum = 0;
	        for(int i = 0; i < s.length(); i++)
	        {
	            switch(s.charAt(i))
	            {
	                case 'I':
	                    if(s.length() != i+1)
	                    {
	                        if(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')
	                        {sum--; }
	                        else
	                        {sum++; } }
	                    else{sum++;}
	                    break;
	                case 'V':
	                    sum+=5;
	                    break;
	                case 'X':
	                    if(s.length() != i+1)
	                    {
	                        if(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')
	                        {sum -=10; }
	                        else
	                        {sum += 10;}}
	                    else
	                    {sum +=10; }
	                    break;
	                case 'L':
	                    sum+=50;
	                    break;
	                case 'C':
	                    if(s.length() != i+1)
	                    {
	                        if(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')
	                        {sum -=100;}
	                        else
	                        {sum += 100; }
							}
	                    else
	                    {sum +=100;}
	                    break;
	                case 'D':
	                    sum+=500;
	                    break;
	                case 'M':
	                    sum+=1000;
	                    break;
	            }
	        }
	            
	        return sum;
	    }
}
