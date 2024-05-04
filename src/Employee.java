import java.time.Year;

public class Employee {
    public String name;
    public double salary;
    public int workHours;
    public int hireYear;

    // Kurucu metot
    public Employee(String name, double salary,int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    // Vergi hesaplama
    public double tax() {
        if (salary <= 1000) {
            return 0; // Vergi yok
        } else {
            return salary * 0.03; // %3 vergi
        }
    }

    // Bonus hesaplama
    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30; // Her saat için 30 Tl bonus
        } else {
            return 0; //Bonus yok
        }
    }
    //Maaş artışı hesaplama
    public void raiseSalary() {
        int yearsWorked = Year.now().getValue() - hireYear;
        if (yearsWorked < 10) {
            salary *= 1.05; // %5 zam
        } else if (yearsWorked <20) {
            salary *= 1.10; //%10 zam
        } else {
            salary *= 1.15; //%15 zam
        }
    }

    // Bilgileri string olarak döndürme
    public String toString() {
        return "Employee{name='" +name+"',salary=" +salary+ ",workHours=" + workHours+"'hireYear=" + hireYear +'}';
    }

    public static void main(String[] args) {
        // örnek kullanım
        Employee emp = new Employee("John Doe", 1500,45,2015);
        System.out.println(emp); // Bilgileri yazdır
        System.out.println("Tax: " + emp.tax()); //Vergi hesapla ve yazdır
        System.out.println("Bonus: " + emp.bonus()); //Bonus hesapla  ve yazdır
        emp.raiseSalary(); // Maaş artışı uygula
        System.out.println("Update Salary: "+ emp.salary); //Güncellenmiş maaş
    }


}
