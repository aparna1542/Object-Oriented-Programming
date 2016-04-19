package Algo.DS;
public class ActivitySelGreedy {

    public void maxActivities(int s[], int f[], int n) {
        int k= 0; // initializing the first activity
        System.out.print("The maximum activity perfomed is \n");
        System.out.println("(" + s[0] + "," + f[0] + ")");
        for (int m = 1; m<s.length; m++) {
            if (s[m] >= f[k]) {
                System.out.println("(" + s[m] + "," + f[m] + ")");
                k = m;
            }
        }

    }

    public static void main(String args[]) {
        ActivitySelGreedy e = new ActivitySelGreedy();
        int s[] ={1,3,0,5,3,5,6,8,8,2,12};
        int f[] ={4,5,6,7,9,9,10,11,12,14,16};
        int n = s.length;
        e.maxActivities(s, f, n);
    }
}