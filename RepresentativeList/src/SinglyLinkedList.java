/**
 *	A class that maintains a Linked List data structure.
 * 	Keeps the reference of the first node and last node.
 * 	Can add objects to the beginning of the Linked List or the end.
 *	Uses nodes that holds the reference to the next node in the list.
 *
 *	@author	Varun Ayyappan
 *	@since 04/24/2018
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SinglyLinkedList
{
	private ListNode first;
	private ListNode last;

	public SinglyLinkedList()
	{
		first = null;
		last = null;
	}

	public Object getFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return first.getValue();
		}
	}

	public Object getLast()
	{
		if (last == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return last.getValue();
		}
	}

	public void addFirst(Object value) 
	{
		first = new ListNode(value, first);

		if(last == null)
			last = first;
	}

	public void addLast(Object value)
	{
		ListNode temp = new ListNode(value, null);
		
		if(last != null)
			last.setNext(temp);

		last = temp;
		
		if(first == null)
			first = last;
	}

	private Object get(int target)
	{
		ListNode cur = first;
		int ind = 0;

		while(ind<target)
		{
			if(cur == null)
				throw new NoSuchElementException();

			cur = cur.getNext();
			ind++;
		}
		
		return cur.getValue();
	}

	private Object set(int target, Object object)
	{
		ListNode prev = null, cur = first, insert = new ListNode(object, null);
		Object temp;
		int ind = 0;

		while(ind<target)
		{
			if(cur == null)
				throw new NoSuchElementException();

			prev = cur;
			cur = cur.getNext();
			ind++;
		}
		
		insert.setNext(cur);

		if(prev == null)
			first = insert;
		else
			prev.setNext(insert);

		return cur.getValue();
	}

	public int size()
	{
		int count = 0;
		ListNode temp = first;
		
		while(temp != null)
		{
			temp = temp.getNext();
			count++;
		}

		return count;
	}

	public void printList()
	{
		ListNode temp = first; // start at the first node
		while (temp != null) 
		{
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext(); // go to next node
		}
	}
	
	public void loadData()
	{
		Scanner infile = OpenFile.openToRead("representatives.txt");
		String line = "", district = "", name = "",firstName = "", lastName = "", party = "";
		int birthMonth = 0, birthDay = 0, birthYear = 0, firstElected = 0;
		infile.nextLine();

		while (infile.hasNext())
		{
			line = infile.nextLine();
			district = line.substring(0, line.indexOf(","));
			name = line.substring(20, line.indexOf(",", 20));
			firstName = name.substring(0, name.lastIndexOf(" "));
			lastName = name.substring(name.lastIndexOf(" "));
			birthMonth = Integer.parseInt(line.substring(44, 46));
			birthDay = Integer.parseInt(line.substring(47, 49));
			birthYear = Integer.parseInt(line.substring(50, 54));
			party = line.substring(60, line.indexOf(" ", 60));
			firstElected = Integer.parseInt(line.substring(76));
			addLast(new Representative(district, firstName, lastName, birthMonth, birthDay, birthYear, party, firstElected));
			//System.out.println(getLast());
		}

		infile.close();
	}
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public void selectionSortYear()
	{
		int max; 
		Object temp;

		for(int outer = size(); outer > 1; outer--)
		{
			max = 0;

			for(int inner = 1; inner < outer; inner++)
			{
				if(((Comparable)get(inner)).compareTo(get(max)) < 0)
				{
					max = inner;
				}
			}
			temp = set(outer-1, get(max));
			set(max, temp);
		}
	}

	public void testFind()
	{
		Scanner console = new Scanner(System.in);
		String name = "";
		ListNode cur = null;
		
		while(!name.equalsIgnoreCase("q"))
		{
			System.out.print("Enter a Representative's last name to be searched (Q to quit): ");
			name = console.nextLine();
			System.out.println();

			if(!name.equalsIgnoreCase("q"))
			{
				cur = first;

				while (cur != null) 
				{
					if(((Representative)cur.getValue()).getLastName().equalsIgnoreCase(name))
						System.out.println(cur.getValue());  //------------------------------------------

					cur = cur.getNext();
				}

				System.out.println();
			}
		}
	}

	public void testDelete() {
		Scanner console = new Scanner(System.in);
		String name = "";
		ListNode cur, prev;
		
		while(!name.equalsIgnoreCase("q"))
		{
			System.out.print("Enter a Representative's last name to be searched (Q to quit): ");
			name = console.nextLine();
			System.out.println();

			if(!name.equalsIgnoreCase("q"))
			{
				cur = first;
				prev = null;

				while (cur != null) 
				{
					if(((Representative)cur.getValue()).getLastName().equalsIgnoreCase(name))
					{
						if(prev == null)
							first = cur.getNext();
						else
							prev.setNext(cur.getNext());
					}
					else
						prev = cur;

					cur = cur.getNext();
				}

				System.out.println();
			}
		}
	}

	public void clear()
	{
		first = null;
		last = null;
	}

	public void printBackwards()
	{
		printFromEnd(first);
	}

	private void printFromEnd(ListNode cur) 
	{
		if(cur.getNext() != null)
			printFromEnd(cur.getNext());
		
		System.out.println(cur.getValue());
	}

	public void bubbleSortName()
	{
		Object temp = null;
		for (int outer = 0; outer < size() - 1; outer++)
		{
			for (int inner = 0; inner < size()-outer-1; inner++)
			{
				if(((Comparable)get(inner)).compareTo(get(inner+1)) > 0)     //if (get(inner) > get(inner + 1))
				{
					temp = get(inner);
					set(inner, get(inner+1));
					set(inner+1, temp);
				}	
			}
		}
	}
} 