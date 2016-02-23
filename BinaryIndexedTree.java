//implemented using array and bit manipulation
class BinaryIndexedTree{
  int[] BIT;
	public BinaryIndexedTree(int[] nums){
	    this.nums=nums;
	    int length=nums.length;
	    BIT=new int[length+1];
	    for(int i=0;i<length;i++){
	        int temp=i+1;
	        int k=nums[i];
	        while(temp<=length){
	            BIT[temp]+=k;
	            temp+=temp&(-temp);
	        }
	    }
	}
	
	void update(int i, int val){
	    int length=nums.length;
	    int temp=i+1;
	    int change=val-nums[i];
	    nums[i]=val;
	    while(temp<=length){
	        BIT[temp]+=change;
	        temp+=temp&(-temp);
	    }
	}
	
	int get(int i){
	    int temp=i+1;
	    int result=0;
	    while(temp>0){
	        result+=BIT[temp];
	        temp-=temp&(-temp);
	    }
	    return result;
	}
}
