package Model;


public class BanditModel {


    public int addCoin(int credits) {
        return credits + 1;
    }


    public int removeOneCoin(int credits) {
        return credits - 1;
    }


    public int betOne(int betAmount) {
        return betAmount + 1;
    }

    public int addWinningCoins(int credits, int betAmnt, int symbolAmnt) {
        return (betAmnt * symbolAmnt) + credits + betAmnt;
    }
}
