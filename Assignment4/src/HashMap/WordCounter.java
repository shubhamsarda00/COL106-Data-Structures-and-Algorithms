package col106.assignment4.HashMap;

public class WordCounter {
	
	/*public static void main (String[] args) {
		WordCounter w=new WordCounter();	
		System.out.println(w.count("abcabcabcabxabcabcabcab", "abcab"));
		
	
	}*/
	
	private HashMap<Integer> counter;
	private int c;
	public WordCounter(){
		// write your code here
		counter=new HashMap<Integer>(101);
		c=0;
	}

	public int count(String str, String word){
		// write your code here
		c=0;
		counter.put(word, 0);
		StringBuilder s=new StringBuilder(str);
		int l=word.length();
		int k=str.length();
		for(int i=0;i<=k-l;i++) {
			int h=counter.search(s.substring(0, l));
			if(h!=-1) {
				c++;
				counter.upd(h,c);
			}
			s.delete(0, 1);
		}
		
		return counter.get(word);
	}
}
