package Assignment5.src;

import java.util.Comparator;

/*
Implementation of MergeSort Algorithm :
    1. you get linked list of size <=1 you just return the list as it is already sorted
    2. Find mid node using findSplit method(Don't forget to add mid element to globalList before returning it)
    3. Create two LinkedList lt (with head = head and tail = mid) and rt (with head = mid.next and tail = tail)
    4. Now recursively MergSort lt and rt Linked lists(Maintain this order)
    5. Now merge these two lists that we got from recursive calls using given crieteria for ordering
    6. Return merged Linked list
*/

public class LLMergeSort <T extends Comparable>  {

  LinkedList<T>  globalList = new LinkedList<T>();

  //CALL THIS METHOD AFTER EVERY CALL OF findSplit and DO NOT MODIFY THIS METHOD
  public void adjustGlobalPointer(T node){
      globalList.add(node);
  }

  // Utility function to get the middle of the linked list
  public Node<T> findSplit(LinkedList<T>  lst) {
    //find middle node of LL :
	  int n=lst.getSize();
	  int m =midsize(n);
	  Node<T> h= lst.getHead();
	  for(int i=0;i<m-1;i++) {
		  h=h.getNext();
	  }
      Node<T> middle = h;
    //Enter your code here

    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }


  public LinkedList<T>  MergeSort(LinkedList<T>  lst) {
	  
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
	  if(lst.getSize()<=1) {
		  return lst;
	  }
	  Node<T> middle=findSplit(lst);
	  
	  Node<T> nex=middle.getNext();
	  middle.next=null;
	  int s=lst.getSize();
	  int m=midsize(s);
	  lst.setSize(m);
	  LinkedList<T> left=MergeSort(lst);
	  LinkedList<T> temp = new LinkedList<T>();
	  temp.setHead(nex);
	  temp.setSize(s-m);
	  LinkedList<T> right=MergeSort(temp);
	  LinkedList<T> sorted = merge(left,right);
	  return sorted;
	  
  }
  private LinkedList<T> merge(LinkedList<T> l1, LinkedList<T> l2){
	  LinkedList<T> sorted = new LinkedList<T>();
	  Node<T> h1=l1.getHead();
	  Node<T> h2=l2.getHead();
	  while(h1!=null && h2!=null) {
		  if(h1.getData().compareTo(h2.getData())>0) {
			  
			  sorted.add(h2.getData());
			  h2=h2.getNext();
		  }
		  else {
			  sorted.add(h1.getData());
			  h1=h1.getNext();
		  }
		  
	  }
	  if(h1==null) {
		  while(h2!=null) {
			  sorted.add(h2.getData());
			  h2=h2.getNext();
		  }
		  
	  }
	  else {
		  while(h1!=null) {
			  sorted.add(h1.getData());
			  h1=h1.getNext();
		  }
	  }	  
	  return sorted;
	  
  }
  public int midsize(int n) {
	  
	  if(n%2==0) {
		  return n/2; 
	  }
	  else {
		  return (n-1)/2+1;
	  }
	  
  }

  //DO NOT CALL OR MODIFY THESE METHODS IN YOUR CALL THIS IS FOR USE IN DRIVER CODE
  public LinkedList<T> getGlobalList() {
    return this.globalList;
  }

  public void clearGlobalList(){
    globalList  = new LinkedList<>();
  }

}
