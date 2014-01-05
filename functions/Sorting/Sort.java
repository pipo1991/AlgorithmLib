

public class Sort {
    
   //Mergesort for sorting array in Ascending Order.
    static public double[] MergeSort(double[] x){
        if(x.length==1)return x;
        int l1=x.length/2;
        int l2=x.length-l1;
        double[] x1=new double[l1];
        double[] x2=new double[l2];
        System.arraycopy(x,0,x1,0,l1);
        System.arraycopy(x,l1,x2,0,l2);
        x1=MergeSort(x1);
        x2=MergeSort(x2);
        return Merge(x1,x2);
    }
    
   //Merge two array in Ascending Order
   static private double[] Merge(double[] x,double y[]){
           int l1=x.length;
           int l2=y.length;
           int l3=l1+l2;
           double[] arr=new double[l3];
           int i3=0,i2=0,i1=0;
           while (i1<l1 && i2<l2){
               if(x[i1]>y[i2]){
                   arr[i3]=y[i2];
                   i2++;
               }
               else{
                   arr[i3]=x[i1];
                   i1++;
               }
               i3++;
            }
           
           while (i1<l1)  {
                 arr[i3]=x[i1];
                 i1++;
                 i3++;
             }

            while (i2<l2)  {
                 arr[i3]=y[i2];
                 i2++;
                 i3++;
             }
               return arr;
   }
   
   //Selectionsort for sorting array in Ascending Order.
   	static public double[] SelectionSort(double []x) {
                int indexmin=0;
		for(int i = 0; i < x.length-1; i++) {
                   for(int j=i+1;j<x.length;j++){
                       if(x[indexmin]>x[j]){
                          indexmin=j;
                       }
                   }
                    double temp=x[i];
                           x[i]=x[indexmin];
                           x[indexmin]=temp;
                   
		}
                return x;
    }
        
    //Bubblesort for sorting array in Ascending Order. 
   	static public double[] BubbleSort(double []x) {
		for(int i = x.length-1; i >0; i--) {
                   for(int j=0;j<i;j++){
                       if(x[j]>x[j+1]){
                        double temp=x[j];
                           x[j]=x[j+1];
                           x[j+1]=temp;
                       }
                   } 
		}
                return x;
    }
        
    //Insertionsort for sorting array in Ascending Order.    
        static public double[] InsertionSort(double[] x){
            for(int i=0;i<x.length;i++){
                double key=x[i];
                int index=i;
                while(index>0 &&x[index-1]>key){
                    x[index]=x[index-1];
                    index--;
                }
                x[index]=key;
            }
            return x;
        }

     //Quicksort for sorting array in Ascending Order. 
     static public double [] QuickSort(double[] x){
            QuickSort(x,0, x.length-1);
            
            return x;
        }
        
     //partition function for partitioning   
     static private int partitioning(double[] x, int p, int r){
      int i = p, j = r;
      double pivot = x[r];
      while (i <= j) {
            while (x[i]<pivot)i++;
            while (x[j]>pivot)j--;
            if (i <= j) {
               double tmp = x[i];
                  x[i] = x[j];
                  x[j] = tmp;
                  i++;
                  j--;
            }
      }
      return i;
}

    //main function for Quicksort
    static private void QuickSort(double[] x, int p, int r) {
     if(p<r){
       int q = partitioning(x, p, r);
            QuickSort(x, p, q-1);
            QuickSort(x, q, r);
        }
    }
    
     //Heapsort for sorting array in Ascending Order. 
     static public double[] HeapSort(double[] x){
            Heapsort(x,x.length-1);
            return x;
        }
     
     static private double[] Heapsort(double[] x,int n){
         //building heap
        for(int i=n/2;i>-1;i--)
            Heapify(x,i,n);
        
        for(int i=n;i>-1;i--){
            double max=x[0];
            x[0]=x[i];
            Heapify(x,0,i-1);
            x[i]=max;
        }
        return x;
    }
     
     //Heapify for heapsort
     static private void Heapify(double[] x,int i,int n){
          double max=x[i];
          while(2*i<n){
                    int j=2*i;
                    if(j<n && x[j]<x[j+1])j++;//++j
                    if(max>=x[j])break;
                    x[i]=x[j];
                    i=j;
                }
                x[i]=max;
     }
     
     //CountingSort for sorting array in Ascending Order.
     static public int[] CountSort(int[] x){
         int max=getmax(x);
         int[] aux=new int[max+1];
         int[] out=new int[x.length];
         
         for(int i=0;i<x.length;i++){
             aux[x[i]]++;
         }
         
         for(int i=1;i<aux.length;i++){
             aux[i]+=aux[i-1];
         }
        
         for(int i=x.length-1;i>-1;i--){
             out[aux[x[i]]-1]=x[i];
             aux[x[i]]--;
         }
         return out;
     }
     
     //get the maximum number's digits number
     static private int getmaxit(int[] x){
         int max=-1,num=0;
         for(int i=0;i<x.length;i++){
             if(x[i]>max)max=x[i];
         }
         for(int i=max;i>0;i/=10){
             num++;
         }
         return num;
     }
     
     //get the maximum number's digits number
     static private int getmax(int[] x){
         int max=-1;
         for(int i=0;i<x.length;i++){
             if(x[i]>max)max=x[i];
         }
         return max;
     }
     
     //BucketSort for sorting array in Ascending Order.
     static public int[] BucketSort(int[] x){
        int [] bucket=new int[getmax(x)+1];

        for (int i=0; i<x.length; i++){
            bucket[x[i]]++;
        }

        int Pos=0;
        for (int i=0; i<bucket.length; i++){
            for (int j=0; j<bucket[i]; j++){
                x[Pos++]=i;
            }
        }
        return x;
    }
}
