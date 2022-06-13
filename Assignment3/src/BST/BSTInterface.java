package Assignment3.src.BST ;
public interface BSTInterface <T, E extends Comparable>{
/**
* Note that here conventional roles of key and value have been exchanged 
* Insert an element using the "value" as the comparator and the
  corresponding value .
* Please note that key is a generic type and it can be
anything .
*
* @param key
* @param value
*/
void insert ( T key , E value ) ;
 /**
 * Update to new value using the key.
 *
 * @param key
 * @param value
 */
 void update(T key, E value);
 /**
 *
 * Delete element using key
 * @param key
 */
 void delete ( T key ) ;
 /**
 *
 * Print the keys according to level order traversal of the BST
 * 
 */
 void printBST () ;
}
