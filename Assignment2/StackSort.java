public class StackSort {
	private MyStack<Integer> sorter;
	public StackSort(){	
	}
	public String[] sort(int[] nums) {
		try{sorter=new MyStack<Integer>();
		int[] sarray=new int[nums.length];
		int k=0;
		String[] s=new String[2*nums.length];
		sorter.push(nums[0]);
		s[0]="PUSH";
		int j=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>sorter.top()) {
				sarray[k]=sorter.pop();
				k++;
				s[j]="POP";
				j++;
				while(!(sorter.isEmpty()) && sorter.top()<nums[i]) {
					sarray[k]=sorter.pop();
					k++;
					s[j]="POP";
					j++;
				}
				sorter.push(nums[i]);
				s[j]="PUSH";
				j++;
			}
			else {
				sorter.push(nums[i]);
				s[j]="PUSH";
				j++;
			}
		}
		while(!sorter.isEmpty()) {
			sarray[k]=sorter.pop();
			k++;
			s[j]="POP";
			j++;
		}
		
		int b=0;
		for(int g=1;g<sarray.length;g++) {
			if(sarray[g]>=sarray[g-1]) {
				
			}
			else {
				b++;
			}
		
		}
		if(b==0) {
			return s;
		}
		String[] m= new String[1];
		m[0]="NOTPOSSIBLE";
		return m;}
		catch(Exception e) {
			String[] m= new String[1];
			m[0]="NOTPOSSIBLE";
			return m;
		}
	}
	String[][] kSort(int[] nums) {
		//ArrayList<String[]> ss= new ArrayList<String[]>(1);
		try{int ep=0;
		sorter=new MyStack<Integer>();
		
		MyStack<String[]> tem= new MyStack<String[]>();
 		while(true) {
			ep++;
			int[] sarray=new int[nums.length];
			int k=0;
			String[] s=new String[2*nums.length];
			sorter.push(nums[0]);
			s[0]="PUSH";
			int j=1;
			for(int i=1;i<nums.length;i++) {
				if(nums[i]>sorter.top()) {
					sarray[k]=sorter.pop();
					k++;
					s[j]="POP";
					j++;
					while(!(sorter.isEmpty()) && sorter.top()<nums[i]) {
						sarray[k]=sorter.pop();
						k++;
						s[j]="POP";
						j++;
						
					}
					sorter.push(nums[i]);
					s[j]="PUSH";
					j++;
				}
				else {
					sorter.push(nums[i]);
					s[j]="PUSH";
					j++;
				}
			}
			while(!sorter.isEmpty()) {
				sarray[k]=sorter.pop();
				k++;
				s[j]="POP";
				j++;
			}
			tem.push(s);
		
			int b=0;
			for(int g=1;g<sarray.length;g++) {
				if(sarray[g]>=sarray[g-1]) {
					
				}
				else {
					b++;
				}
			}
			nums=sarray;
			if(b==0) {
				
				break;
			}
			
			
		}
		String[][] arr = new String[ep][2*nums.length];
		int ll=ep-1;
		while(!tem.isEmpty()) {
			arr[ll]=tem.pop();
			ll--;		
		}
		
		/*sorter=new MyStack<Integer>();
		
		for(int ac=0;ac<ep;ac++) {
			
			int[] sarray=new int[dem.length];
			int k=0;
			String[] s=new String[2*dem.length];
			sorter.push(dem[0]);
			s[0]="PUSH";
			int j=1;
			for(int i=1;i<dem.length;i++) {
				if(dem[i]>sorter.top()) {
					sarray[k]=sorter.pop();
					k++;
					s[j]="POP";
					j++;
					while(!(sorter.isEmpty()) && sorter.top()<dem[i]) {
						sarray[k]=sorter.pop();
						k++;
						s[j]="POP";
						j++;
						
					}
					sorter.push(dem[i]);
					s[j]="PUSH";
					j++;
				}
				else {
					sorter.push(dem[i]);
					s[j]="PUSH";
					j++;
				}
			}
			while(!sorter.isEmpty()) {
				sarray[k]=sorter.pop();
				k++;
				s[j]="POP";
				j++;
			}
			arr[ac]=s;
		} */
        //arr = ss.toArray(arr);
		return arr;}
		catch(Exception e) {
			String[][] m= new String[1][1];
			return m;
		}
		
	}
	/*public static void main(String[] args) throws EmptyStackException{
		int[] n= {1023, 158,5029};
		StackSort s= new StackSort();
		String[] t= s.sort(n);
		for(String h: t) {
			System.out.print(h+" ");
		}
		System.out.println();
		String[][] c=s.kSort(n);
		for(String[] d:c) {
			for(String f:d) {
				System.out.print(f+" ");
			}
			System.out.println();
		}
	}*/
}
