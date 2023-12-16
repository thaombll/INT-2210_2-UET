import java.util.Arrays;
// import binaryTS;
public class threeSum {
    public static void main(String args[])
    {
        // binaryTS ob = new binaryTS();
        int a[] = { -5, 1, 2, 3, 4, 40 };
        int n = a.length;
        Arrays.sort(a);
        int ans = 0;

        for(int i = 0; i < n-2; i++){
            // ensure no repetition
            if(i > 0 && a[i] == a[i-1])
                continue;
            // binary search on remaining elements
            int x = a[i], y = i+1, z = n-1;
            
            while(y < z){
                if(a[y] + a[z] + x == 0){
                    // save valid ans
                    ans++;
                    // inc b and dec c till no repetition.
                    int t = a[y];
                    while(y < n && a[y] == t)
                        y++; 

                    t = a[z];
                    while(z >=0 && a[z] == t)
                        z--;
                }
                else if(a[y]+a[z] +x < 0 ){
                    y++; // sum less than target // duplicate is handled as not valid ans.
                }
                else
                    z--;
            }
        }
        System.out.println("So cap thoa man la: " + ans);
    }
}
// phan loai thuat toan : const, linear, logN, NlogN, N^2 ,...
// danh gia thuat toan : phan tich do phuc tap cua thuat toan