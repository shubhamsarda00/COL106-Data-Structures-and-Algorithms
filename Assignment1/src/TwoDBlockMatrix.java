import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.Vector;
import java.text.DecimalFormat;
public class TwoDBlockMatrix {
	public float[][] array;
	public String s;
	public static TwoDBlockMatrix buildTwoDBlockMatrix(java.io.InputStream in) throws java.io.IOException, java.lang.NumberFormatException{
		int r=0;
		int c=0;
		Vector<Character> v=new Vector<Character>();
		while(in.available()>0) {
		char a= (char) in.read();
		v.add(a);
		}
		int i=0;
		while(i<v.size()) {
			char s= v.get(i);
			i++;
			int r2,c2;
			String s1="";
			String s2="";
			while(s!=' ') {
				s1+= s;
				s= v.get(i);
				i++;
			}
			s= v.get(i);
			i++;
			while(s!='\n') {
				s2+= s;
				s= v.get(i);
				i++;
			}
			
			r2= Integer.parseInt(s1);
			c2= Integer.parseInt(s2);
			
			int c11=c2;
			while(s!=';') {
				if(s==' ') {
					c2+=1;
					
				}
				s= v.get(i);
				i++;
			}
			if(c>c2) {
			}
			else {
				c=c2;
			}
			c2=c11;
			s= v.get(i);
			i++;
			while(s!='#') {		
				while(s!='\n') {
					if(s==';') {
						r2+=1;
						c2=c11;
						
					}
					if(s==' ') {
						c2+=1;
						if(c>c2) {
						}
						else {
							c=c2;
						}
					}
					
					s= v.get(i);
					i++;
				}
				s= v.get(i);
				i++;
				}
			
			try {
				v.get(i);
				i++;
			}
			catch(Exception e){
				
			}
				
				
					
			
			if(r>r2) {	
			}
			else {
				r=r2;
			}
			if(c>c2) {
			}
			else {
				c=c2;
			}
			
		}
			i=0;
			
		float[][] f=new float[r][c];
		while(i<v.size()) {
			char a= v.get(i);
			i++;
			int r2,c2;
			int c1;
			String s1="";
			String s2="";
			while(a!=' ') {
				s1+= a;
				a= v.get(i);
				i++;
			}
			a= v.get(i);
			i++;
			while(a!='\n') {
				s2+= a;
				a= v.get(i);
				i++;
			}
			r2= Integer.parseInt(s1);
			c2= Integer.parseInt(s2);
			c1=c2;
			a= v.get(i);
			i++;
			while(true) {		
				while(true){
					String t="";
					while(true) {
						
						t+=a;
						if(a!=' ') {
						a= v.get(i);
						i++;
						}
						if (a==' '||a==';') {
							a=v.get(i);
							i++;
							break;
						}
						
						
						
						}
					
					/*boolean isInteger;
					    try {
					        Integer.parseInt( t );
					        isInteger=true;
					    }
					    catch( Exception e ) {
					        isInteger=false;
					    }
					    
					    
					if(isInteger) {
						int b= Integer.parseInt(t);
						float l= b;
						
						f[r2-1][c2-1]=l;
					}
					else {
						
						int j=t.indexOf('.');
						boolean asd=true;
						try {
							char gv=t.charAt(j+3);
						}
						catch(Exception fr) {
							asd=false;
						}
						if(asd) {
						j+=2;
						boolean even =Integer.parseInt(t.substring(j, j+1))%2==0;
						if(0<=Integer.parseInt(t.substring(j+1, j+2))&&Integer.parseInt(t.substring(j+1, j+2))<5){
							t=t.substring(0, j+1);
							float b=Float.parseFloat(t);
							
							
							f[r2-1][c2-1]= b;
						}
						else if(Integer.parseInt(t.substring(j+1, j+2))==5){
							if(even) {
								t=t.substring(0, j+1);
								float b=Float.parseFloat(t);
								
								f[r2-1][c2-1]= b;
							}
							else {
								t=t.substring(0, j+1);
								float b=Float.parseFloat(t);
								b+=0.01;
								f[r2-1][c2-1]= b;
							}
							
						}
						else {
							t=t.substring(0, j+1);
							float b=Float.parseFloat(t);
							b+=0.01;
							f[r2-1][c2-1]= b;
						}}
						else {*/
						float b=Float.parseFloat(t);
						f[r2-1][c2-1]= b;
							
						//}
					//}
					
					c2+=1;
					
					if (a=='\n') {
						c2=c1;
						a=v.get(i);
						i++;
						break;
					}
					}
				
				
				r2+=1;
				
				
				if (a=='#') {
					
					try{
					a=v.get(i);
					i++;
					break;
					}
					catch(Exception en) {
						break;
					}
					}
				}
			}
		
		
		for(int z=0;z<r;z++) {
			for(int x=0;x<c;x++) {System.out.print(f[z][x]);
			}
			System.out.println(" ");
			}
		TwoDBlockMatrix matrix= new TwoDBlockMatrix(f);
		String s="";
		int b=0;
		while(b<v.size()) {
			s+=v.get(b);
			b++;
		}
		matrix.s=s;
		return matrix;
	}
	public TwoDBlockMatrix ( float[][] array ) {
		this.array=array;
	}
	public String toString() {
		DecimalFormat format2dec = new DecimalFormat("0.00");
		//format2dec.format(f[t][y])
		String s="";
		float[][] f=new float[this.array.length][this.array[0].length];
		for(int z=0;z<this.array.length;z++) {
			for(int x=0;x<this.array[0].length;x++) {f[z][x]=this.array[z][x];
			}
			
			}
		int r=0;
		int c=0;
		r=f.length;
		c=f[0].length;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if (f[i][j]==0){
					
				}
				else {
					int marker=0;
					int rowmarker=0;
					int cmax=Integer.MAX_VALUE;
					s=s+String.valueOf(i+1)+" "+String.valueOf(j+1)+String.valueOf('\n');
					int t=i;
					int y=j;
					while(true) {
						
						while(true) {
							
							/*try {int g=(int) f[t][y];
							s=s+String.valueOf(g);
								
							}
							catch(Exception e ){*/
								s=s+String.valueOf(format2dec.format(f[t][y]));
								
							
							//}
							f[t][y]=0;
							if (y+1<c && y+1<=cmax ) {
								if(f[t][y+1]!=0.0) {
									s+=" ";
									y++;
									
								}
								else {
									rowmarker++;
									marker++;
									if (marker==1) {
									cmax=y;
									
									}
									
									s+=String.valueOf(';')+String.valueOf('\n');
									break;
								}
							}
							else {
								rowmarker++;
								marker++;
								if (marker==1) {
								cmax=y;
								
								}
								
								s+=String.valueOf(';')+String.valueOf('\n');
								break;
							}
						}
						y=j;
						if (t+1<r) {
							if(f[t+1][y]!=0.0) {
								t+=1;
							}
							else {
								break;
							}
						}
						else {
							break;
						}
						if(rowmarker>0) {
							
							int fd=0;
							for(int m=y;m<=cmax;m++) {
								if(f[t][m]==0.0f) {
									fd++;
								}
								
							}
							if(fd>0) {
								break;
							}
						}
						
					}
					s+=String.valueOf('#')+ String.valueOf('\n');
					
					
					
					
					
				}
			}
		}
		s=s.substring(0, s.length()-1);// removing the last '\n'
		return s;

	}
	public TwoDBlockMatrix transpose() {
		float[][] f=this.array;
		int r=0;
		int c=0;
		r=f.length;
		c=f[0].length;
		float[][] t=new float[c][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				t[j][i]=f[i][j];
			}
		}
		TwoDBlockMatrix trans=new TwoDBlockMatrix(t);
		return trans;
		
	}
	public TwoDBlockMatrix multiply ( TwoDBlockMatrix other) throws IncompatibleDimensionException {
		float[][] f=this.array;
		int r=0;
		int c=0;
		r=f.length;
		c=f[0].length;
		float[][] m=other.array;
		if(c!=m.length) {
			throw new IncompatibleDimensionException("Dimesions of two matrices are incompatible for multiplication");
		}
		else {
			float[][] mult=new float[f.length][m[0].length];
			for (int i=0;i<mult.length;i++) {
				for(int j=0;j<mult[0].length;j++) {
					
					for(int d=0;d<m.length;d++) {
						mult[i][j]+=f[i][d]*m[d][j];
					}
				}
			}
			
			TwoDBlockMatrix mul= new TwoDBlockMatrix(mult);
			return mul;		
		}
		
	}
	public TwoDBlockMatrix getSubBlock ( int row_start, int col_start, int row_end, int col_end) throws SubBlockNotFoundException{
		float[][] f=this.array;
		if(row_start>=1 && row_start<=f.length && row_end>row_start && row_end<=f.length+1 && col_start>=1 && col_start<=f[0].length && col_end>col_start && col_end<=f[0].length+1) {
			float[][] sub=new float[row_end-row_start][col_end-col_start];
			int r=row_end-row_start;
			int c=col_end-col_start;
			int rmarker=row_start-1;
			int cmarker=col_start-1;
			for(int i=0;i<r;i++) {
				cmarker=col_start-1;
				for(int j=0; j<c ; j++) {
					sub[i][j]=f[rmarker][cmarker];
					cmarker++;
				}
				rmarker++;
			}
			TwoDBlockMatrix subblock= new TwoDBlockMatrix(sub);
			return subblock;
		}
		else {
			throw new SubBlockNotFoundException("SubBlock doesn't exist for given row and column indices ");
		}
	}
	public TwoDBlockMatrix inverse () throws InverseDoesNotExistException{
		float[][] f=this.array;
		float det=0;
		if(f.length!=f[0].length) {
			throw new InverseDoesNotExistException("Inverse doesn't exist for non square matrices");
		}
		class Determinant {
			 public Float val(float[][] f, int n) {
				if(n==0) {
					return 0.0f;
				}
				if(n==1) {
					return f[0][0];
				}
				if(n==2) {
					return (f[0][0]*f[1][1]-f[1][0]*f[0][1]);
				}
				else {
					float v= 0.0f;
					int j=0;
					for(int i=0;i<f.length;i++) {
						float[][] d=new float[n-1][n-1];
						int r=0;
						for(int z=0;z<n-1;z++) {
							if(r==i) {
								r++;}
							for(int x=0;x<n-1;x++) {
								int c=x+1;
								d[z][x]=f[r][c];
								
								}
								r++;
							}
						
						if(i%2==0) {
							v+=f[i][j]*val(d,n-1);
						}
						else {
							v-=f[i][j]*val(d,n-1);
						}
					}
					return v;
				}
			}
			 
			
		}
		Determinant dd= new Determinant();
		det=dd.val(f, f.length);
		if(det==0) {
			throw new InverseDoesNotExistException("Inverse doesn't exist as value of determinant is 0");
		}
		float[][] adj=new float[f.length][f.length];
		for(int w=0;w<f.length;w++) {
			for(int e=0;e<f.length;e++) {
				float v=0.0f;
				float[][] d=new float[f.length-1][f.length-1];
				int r=0;
				int c=0;
				for(int z=0;z<f.length-1;z++) {
					if(r==w) {
						r++;}
					for(int x=0;x<f.length-1;x++) {
						if(c==e) {
							c++;
						}
						d[z][x]=f[r][c];
						c++;
						}
					c=0;
						r++;
					}
				
				if((w+e)%2==0) {
					v=dd.val(d,f.length-1);
				}
				else {
					v=(-1)*dd.val(d,f.length-1);
				}
				adj[w][e]=v;
			}
		}
		float[][] t=new float[f.length][f.length];
		for(int i=0;i<f.length;i++) {
			for(int j=0;j<f.length;j++) {
				t[j][i]=adj[i][j];
			}
		}
		for(int ii=0;ii<f.length;ii++) {
			for(int jj=0;jj<f.length;jj++) {
				t[ii][jj]=t[ii][jj]/det;
			}
		}
		TwoDBlockMatrix inverse =new TwoDBlockMatrix(t);
		return inverse;
	}
	/*public static void main(String[] args) throws java.io.FileNotFoundException,java.io.IOException,InverseDoesNotExistException,SubBlockNotFoundException,IncompatibleDimensionException{
		java.io.InputStream km = new java.io.FileInputStream("as.txt");
		SparseTwoDBlockMatrix p=SparseTwoDBlockMatrix.BuildTwoDBlockMatrix(km);
		System.out.println(p.toString());
		SparseTwoDBlockMatrix sub=p.getSubBlock(2, 2, 3, 3);
		for(int z=0;z<sub.array[0].length;z++) {
			for(int x=0;x<sub.array.length;x++) {System.out.print(sub.array[z][x]);
			}
			System.out.println(" ");
			}
		SparseTwoDBlockMatrix t=p.inverse();
		
		for(int z=0;z<p.array[0].length;z++) {
			for(int x=0;x<p.array.length;x++) {System.out.print(t.array[z][x]);
			}
			System.out.println(" ");
			}
		SparseTwoDBlockMatrix identity=p.multiply(t);
		for(int z=0;z<identity.array[0].length;z++) {
			for(int x=0;x<identity.array.length;x++) {System.out.print(identity.array[z][x]);
			}
			System.out.println(" ");
			}
		km.close();
	}*/
}
