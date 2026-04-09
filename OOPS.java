public class OOPS {
    public static void main(String args[]){
    //    Pen p1 = new Pen();
    //    p1.color = "Blue";
    //    System.out.println(p1.color);

    //    p1.setTip(2);
    //    System.out.print(p1.tip);

    //    BankAccount b1 = new BankAccount();
    //    b1.setPassword("123132");
    //    System.out.println(b1.printPassword());
     
    Bear b1 = new Bear();
    b1.eats();

    }
}

interface Carnivorous {
    void eats();
}

interface Herbivorous {
    void eats();
}

class Bear implements Carnivorous, Herbivorous {
    public void eats() {
        System.out.println("Bear eats both plants and animals");
    }
}

class BankAccount {
    String accountNumber;
    private String password;

    void setPassword(String password){
        this.password = password;
    }

    public String printPassword(){
        return this.password;
    }

}

class Pen {

    String color;
    int tip;

    void setColor(String color){
        this.color = color;
    }

    void setTip(int tip){
        this.tip = tip;
    }

}