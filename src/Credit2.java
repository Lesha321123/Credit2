import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Credit2 {

    public static void main(String[] args) {
        //Окно
        new NewFrame();
        //Число месяцев


        int i = 0;
        //Сегодняшняя дата
        Calendar data = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(data.getTime());
        System.out.println("Сегодня: " +  formatted);
        //Вводим сумму кредита
        System.out.println("Введите сумму кредита");
        double debt = Enter();
        //Вводим процентную ставку
        System.out.println("Введите процентную ставку");
        double mon = Monthly();
        //Считаем задолженность и обязательный платеж
        while (debt>150) {
            double pay = debt / 100 * mon; //Обязательный платеж
            if(pay > 150){
                i++;
                DayOfPayment(data);
                 }
            else {
                i++;
                pay = 150;
                DayOfPayment(data);
            }
            System.out.println("Задолженность: " + Math.round(debt));
            System.out.println("Обязательный платеж: " + Math.round(pay));
            debt = debt - pay;
            if(debt < 150){
                i++;
                DayOfPayment(data);
                pay = debt;
                System.out.println("Задолженность: " + Math.round(debt));
                System.out.println("Обязательный платеж: " + Math.round(pay));
                System.out.println("Общее количество месяцев: " + i);
                break;
            }
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
    //День выплаты
    public static void DayOfPayment(Calendar data) {
        data.add(Calendar.DAY_OF_MONTH, 50);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String formatted = format1.format(data.getTime());
        System.out.println("Дата выплаты: " +  formatted);
    }
}