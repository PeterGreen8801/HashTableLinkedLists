public class HashTableLinkLists
{
   static class Node
   {  
      int value;
      Node next;
      public Node(int val)
      {
         value = val;
         next = null;
      }
   }
    
   private static Node[] table;
   private int tableSize = 10;
   public HashTableLinkLists()
   {
      table = new Node[tableSize];   
   }
    
   public static void insert(int val)
   {
      int position = hashFunction(val);
      Node temp = new Node(val);
       
      if(table[position] == null)
      {
         table[position] = temp;
      }
      else
      {
         temp.next = table[position];
         table[position] = temp;
      }
   }
   
    
   public static void delete(int val)
   {
      int position = hashFunction(val);
      if(table[position] != null)
      {
         Node temp = null;
         Node head = table[position];
         while(head.next != null && head.value != val)
         {
            temp = head;
            head = head.next;
         }
         if(head.value == val)
         {
            if(temp == null)
            {
               table[position] = head.next;
            }
            else
            {
               temp.next = head.next;
            }
         }
      }
      else
      {
         System.out.println("Could not find value "+(val) +" for delete!");
      }
      
   }
    
   public static void dumphash()
   {
      for(int i = 0; i < table.length; i++)
      {
         System.out.print((i+10-(i*2))+": ");
         Node head = table[i];
         while(head != null)
         {
            System.out.print(head.value + "->");
            head = head.next;
         }
         System.out.println("\n");
      }
      System.out.println("\n");
   }
   public static int hashFunction(int val)
   {
      return (val % 10);
   }
   
   public static void main(String[] args)
   {
      HashTableLinkLists list = new HashTableLinkLists();
      list.insert(1);
      list.insert(5);
      list.insert(28);
      list.delete(5);
      list.insert(15);
      list.insert(8);
      list.dumphash();
      list.delete(1);
      list.insert(18);
      list.insert(25);
      list.delete(33);
      list.dumphash();
   }
}
