package designpattern.strategy;

/**
 * @author kundy
 * @date 2019/5/31 4:33 PM
 */
public class Squeak implements Quack {

    @Override
    public void quack() {
        System.out.println("<Squeak>");
    }

}
