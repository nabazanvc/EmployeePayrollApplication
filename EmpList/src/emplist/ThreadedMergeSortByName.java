package emplist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Nathan Bazan
 * Code adapted from ThreadedMergeSort tutorial by Joe LaFata at http://blog.quibb.org/
 */
public class ThreadedMergeSortByName implements Strategy, Comparator<Employee>{
     /*Overrides the Strategy.execute method with a method that instantiates a 
     * new ArrayList that duplicates empList and passes it to be sorted by
     * a Threaded merge sort by name, then returns the sorted ArrayList
     */
    @Override
    public ArrayList<Employee> execute(ArrayList<Employee> empList){
        ArrayList<Employee> temp = new ArrayList(empList);
        ThreadedMergeSortByName.sort(temp);
        return temp;
    }
    
    public static void sort (ArrayList<Employee> inputComp){
        sort(inputComp, 0, inputComp.size()-1);
    }
     /*checks if high minus low is less than the size_limit. if so, runs insertion
      * sort and returns. If not creates a new ArrayList that duplicates inputComp
      * and invokes a new sortTask in a ForkJoinPool called pool;
     */
    public static void sort (ArrayList<Employee> inputComp, int low, int high){
        if (high-low< SIZE_LIMIT){
            insertionSort(inputComp, low, high);
            return;
        }
        ArrayList<Employee> temp = new ArrayList(inputComp);
        pool.invoke(new SortTask(inputComp, temp, low, high));
    }
    
    static class SortTask extends RecursiveAction{
        ArrayList<Employee> inputComp;
        ArrayList<Employee> temp;
        int low;
        int high;
        
        public SortTask(ArrayList<Employee> inputComp, ArrayList<Employee> temp, int low, int high){
            this.inputComp=inputComp;
            this.temp=temp;
            this.low=low;
            this.high=high;
        }
        /*Overrides the SortTask.compute() method, which is automatically called
         * when a new SortTask is created. checks if high minus low is less than
         * the size_limit. if so, runs insertion sort and returns.If not, creates
         * new variable mid and invokes a new SortTask on both the first half of
         * inputComp and the second half of it. This happens recursively until 
         * the inputComp is small enough to run insertionSort. Merge sort is 
         * run once this process is completed.
         */
        @Override
        protected void compute(){
            if (high-low<SIZE_LIMIT){
                insertionSort(inputComp, low, high);
                return;
            }
            int middle = (low + high)/2;
            invokeAll(new SortTask(inputComp, temp, low, middle), new SortTask(inputComp, temp, middle+1, high));
            merge(inputComp, temp, low, middle, high);
        }  
    }
        @Override
        public int compare(Employee c1, Employee c2){
        return c1.getName().compareToIgnoreCase(c2.getName());
    }
    
    /*Starts at position destPos in ArrayList src and sets it to the value at
     * srcPos in ArrayList dest
    */
    public static void arrayListCopy(ArrayList<Employee> src, int srcPos, ArrayList<Employee> dest, int destPos, int length){
        for (int i = 0; i< length; i++){
            dest.set(destPos+i, src.get(srcPos+i));
        }
    }
    private static void merge(ArrayList<Employee> inputComp1, ArrayList<Employee> inputComp2, int low, int middle, int high){
        ThreadedMergeSortByName sort = new ThreadedMergeSortByName();
        if(sort.compare(inputComp1.get(middle), inputComp1.get(middle+1)) <= 0){
            return;
        }
        arrayListCopy(inputComp1, low, inputComp2, low, middle-low+1);
        int i = low;
        int j = middle+1;
        int k = low;
        /*while j is greater than k and j is less or equal to high,
         * if compare returns a value less than or equal to 0 then k and i are incremented.
         * inputComp1 at the old value of k is set to inputComp2 at the old value of i.
         * Else k and j are incremented and inputComp1 at the old value of k
         * is set to inputComp1 at the old value of i
        */
        while(k < j && j <=high){
            if(sort.compare(inputComp2.get(i),inputComp1.get(j)) <= 0){
                inputComp1.set(k++, inputComp2.get(i++));
            }
            else{
                inputComp1.set(k++,inputComp1.get(j++));
            }
        }
        arrayListCopy(inputComp2, i, inputComp1, k, j-k);
    }
    
    private static void insertionSort(ArrayList<Employee> inputComp, int low, int high){
        ThreadedMergeSortByName sort = new ThreadedMergeSortByName();
        for(int i = low+1; i<=high; i++){
            int j = i;
            Employee entry = inputComp.get(j);
            /*while low is less than j and compare returns a value less than 0
             * input comp at position j gets input comp at position j-1, j is 
             * decremented then returned.
             */
            while(low<j && sort.compare(entry, inputComp.get(j-1))< 0){
                inputComp.set(j,inputComp.get(j-1));
                --j;
            }
            inputComp.set(j,entry);
        }
    }
    private static final ForkJoinPool pool =  new ForkJoinPool();
    private static final int SIZE_LIMIT = 16;
}
