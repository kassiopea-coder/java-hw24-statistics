package ru.netology.stats;

public class StatsService {

    public int amountSales(int[] sales) { //сумма всех продвж
        int amount = 0; //сумма всех продаж

        for (int sale : sales) {
            amount += sale;
        }
        return amount;
    }

    public int averageSales(int[] sales) { //средняя сумма продаж в месяц

        return  amountSales(sales) / sales.length;
    }

    public int maxSales(int[] sales) { //номер месяца с пиком продаж
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве

        for (int sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    public int minSales(int[] sales) { //номер месяца с минимумом продаж
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (int sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    public int averageSalesLow(int[] sales) { //кол-во месяцев ниже среднего
        int monthLow = 0;
        int average = averageSales(sales);

        for (int sale : sales) {
            if (sale < average) {
                monthLow ++;
            }
        }
        return monthLow;
    }

    public int averageSalesHigh(int[] sales) {  //кол-во месяцев выше среднего
        int monthHigh = 0;
        int average = averageSales(sales);

        for (int sale : sales) {
            if (sale > average) {
                monthHigh ++;
            }
        }
        return monthHigh;
    }
}
