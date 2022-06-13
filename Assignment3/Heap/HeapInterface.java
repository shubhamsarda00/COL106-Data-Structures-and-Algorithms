package Assignment3.Heap ;
public interface HeapInterface <T, E extends Comparable>{
/**
* Insert the {key,value} pair into the binary max heap.
* The heap needs to be constructed w.r.t. value. 
*
* @param key
* @param value
*/
void insert ( T key , E value ) ;
 /**
 * Remove the element having maximum value from the heap and return it.
 *
 */
E extractMax ( ) ;
 /**
 *
 * Delete an element from heap using the given key
 * @param key
 */
 void delete ( T key ) ;
 /**
 *
 *  Update (increase) the value of a given "key" to the new "value"
 * @param key
 * @param value
 * 
 */
 void increaseKey ( T key, E value ) ;
 /**
 *  Print all the keys stored in the heap according to their level-order
 */
 void printHeap ( ) ;
}
