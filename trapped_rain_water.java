public class trapped_rain_water {
    public static int trappedRainWater(int height[]){
        //calculate left max boundary 
        int leftMax[]=new int[height.length]; 
        leftMax[0]=height[0]; 
        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        //calculate right max boundary  
        int rightMax[]=new int[height.length];   

        int n=height.length;
         rightMax[n-1]=height[n-1]; 
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        } 
         //waterlevel=min(left max, right max); 
        //trapped water=waterlevel-height 
        int trappedWater=0;
        for(int i=0;i<n;i++){
         int waterLevel=Math.min(leftMax[i],rightMax[i]); 
         trappedWater+=(waterLevel-height[i]);
        }
         
        return trappedWater;
    }


    public static void main(String[] args){
        int height[]={4,2,0,6,3,2,5};  
        System.out.println(trappedRainWater(height));
    }
}
