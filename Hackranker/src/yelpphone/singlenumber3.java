package yelpphone;

public class singlenumber3 {
	public static void main(String[] args){
		int[] in = {1,2,2,3,3,4};
		System.out.println(singleNumber(in));
	}
	public static int[] singleNumber(int[] nums) {
	    int result[] = new int[2];        
	    int xor = nums[0];
	    for (int i=1; i<nums.length; i++)
	    {
	        xor ^= nums[i];
	    }
	    int neg = xor & (-xor);
	    int neg2 = ~xor;
	    int neg3 = ~(xor-1);
	    int bit = xor & ~(xor-1);
	    int num1 = 0;
	    int num2 = 0;
	    
	    for (int num : nums)
	    {
	        if ((num & bit) > 0)
	        {
	            num1 ^= num;
	        }
	        else
	        {
	            num2 ^= num;
	        }
	    }
	    
	    result[0] = num1;
	    result[1] = num2;
	    return result;
	}
}
