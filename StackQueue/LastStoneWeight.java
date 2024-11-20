class HeapArray
{
    private static final int CAPACITY = 10;

    // Heap Array
    private int[] heap;
    private int size;

    // Build Heap with insert Element By Element
    public HeapArray()
    {
        heap = new int[CAPACITY];
        size = 0;
    }

    // Build Heap with Heapify
    public HeapArray(int[] arr)
    {
        // copy array to heap
        heap = Arrays.copyOf(arr, arr.length);
        size = arr.length;

        // call heapify
        buildHeap();
    }

    public void buildHeap()
    {
        // N - nodes    N /2 - leaf nodes
        for(int i = (size / 2) - 1; i >= 0; i--)
        {
            // leaf node itself satisfies Heap property
            heapifyDown(i);
        }
    }

    // Insert - Bottom Up Heap
    public void offer(int val)
    {
        // size exceeds Heap length
        if(size == heap.length)
        {
            // resize - Double heap size
            heap = Arrays.copyOf(heap, size * 2);
        }
        // add element to end
        heap[size] = val;
        size++;

        heapifyUp(size - 1);
    }

    // Delete - Top Down Heap
    public int poll()
    {
        // Empty heap - Exception
        if(isEmpty())
        {
            return Integer.MAX_VALUE;
        }

        // remove root
        int max = heap[0];

        // replace root with Last level - Right most node
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        // max from Heap
        return max;
    }

    // Top Down - Heap Property
    public void heapifyDown(int i)
    {
        // until Leaf
        while(i < size)
        {
            // consider cur as Largest
            int largest = i;

            // calculate Left and Right
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // check left is Largest
            if(left < size && heap[left] > heap[largest])
            {
                largest = left;
            }
            // check right is Largest
            if(right < size && heap[right] > heap[largest])
            {
                largest = right;
            }

            // check for largest remains cur
            if(largest != i)
            {
                // swap(parent, largest)
                swap(i, largest);

                // check for child satisfies Heap property
                i = largest;
            }
            // Already satisfies Heap property
            else
            {
                break;
            }
        }
    }

    // Bottom Up - Heap Property
    public void heapifyUp(int i) /* Index */
    {
        // until Root
        while(i > 0)
        {
            // calculate Parent
            int parent = (i - 1) / 2;

            // Max-Heap : parent > child
            if(heap[parent] < heap[i])
            {
                // if not Swap(parent, child)
                swap(parent, i);

                // check for parent satisfies Heap property
                i = parent;
            }
            else
            {
                // Already satisfies Heap property
                break;
            }
        }
    }

    // root Contains Peek Element
    public int peek()
    {
        if(isEmpty())
            return Integer.MAX_VALUE;

        // heap[0] = Root
        return heap[0];
    }

    // size remains 0
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return size of Heap
    public int size()
    {
        return size;
    }

    // Swap (Parent, Child)
    private void swap(int i, int j) 
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

class Solution {
    // Max Heap - Priority Queue
    HeapArray maxHeap;

    public int lastStoneWeight(int[] stones) 
    {
        // Create Max-Heap
        maxHeap = new HeapArray(stones);

        // until Last Stone
        while(maxHeap.size() > 1)
        {
            // first MaxStone
            int max1 = maxHeap.poll();
            // second MaxStone
            int max2 = maxHeap.poll();

            // smash two Stones
            if(max1 != max2)
            {
                // Max1 - Max2
                maxHeap.offer(max1 - max2);
            }
        }

        // heap Empty ? 0 : last Stone
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}