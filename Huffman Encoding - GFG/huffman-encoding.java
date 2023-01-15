//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class HuffmanTree implements Comparable<HuffmanTree>
{
    char ch;
    int freq;
    HuffmanTree left;
    HuffmanTree right;
    
    public HuffmanTree(char ch, int freq)
    {
        this.ch=ch;
        this.freq=freq;
        this.left=null;
        this.right=null;
    }
    
    public int compareTo(HuffmanTree other)
    {
        if(this.freq == other.freq)
        {
            return 1;
        }
        else
        {
            return this.freq-other.freq;
        }
    }
}
class Solution {
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        ArrayList<String>  ans = new ArrayList<>();
        
        PriorityQueue<HuffmanTree> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++)
        {
            pq.add(new HuffmanTree(S.charAt(i),f[i]));
        }
        
        while(pq.size()>1)
        {
            HuffmanTree first = pq.remove();
            HuffmanTree second = pq.remove();
            
            HuffmanTree newNode = new HuffmanTree('-',first.freq+second.freq);
            newNode.left=first;
            newNode.right=second; 
            pq.add(newNode); 
            
        }
         
        // StringBuilder sb = new StringBuilder();
        String temp = "";
        preOrder(pq.peek(),ans,temp);
        return ans;
    }
    
        public void preOrder(HuffmanTree root, ArrayList<String> ans, String temp){
        if(root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        preOrder(root.left,ans,temp+"0"); 
        preOrder(root.right,ans,temp+"1"); 
    }
}