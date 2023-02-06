package learn.chapter2021.chapter03.chapter0322;

public interface IPayMode {
    boolean security(String uId);
    boolean security(PayBaseMessage message);
}
