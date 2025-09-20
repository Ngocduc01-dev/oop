import java.util.Random;

public class RollLoadedDie {
    public static void main(String[] args) {
        Random rd = new Random();
        int rdm = rd.nextInt(1,8);
        int kq;
        if(rdm == 1) {
            kq = 1;
        } else if (rdm == 2){
            kq = 2;
        } else if (rdm == 3){
            kq = 3;
        } else if (rdm == 4){
            kq = 4;
        } else if (rdm == 5){
            kq = 5;
        } else {
            kq = 6;
        }
        System.out.println(kq);
    }
}
