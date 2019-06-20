package designpattern.factory.origin;


import designpattern.factory.Operation;

/**
 * @author kundy
 * @date 2019/6/18 5:25 PM
 */
public class OperationMul extends Operation {

    @Override
    public double getResult() {
        return getValue1() * getValue2();
    }
}
