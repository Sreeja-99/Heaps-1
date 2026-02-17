//way1
//Take a min heap with size k
//Place all the elements from nums to heap
//If heap is >p. pop an element
//FInally heap will be left k big element
//Return top element from it
//TC: O(nlogk)
//SC: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}


//way2
//Take a max heap with size n-k
//Place all the elements from nums to heap
//If heap is >n-k. pop an element and identify min elements amonng the popped elements
//Return calculated min element
//TC: O(nlog(n-k))
//SC: O(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int rem=nums.length-k;
        int min=Integer.MAX_VALUE;
        for(int n:nums){
            pq.add(n);
            if(pq.size()>rem){
                min=Math.min(pq.poll(),min);
            }
        }

        return min;
    }
}
