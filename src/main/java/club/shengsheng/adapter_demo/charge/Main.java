package club.shengsheng.adapter_demo.charge;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {

    public static void main(String[] args) {
        MacBook macBook = new MacBook();
        Charger charger = new Charger();
        TypeC2UsbAdapter adapter = new TypeC2UsbAdapter(macBook);
        charger.charge(adapter);

    }
}
