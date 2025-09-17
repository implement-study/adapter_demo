package club.shengsheng.adapter_demo.charge;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class MacBook implements TypeCSocket {

    @Override
    public void connectTypeC() {
        System.out.println("连接了mac book type c");
    }
}
