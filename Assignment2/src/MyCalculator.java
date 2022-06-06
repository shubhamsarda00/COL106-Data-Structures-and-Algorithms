/*
public class MyCalculator {
	private ArrayList<MyStack<Character>> oper;
	private ArrayList<MyStack<Integer>> num;
	private MyStack<Character> par;
	public MyCalculator() {
		oper=new ArrayList<MyStack<Character>>();
		num= new ArrayList<MyStack<Integer>>();
		par=new MyStack<Character>();
		MyStack<Character> e=new MyStack<Character>();
		oper.add(e);
		MyStack<Integer> f=new MyStack<Integer>();
		num.add(f);
	}
	int calculate(String expression) throws EmptyStackException {
		expression=expression.replaceAll(" ","");
		char[] s=expression.toCharArray();
		int i=0;
		int j=0;
		while(i<s.length) {
			if(s[i]==')') {
				i++;
				par.pop();
				if(num.get(j).isEmpty()) {
					j--;
					continue;
				}
				while(true){
					int t=num.get(j).pop();
					boolean b=num.get(j).isEmpty();
					num.get(j).push(t);
					if(b){
						num.get(j-1).push(num.get(j).pop());
						j--;
						if(!oper.get(j).isEmpty()) {
							char x=oper.get(j).pop();
							if(x!='m' && x!='s') {
								oper.get(j).push(x);
							}
							else if(x=='m'){
								int l=num.get(j).pop();
								int m=num.get(j).pop();
								num.get(j).push(l*m);
							}
							else {
								int l=num.get(j).pop();
								int m=num.get(j).pop();
								num.get(j).push(m-l);
							}
						}
						break;
					}
					else{
						int n=num.get(j).pop();
						int m=num.get(j).pop();
						char c=oper.get(j).pop();
						if(c=='+') {
							num.get(j).push(n+m);
						}
						else {
							num.get(j).push(m-n);
						}
					}
				}
				continue;
			}
			while(true) {
				if(s[i]=='(') {
					par.push(s[i]);
					i++;
					MyStack<Character> e=new MyStack<Character>();
					oper.add(e);
					MyStack<Integer> f=new MyStack<Integer>();
					num.add(f);
					j++;
				}
				else {
					break;
				}
			}
			String k="";
			if(Character.isDigit(s[i])) {
				
				while( i<s.length  && Character.isDigit(s[i])) {
					
					k+=s[i];
					i++;
				}
				num.get(j).push(Integer.parseInt(k));
				continue;
				}
			if(s[i]=='+') {
				oper.get(j).push(s[i]);
				i++;
				continue;
			}
			if(s[i]=='-') {
				if(Character.isDigit(s[i+1])) {
					i++;
					while(i<s.length && Character.isDigit(s[i])) {
						k+=s[i];
						i++;
					}
					int sub=Integer.parseInt(k);
					sub=-1*sub;
					oper.get(j).push('+');
					num.get(j).push(sub);
					
				}
				else if(s[i+1]=='(') {
					oper.get(j).push('s');
				}
				continue;
			}
			if(s[i]=='*') {
				if(i<s.length && Character.isDigit(s[i+1])) {
					i++;
					while(i<s.length && Character.isDigit(s[i])) {
						k+=s[i];
						i++;
					}
					int p=Integer.parseInt(k);
					int o =num.get(j).pop();
					num.get(j).push(o*p);
				}
				else if(s[i+1]=='('){
					oper.get(j).push('m');
				}
				continue;
			}
		}
		int t=num.get(j).pop();
		boolean b=num.get(j).isEmpty();
		if(b) {
			return t;
		}
		else {
			num.get(j).push(t);
			while(true) {
				int v=num.get(j).pop();
				boolean bb=num.get(j).isEmpty();
				num.get(j).push(v);
				if(bb) {
					return v;
				}
				int n=num.get(j).pop();
				int m=num.get(j).pop();
				char c=oper.get(j).pop();
				if(c=='+') {
					num.get(j).push(n+m);
				}
				else {
					num.get(j).push(m-n);
				}
				
			}
		}
		
	}
	public static void main (String[] args) throws EmptyStackException {
		MyCalculator x=new MyCalculator();
		System.out.println(x.calculate("4 * 2 + 2 * (2 + 9)"));
	}
}
*/
public class MyCalculator {
	private MyStack<Character> oper;
	private MyStack<Integer> num;
	private MyStack<Character> par;
	
	public MyCalculator() {
		oper= new MyStack<Character>();
		num=new MyStack<Integer>();
		par=new MyStack<Character>();
	}
	public int calculate(String expression) {
		expression=expression.replaceAll(" ","");
		char[] s=expression.toCharArray();
		int i=0;
		while(i<s.length) {
			if(s[i]==')') {
				i++;
				try{par.pop();}
				catch(Exception e) {}
				/*if((!oper.isEmpty()) && oper.top()=='(') {
					oper.pop();
					continue;
				}*/
				while(true){
					char c1=' ';
					try{c1=oper.top();}
					catch(Exception e) {}
					if(c1=='('){
						try{oper.pop();}
						catch(Exception e) {}
						char c2=' ';
						try{c2=oper.top();}
						catch(Exception e) {}
						if((!oper.isEmpty()) && c2!='(') {
							char x=' ';
							try{x=oper.pop();}
							catch(Exception e) {}
							
						
							if(x!='*' && x!='s') {
								oper.push(x);
								
							}
							else if(x=='*'){
							
								int l=1;
								try{l=num.pop();}
								catch(Exception e) {}
								int m=1;
								try{m=num.pop();}
								catch(Exception e) {}
								num.push(l*m);
							}
							else {
								
								int l=1;
								try{l=num.pop();}
								catch(Exception e) {}
								oper.push('+');
								num.push(-1*l);
							}
						}
						break;
					}
					else{
						int n=1;
						int m=1;
						char c=' ';
						try{n=num.pop();
						 m=num.pop();
						 c=oper.pop();}
						catch(Exception e) {}
						if(c=='+') {
							num.push(n+m);
						}
						
					}
				}
				continue;
			}
			while(true) {
				if(s[i]=='(') {
					par.push(s[i]);
					oper.push(s[i]);
					i++;
				}
				else {
					break;
				}
			}
			String k="";
			if(Character.isDigit(s[i])) {
				
				while( i<s.length  && Character.isDigit(s[i])) {
					
					k+=s[i];
					i++;
				}
				num.push(Integer.parseInt(k));
				continue;
				}
			if(s[i]=='+') {
				oper.push(s[i]);
				i++;
				continue;
			}
			if(s[i]=='-') {
				if(Character.isDigit(s[i+1])) {
					i++;
					while(i<s.length && Character.isDigit(s[i])) {
						k+=s[i];
						i++;
					}
					int sub=Integer.parseInt(k);
					sub=-1*sub;
					oper.push('+');
					num.push(sub);
					
				}
				else if(s[i+1]=='(') {
					oper.push('s');
					i++;
				}
				continue;
			}
			if(s[i]=='*') {
				if(i<s.length && Character.isDigit(s[i+1])) {
					i++;
					while(i<s.length && Character.isDigit(s[i])) {
						k+=s[i];
						i++;
					}
					int p=Integer.parseInt(k);
					int o =1;
					try{o=num.pop();}
					catch(Exception e) {}
					num.push(o*p);
				}
				else if(s[i+1]=='('){
					oper.push('*');
					i++;
				}
				continue;
			}
		}
		
		int t=1;
		try{t=num.pop();}
		catch(Exception e) {}
		
		boolean b=num.isEmpty();
		if(b) {
			return t;
		}
		else {
			num.push(t);
			while(true) {
				int v=1;
				try{v=num.pop();}
				catch(Exception e) {}
				boolean bb=num.isEmpty();
				num.push(v);
				if(bb) {
					return v;
				}
				int n=1;
				int m=1;
				char c=' ';
				try{ n=num.pop();
				 m=num.pop();
				c=oper.pop();}
				catch(Exception e) {}
				if(c=='+') {
					num.push(n+m);
				}
				
		
			}
		}
		
		
		
	
	}/*
	public static void main (String[] args) throws EmptyStackException {
		
		MyCalculator x=new MyCalculator();
		System.out.println(x.calculate("(2-((5)+7)*2)"));
	}*/
}
	
	
	