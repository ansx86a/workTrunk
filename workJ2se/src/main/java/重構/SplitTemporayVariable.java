package 重構;

public class SplitTemporayVariable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * <pre>
    牛頓第二定律->靜止 施力 速度->再施力 加速度
    速度=第一次施力/mass[質量？]; 第一次運動時間 = Math.min(time, delay_time);//寫死time比delay_time大
    結果=0.5 * 速度 * 第一次運動時間^2; 第二次運動時間 = time - delay_time
    第一次的延續作用力 = 速度 * delay_time; 速度 = (第一次施力 + 第二次施力)/mass
    return 結果 + 第一次的延續作用力 *  第二次運動時間 + 0.5 * 速度[被重定義的] * 第二次運動時間^2
     * </pre>
     */
    private double 重構前(int time) {
        double result;
        int acc = primaryForce / mass;
        int primaryTime = Math.min(time, delayTime);
        result = 0.5 * acc * primaryTime;
        int secondaryTime = time - delayTime;
        if (secondaryTime > 0) {
            double primaryVal = acc * delayTime;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVal * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }

    private int primaryForce = 1;
    private int secondaryForce = 1;
    private int mass = 1;
    private int delayTime = 1;

    private double 自已重構後的版本(int time) {
        int primaryTime = Math.min(time, delayTime);// 這裡的時間部分還可以再調整，但有點雞助就算了
        int secondaryTime = time - delayTime;
        if (secondaryTime > 0) {
            double primaryVal = firstAcc() * delayTime;
            return calc(firstAcc(), primaryTime) + primaryVal * secondaryTime + calc(secondAcc(), secondaryTime);
        } else {
            return calc(firstAcc(), primaryTime);
        }
    }

    private int firstAcc() {
        return primaryForce / mass;
    }

    private int secondAcc() {
        return (primaryForce + secondaryForce) / mass;
    }

    private double calc(double acc, int time) {
        return 0.5 * acc * time * time;
    }

}
