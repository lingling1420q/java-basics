package designpattern.factory.simple;

import designpattern.factory.Operation;
import designpattern.factory.origin.OperationAdd;
import designpattern.factory.origin.OperationDiv;
import designpattern.factory.origin.OperationMul;
import designpattern.factory.origin.OperationSub;

/**
 * @author kundy
 * @date 2019/6/18 5:44 PM
 */
public class OperationFactory {

    public static Operation createOperation(String operation) {
        Operation oper = null;
        switch (operation) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            default:
                throw new UnsupportedOperationException("不支持该操作");
        }
        return oper;
    }

}
