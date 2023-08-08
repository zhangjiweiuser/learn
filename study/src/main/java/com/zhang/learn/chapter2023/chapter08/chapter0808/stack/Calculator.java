package com.zhang.learn.chapter2023.chapter08.chapter0808.stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-08 16:12
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "700+2*6-40";
        // 先创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 声明变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = ' ';
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            // 先判断是不是符号
            ch = expression.charAt(index);
            if (operStack.isOper(ch)) {
                // 如果是符号，则要判断符号栈是否为空，为空则直接加入
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    // 如果不为空，则进行比较，如果当前操作符优先级小于等于符号栈操作符优先级，则从数栈中pop两个数，从符号栈中pop一个符号进行运算，
                    // 然后将结果再放入数栈中，将当前操作符放入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        // 如果当前操作符优先级大于符号栈中的优先级，则直接入栈
                        operStack.push(ch);
                    }
                }
            } else {
                // 如果是一个数，则直接入栈，但要多往后看一位，如果后以为不是数字了，则可以放入栈中
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {

                    if (operStack.isOper(expression.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if(index == expression.length()){
                break;
            }
        }
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("当前表达式为%s = %d",expression,numStack.pop());
    }
}

class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，用数组来模拟栈，数据放在这里
    private int top = -1; // top表示栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，该数据被丢弃，" + value);
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据。。。");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈stack[%d]=%d\n", i, stack[i]);
        }
    }

    // 返回运算符的优先级，优先级越高，返回的数字越大
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

}
