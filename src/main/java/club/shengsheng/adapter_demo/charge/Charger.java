package club.shengsheng.adapter_demo.charge;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Charger {

    public void charge(UsbSocket usbSocket) {
        usbSocket.connectUsb();
        System.out.println("连接了USB 开始充电");
    }
}
