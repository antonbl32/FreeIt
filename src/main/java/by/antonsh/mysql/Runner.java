package by.antonsh.mysql;

import by.antonsh.mysql.entity.Order;
import by.antonsh.mysql.service.ItemService;
import by.antonsh.mysql.service.OrderService;

import java.util.List;
/*
ИСПОЛЬЗОВАНИЕ КЛАССОВ И БИБЛИОТЕК3706. Заказ. В БД хранится информация о заказах
магазина и товарах в них.
Для заказа необходимо хранить:— номер заказа;— товары в заказе;— дату поступления.
Для товаров в заказе необходимо хранить:— товар;— количество.Для товара необходимо хранить:
— название;— описание;— цену.
• Вывести полную информацию о заданном заказе.
• Вывести номера заказов, сумма которых не превосходит заданную
и ко-личество различных товаров равно заданному.
• Вывести номера заказов, содержащих заданный товар.
• Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня.
• Сформировать новый заказ, состоящий из товаров, заказанных в теку-щий день.
• Удалить все заказы, в которых присутствует заданное количество задан-ного товара.
 */
public class Runner {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        OrderService orderService = new OrderService();
        System.out.println("Get order by id:");
        System.out.println(orderService.getOrderById(1));
        System.out.println("Get order less 100 and count of item less then 4:");
        System.out.println(orderService.getOrderLessPriceAndLessItemsOfCount(100,4));
        System.out.println("Get orders which have item with id 1: ");
        System.out.println(orderService.getOrdersWhichHaveItem(
                itemService.getItemById(1)));

    }
}
