class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<int[]> q = new PriorityQueue<>((b1,b2) -> Integer.compare(b2[1], b1[1]));
        for(int[] arr: boxTypes)
            q.add(arr);
        int maxBoxes = 0;
        while(truckSize>0 && !q.isEmpty()){
            int[] arr = q.poll();
            if(truckSize>=arr[0]){
                truckSize-=arr[0];
                maxBoxes+=(arr[0]*arr[1]);
            }else{
                maxBoxes+=(truckSize*arr[1]);
                truckSize=0;
            }
        }
        return maxBoxes;
    }
}
