package designpattern.factory.factory;

import designpattern.factory.Operation;
import designpattern.factory.origin.OperationAdd;

/**
 * @author kundy
 * @date 2019/6/19 10:10 AM
 */
public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }

}
