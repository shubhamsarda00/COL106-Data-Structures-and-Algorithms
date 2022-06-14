package Assignment5.src;

public class DateNode implements DateInterface,Comparable<DateNode> {

	int day;
	int month;
	int year;

	public DateNode(int day, int month , int year){
		this.day = day;
		this.month= month;
		this.year = year;
	}

	public int getDay(){
		return this.day;
	}

	public int getMonth(){
		return this.month;
	}

	public int getYear(){
		return this.year;
	}

	@Override
	public int compareTo(DateNode o) {
		// TODO Auto-generated method stub
		if(this.year>o.getYear()) {
			return 1;
		}
		else if(this.year<o.getYear()){
			return -1;
		}
		else {
			if(this.month>o.getMonth()) {
				return 1;
			}
			else if(this.month<o.getMonth()){
				return -1;
			}
			else {
				if(this.day>o.getDay()) {
					return 1;
				}
				else if(this.day<o.getDay()){
					return -1;
				}
				else {
					return 0;
				}
				
			}
		}
			
	}

}
