
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
	
	
	
