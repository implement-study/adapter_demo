package club.shengsheng.adapter_demo.charge;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class TypeC2UsbAdapter implements UsbSocket {

    private final TypeCSocket typeCSocket;

    public TypeC2UsbAdapter(TypeCSocket typeCSocket) {
        this.typeCSocket = typeCSocket;
    }

    @Override
    public void connectUsb() {
        typeCSocket.connectTypeC();
        //  转换
        System.out.println("usb连接成功");
    }
}
