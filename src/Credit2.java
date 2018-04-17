import java.util.Scanner;


public class Credit2 {

    public static void main(String[] args) {
        //Вводим сумму кредита
        System.out.println("Введите сумму кредита");
        double debt = Enter();
        //Вводим процентную ставку
        System.out.println("Введите процентную ставку");
        double mon = Monthly();
        //Считаем задолженность и обязательный платеж
        while (debt>150) {
            double pay = debt / 100 * mon; //Обязательный платеж
            if(pay < 150){
                pay = 150;
            }
            System.out.println("Задолженность: " + Math.round(debt));
            System.out.println("Обязательный платеж: " + Math.round(pay));
            debt = debt - pay;
        }
    }
    //Методы

    //Ввод данных
    public static double Enter() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    //Процентная ставка
    public static double Monthly() {
        Scanner sc2 = new Scanner(System.in);
        double st = sc2.nextDouble();
        return st / 12 + 5;
    }

}