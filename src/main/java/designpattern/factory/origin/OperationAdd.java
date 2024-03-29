package designpattern.factory.origin;


import designpattern.factory.Operation;

/**
 * @author kundy
 * @date 2019/6/18 5:23 PM
 */
public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        return getValue1() + getValue2();
    }
}
