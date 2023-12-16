import java.util.Arrays;
public class binaryTS{
    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            if (arr[m] == x)
                return m;
 
            if (arr[m] < x)
                l = m + 1;
 
            else
                r = m - 1;
        }
 
        return -1;
    }
 
    // Driver code
    public static void main(String args[])
    {
        binaryTS ob = new binaryTS();
        int a[] = { -5, -1, 1, 2, 3, 4, 40 };
        int n = a.length;
        Arrays.sort(a);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x = 0 - a[i];
            int result = ob.binarySearch(a, x);
            if (result != -1 && result != i && (a[result] + a[i] == 0)) {
                ans++;
            }
        }
        System.out.println("So cap thoa man la: " + ans/2);
    }
}