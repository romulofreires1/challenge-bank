package br.com.example.challengebank.model;

public enum MenuOption {
    CHECK_BALANCE(1),
    DEPOSIT(2),
    TRANSFER(3),
    EXIT(4);

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
