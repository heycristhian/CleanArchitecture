package br.com.heycristhian.cleanarchitecture.usecase;

public class ShowNotification {

    public void execute(String message) {
        System.out.println("Consuming: " + message);
    }
}
