package col106.assignment4.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import col106.assignment4.HashMap.HashMap;
import col106.assignment4.WeakAVLMap.WeakAVLMap;
public class Map<V> {
	private long wi=0;
	private long wd=0;
	private long hi=0;
	private long hd=0;
	/*public static void main (String[] args) {
		Map<Integer> m= new Map<Integer>();
		m.eval("C:\\Users\\hp\\Desktop\\Shubham\\IITD\\Sem4\\COL106\\Assignment4\\Checker\\col106\\assignment4\\Map\\map_input", "map_output");
	}*/
	public Map() {
		// write your code here	
		
		
		
	}

	public void eval(String inputFileName, String outputFileName) {
		// write your code here
		hi=0;
		hd=0;
		wi=0;
		wd=0;
		long current=0;
		long end=0;
		int t=0;
		File ii = null;
		File oo;
		try {
			 ii=new File(inputFileName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 oo= new File(outputFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br=null;
		try {
			br =new BufferedReader(new FileReader(ii));
		}
		catch (Exception e){
			
		}
		try {
			t=Integer.parseInt(br.readLine().trim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WeakAVLMap<String, String> wm = new WeakAVLMap<String, String>();
		HashMap<String> hm= new HashMap<String>(t);
		try {
		for (int i=0;i<t;i++) {
			String s[]=br.readLine().split(" ");
			if(s[0].equals("I")) {
				String key=s[1].substring(0, s[1].length());
				String value=  s[2];
				current =System.currentTimeMillis();
				hm.put(key, value);
				end=System.currentTimeMillis();
				hi+=end-current;
				current =System.currentTimeMillis();
				wm.put(key, value);
				end=System.currentTimeMillis();
				wi+=end-current;
			}
			else {
				String key=s[1];
				current =System.currentTimeMillis();
				hm.remove(key);
				end=System.currentTimeMillis();
				hd+=end-current;
				current =System.currentTimeMillis();
				wm.remove(key);
				end=System.currentTimeMillis();
				wd+=end-current;
				
			}
		}
		}
		catch (Exception e) {
		}
		try {
			PrintStream pp=new PrintStream(outputFileName);
			pp.println("Operations WAVL HashMap");
			pp.println("Insertions "+(int)wi+" " +(int)hi); 
			pp.println("Deletions "+(int)wd+" "+ (int)hd);
			
			pp.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
