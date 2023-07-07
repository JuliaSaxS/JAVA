/* Подумать над структурой класса Ноутбук(или Единорогов) для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Переопределить toString, equals и hashCode(как на семинаре).
Вывести на печать экземпляры класса, сравнить пару экземпляров и найти один экземпляр в наборе.

Задание со звездочкой:
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */
package Home_Work_Java.HW_6;
import java.util.*;
public class Task_16 {
    private String name;
    private Integer ram; 
    private Integer hd; 
    private String os; 
    private String color; 
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    public Integer getRam() {
        return ram;
    }
    public void setHd(Integer hd) {
        this.hd = hd;
    }
    public Integer getHd() {
        return hd;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getOs() {
        return os;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public Task_16 (String name, Integer ram, Integer hd, String os, String color){
        this.name = name;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
        this.color = color;
    }
















































































































    @Override
    public String toString() {
        return name + "; " +
                "ОЗУ:" + ram +  "; " +
                "Диск: " + hd + "; " +
                "ОС: " + os + "; " +
                "цвет:" + color + "; ";
    }
}
