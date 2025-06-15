package Heaps;

import java.util.*;

class Q3_Operations_on_Binary_Min_Heap {

    ArrayList<Integer> arr;
    int capacity;
    int heap_size;

    Q3_Operations_on_Binary_Min_Heap(int cap) {
        heap_size = 0;
        capacity = cap;
        arr = new ArrayList<>();
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    // Function to extract minimum value in heap and then to store
    // next minimum value at first index.

    private void swap(int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    int extractMin() {

        if(heap_size == 0) return -1;

        int min = arr.get(0);

        int lastIndex = heap_size - 1;
        swap(0, lastIndex);

        arr.remove(lastIndex);
        heap_size--;

        MinHeapify(0);

        return min;
    }

    // Function to insert a value in Heap.
    void insertKey(int k) {

        if(heap_size >= capacity) {
            return;
        }

        arr.add(k);
        heap_size++;

        int kIndex = heap_size - 1;

        while(arr.get(kIndex) < arr.get(parent(kIndex))) {

            swap(kIndex, parent(kIndex));

            kIndex = parent(kIndex);
        }
    }

    // Function to delete a key at ith index.
    void deleteKey(int i) {

        if(i >= heap_size) return;

        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {
        arr.set(i, new_val);

        while (i != 0 && arr.get(parent(i)) > arr.get(i)) {

            swap(i, parent(i));

            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < heap_size && arr.get(l) < arr.get(i)) smallest = l;
        if (r < heap_size && arr.get(r) < arr.get(smallest)) smallest = r;

        if (smallest != i) {

            swap(i, smallest);

            MinHeapify(smallest);
        }
    }
}