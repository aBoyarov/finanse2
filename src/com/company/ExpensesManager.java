package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;

        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> l = expensesByCategories.get(category);
            l.add(expense);

        } else {
            ArrayList<Double> now = new ArrayList<>();
            now.add(expense);
            expensesByCategories.put(category, now);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String name : expensesByCategories.keySet()) {
            ArrayList<Double> value = expensesByCategories.get(name);
            System.out.println(name + value);
        }
    }


    double findMaxExpenseInCategory(String category) {

        double maxExpense = 0;
        if (expensesByCategories.containsKey(category))
            for (Double exp : expensesByCategories.get(category)) {
                if (exp > maxExpense) {
                    maxExpense = exp;
                }
            }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }
}


