求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class Solution {
    public int Sum_Solution(int n) {
        if(n<=0) return 0;
        return n+Sum_Solution(n-1);
    }
}

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Solution {
    public int Add(int num1,int num2) {
        return num2==0?num1:Add(num1^num2,(num1&num2)<<1);
    }
}






  public int StrToInt(String str) {
        if("".equals(str)) return 0;
        boolean isminus=false;
        int i=0;
        if(str.charAt(0)=='+') i++;
        if(str.charAt(0)=='-'){
            isminus=true;
            i++;
        }
        int res=0;
        for(;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='0'&&c<='9'){
                if(isFlo(res,c-'0',isminus)){
                    return 0;
                }
                res=res*10+(c-'0');
            }else{
                return 0;
            }
        }
        return isminus?-res:res;
    }
    
    private boolean isFlo(int num,int carry,boolean isminus){
        if(isminus){
            return num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&carry>8);
        }else{
            return num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&carry>7);
        }
    }
	
	
	
	
叠罗汉
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[][] arr=new int[n][2];
            for(int i=0;i<n;i++){
                int num=sc.nextInt();
                arr[num-1][1]=sc.nextInt();
                arr[num-1][0]=sc.nextInt();
            }
            Arrays.sort(arr,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
            int res=0;
            int[] dp=new int[n];
            Arrays.fill(dp,1);
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[i][1]>arr[j][1]||(arr[i][1]==arr[j][1]&&arr[i][0]==arr[j][0])){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                res=Math.max(res,dp[i]);
            }
            System.out.println(res);
        }
    }
	
	
	
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对
应的输出是第一个重复的数字2。
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[numbers[i]]==numbers[i]){
                    duplication[0]=numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        
        return false;
    }
    private void swap(int[] numbers,int left,int right){
        int tmp=numbers[left];
        numbers[left]=numbers[right];
        numbers[right]=tmp;
    }
}


