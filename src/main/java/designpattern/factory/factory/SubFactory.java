package designpattern.factory.factory;


import designpattern.factory.Operation;
import designpattern.factory.origin.OperationSub;

/**
 * @author kundy
 * @date 2019/6/19 10:16 AM
 */
public class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
